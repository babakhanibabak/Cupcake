package com.example.cupcake.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cupcake.R
import com.example.cupcake.ui.component.CupCakeAppBar
import com.example.cupcake.ui.component.CupcakeScreensTitles
import com.example.cupcake.ui.component.MyButtons
import com.example.cupcake.ui.navigation.BaseRoute
import com.example.cupcake.ui.theme.CupcakeTheme

@Composable
fun MainScreen(
    navController: NavHostController,
    viewModel: MainViewModel = hiltViewModel()
) {
    MainScreenContent(
        onOneCupcakeClick = {
            viewModel.setQuantity(1)
            navController.navigate(BaseRoute.FlavorScreen)
        },
        onSixCupcakesClick = {
            viewModel.setQuantity(6)
            navController.navigate(BaseRoute.FlavorScreen)
        },
        onTwelveCupcakesClick = {
            viewModel.setQuantity(12)
            navController.navigate(BaseRoute.FlavorScreen)
        },
    )
}

@Composable
fun MainScreenContent(
    modifier: Modifier = Modifier,
    onOneCupcakeClick: () -> Unit = {},
    onSixCupcakesClick: () -> Unit = {},
    onTwelveCupcakesClick: () -> Unit = {}
) {
    CupCakeAppBar(currentScreen = CupcakeScreensTitles.Flavor, canNavigateBack = false)
    Column(
        modifier = modifier
            .padding(top = 100.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.cake), contentDescription = "")
        Text(
            modifier = Modifier.padding(top = 20.dp),
            text = stringResource(id = R.string.order_cupcake)
        )
        MyButtons(
            modifier = Modifier
                .padding(top = 300.dp)
                .fillMaxWidth(),
            text = stringResource(id = R.string.One_cupcake),
            onClick = onOneCupcakeClick
        )
        MyButtons(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            text = stringResource(id = R.string.Six_cupcake),
            onClick = onSixCupcakesClick
        )
        MyButtons(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            text = stringResource(id = R.string.Twelve_cupcakes),
            onClick = onTwelveCupcakesClick
        )

    }
}


@Preview
@Composable
private fun MainScreenPreview() {
    CupcakeTheme {
        MainScreenContent(
        )
    }
}