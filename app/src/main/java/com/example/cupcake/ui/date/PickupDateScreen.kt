package com.example.cupcake.ui.date

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cupcake.R
import com.example.cupcake.ui.OrderUiState
import com.example.cupcake.ui.component.CupCakeAppBar
import com.example.cupcake.ui.component.CupCakeBaseScreen
import com.example.cupcake.ui.component.CupcakeScreensTitles
import com.example.cupcake.ui.component.CupCakeButton
import com.example.cupcake.ui.component.RadioGroup
import com.example.cupcake.ui.component.StatementSubtotal
import com.example.cupcake.ui.component.pickDate
import com.example.cupcake.ui.main.MainViewModel
import com.example.cupcake.ui.navigation.BaseRoute
import com.example.cupcake.ui.theme.CupcakeTheme

@Composable
fun PickUpDateScreen(
    navController: NavHostController,
    viewModel: MainViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    PickUpDateScreenContent(
        onCancelClick = { navController.navigate(BaseRoute.MainScreen) },
        onNextClick = { navController.navigate(BaseRoute.OrderScreen) },
        onNavigateUp = { navController.navigateUp() },
        uiState = uiState
    )
}

@Composable
fun PickUpDateScreenContent(
    modifier: Modifier = Modifier,
    uiState: OrderUiState,
    onNextClick: () -> Unit = {},
    onCancelClick: () -> Unit = {},
    onNavigateUp: () -> Unit = {},
    defaultColor: Color = Color.White,
    clickedColor: Color = colorResource(id = R.color.Purple740)
) {
    var buttonColor by remember { mutableStateOf(defaultColor) }
    val options = pickDate()

    val selectedOption = remember { mutableStateOf(options[0]) }

    CupCakeBaseScreen(
        topBar = {
            CupCakeAppBar(
                currentScreen = CupcakeScreensTitles.Pickup,
                navigateUp = onNavigateUp,
            )
        }
    ) {
        Column(
            modifier = modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RadioGroup(
                options = options,
                onOptionSelected = { selectedOption.value = it }
            )
            HorizontalDivider(thickness = 1.dp)
            StatementSubtotal(modifier = Modifier.padding(top = 16.dp), subtotal = uiState.price)
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.Bottom,
            ) {
                CupCakeButton(
                    modifier = Modifier.weight(1f),
                    text = R.string.Cancel,
                    onClick = {
                        onCancelClick()
                        buttonColor = clickedColor
                    }
                )
                CupCakeButton(
                    modifier = Modifier.weight(1f),
                    text = R.string.Next,
                    onClick = {
                        onNextClick()
                        buttonColor = clickedColor
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun PickUpDateScreenPreview() {
    CupcakeTheme {
        PickUpDateScreenContent(uiState = OrderUiState())
    }
}