package com.example.cupcake.ui.flavor

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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cupcake.R
import com.example.cupcake.data.DataSource
import com.example.cupcake.ui.OrderUiState
import com.example.cupcake.ui.component.CupCakeAppBar
import com.example.cupcake.ui.component.CupcakeScreensTitles
import com.example.cupcake.ui.component.MyButtons
import com.example.cupcake.ui.component.RadioGroup2
import com.example.cupcake.ui.component.StatementSubtotal
import com.example.cupcake.ui.main.MainViewModel
import com.example.cupcake.ui.navigation.BaseRoute
import com.example.cupcake.ui.theme.CupcakeTheme

@Composable
fun FlavorScreen(
    navController: NavHostController,
    viewModel: MainViewModel= hiltViewModel()
) {
val uiState by viewModel.uiState.collectAsState()
    FlavorScreenContent(
        onNextClick = { navController.navigate(BaseRoute.PickUpDateScreen) },
        onCancelClick = { navController.navigate(BaseRoute.MainScreen) },
        onNavigateUp = {navController.navigateUp()},
        uiState = uiState
    )
}

@Composable
fun FlavorScreenContent(
    modifier: Modifier = Modifier,
    uiState: OrderUiState,
    onNextClick: () -> Unit = {},
    onCancelClick: () -> Unit = {},
    onNavigateUp:() ->Unit={},
    defaultColor: Color = Color.White,
    clickedColor: Color = colorResource(id = R.color.Purple740)
) {
    var buttonColor by remember { mutableStateOf(defaultColor) }
    val context= LocalContext.current
    val options=DataSource.flavors.map { id -> context.getString(id) }
    val selectedOption = remember { mutableStateOf(options[0]) }

    CupCakeAppBar(currentScreen = CupcakeScreensTitles.Flavor, navigateUp = onNavigateUp)
    Column(
        modifier = modifier
            .padding(top = 80.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RadioGroup2(
            options =options,
            selectedOption =selectedOption.value ,
            onOptionSelected ={selectedOption.value=it}
        )
        HorizontalDivider(thickness = 1.dp)
        StatementSubtotal(modifier = Modifier.padding(top = 16.dp),uiState.price)
        Row(
            modifier = Modifier
                .padding(top = 300.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            MyButtons(
                modifier = Modifier.weight(1f),
                text =  R.string.Cancel,
                onClick = {
                    onCancelClick()
                    buttonColor = clickedColor
                }
            )
            MyButtons(
                modifier = Modifier.weight(1f),
                text =  R.string.Next,
                onClick = {
                    onNextClick()
                    buttonColor = clickedColor
                }
            )
        }
    }

}


@Preview
@Composable
private fun FlavorScreenPreview() {
    CupcakeTheme {
        FlavorScreenContent(uiState =OrderUiState(price = "10"))
    }
}