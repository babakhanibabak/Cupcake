package com.example.cupcake.ui.summary

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text
import com.example.cupcake.R
import com.example.cupcake.data.OrderUiState
import com.example.cupcake.ui.component.CupCakeAppBar
import com.example.cupcake.ui.component.CupcakeScreensTitles
import com.example.cupcake.ui.component.StatementSubtotal
import com.example.cupcake.ui.theme.CupcakeTheme

@Composable
fun OrderSummaryScreen(
    modifier: Modifier = Modifier,
    onCancelClicked: () -> Unit={},
    onSendOrderClicked: () -> Unit={},
    orderUiState: OrderUiState= OrderUiState()
) {
    val resources = LocalContext.current.resources
    val numberOfCupCakes = resources.getQuantityString(
        R.plurals.cupcakes,
        orderUiState.quantity,
        orderUiState.quantity
    )
    val orderSummary = stringResource(
        id = R.string.order_details,
        numberOfCupCakes,
        orderUiState.flavor,
        orderUiState.date,
        orderUiState.quantity

    )
    val items = listOf(
        Pair(stringResource(R.string.quantity), numberOfCupCakes),
        Pair(stringResource(id = R.string.flavor), orderUiState.flavor),
        Pair(stringResource(id = R.string.pickup_date), orderUiState.date)
    )
    CupCakeAppBar(currentScreen = CupcakeScreensTitles.Summary)
    Column(
        modifier = modifier
            .padding(top = 100.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
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
        StatementSubtotal(modifier = Modifier.align(Alignment.End), subtotal = orderUiState.price)
    }
}


@Preview
@Composable
private fun OrderSummaryScreenPreview() {
    CupcakeTheme {
        OrderSummaryScreen()
    }
}