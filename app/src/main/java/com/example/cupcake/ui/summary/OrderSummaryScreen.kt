package com.example.cupcake.ui.summary

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.wear.compose.material.Text
import com.example.cupcake.R
import com.example.cupcake.ui.OrderUiState
import com.example.cupcake.ui.component.CupCakeAppBar
import com.example.cupcake.ui.component.CupCakeBaseScreen
import com.example.cupcake.ui.component.CupcakeScreensTitles
import com.example.cupcake.ui.component.CupCakeButton
import com.example.cupcake.ui.component.StatementSubtotal
import com.example.cupcake.ui.main.MainViewModel
import com.example.cupcake.ui.navigation.BaseRoute
import com.example.cupcake.ui.theme.CupcakeTheme

@Composable
fun OrderSummaryScreen(
    navController: NavHostController,
    viewModel: MainViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    OrderSummaryScreenContent(
        onCancelClicked = { navController.navigate(BaseRoute.MainScreen) },
        // onSendOrderClicked = {navController.navigate(BaseRoute.)},
        onNavigateUp = { navController.navigateUp() },
        uiState = uiState
    )
}

@Composable
fun OrderSummaryScreenContent(
    modifier: Modifier = Modifier,
    uiState: OrderUiState,
    onCancelClicked: () -> Unit = {},
    onSendOrderClicked: (String, String) -> Unit = { _: String, _: String -> },
    onNavigateUp: () -> Unit = {}
) {
    val resources = LocalContext.current.resources
    val numberOfCupCakes = resources.getQuantityString(
        R.plurals.cupcakes,
        uiState.quantity,
        uiState.quantity
    )
    val orderSummary = stringResource(
        id = R.string.order_details,
        numberOfCupCakes,
        uiState.flavor,
        uiState.date,
        uiState.quantity

    )
    val newOrder = stringResource(id = R.string.new_cupcake_order)
    val items = listOf(
        Pair(stringResource(R.string.quantity), numberOfCupCakes),
        Pair(stringResource(id = R.string.flavor), uiState.flavor),
        Pair(stringResource(id = R.string.pickup_date), uiState.date)
    )

    CupCakeBaseScreen(
        topBar = {
            CupCakeAppBar(
                currentScreen = CupcakeScreensTitles.Summary,
                navigateUp = onNavigateUp,
            )
        }
    ) {
        Column(
            modifier = modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items.forEach { item ->
                Text(text = item.first.uppercase())
                Text(text = item.second, fontWeight = FontWeight.Bold)
                HorizontalDivider(thickness = 1.dp)
            }
            Spacer(modifier = Modifier.size(8.dp))
            StatementSubtotal(modifier = Modifier.align(Alignment.End), uiState.price)
            Column(
                modifier = modifier
                    .weight(1f)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
            ) {
                CupCakeButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = R.string.send,
                    onClick = { onSendOrderClicked(newOrder, orderSummary) })
                CupCakeButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = R.string.cancel,
                    onClick = onCancelClicked
                )
            }
        }
    }
}


@Preview
@Composable
private fun OrderSummaryScreenPreview() {
    CupcakeTheme {
        OrderSummaryScreenContent(
            uiState = OrderUiState(
                0, "Text", "Text", "300.00"
            ),
            onSendOrderClicked = { _: String, _: String -> },
            onCancelClicked = {},
            modifier = Modifier.fillMaxHeight()
        )
    }
}