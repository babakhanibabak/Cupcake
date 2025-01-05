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
import androidx.core.util.Pair
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cupcake.R
import com.example.cupcake.data.DataSource.quantityOptions
import com.example.cupcake.ui.component.CupCakeAppBar
import com.example.cupcake.ui.component.CupCakeBaseScreen
import com.example.cupcake.ui.component.CupcakeScreensTitles
import com.example.cupcake.ui.component.CupCakeButton
import com.example.cupcake.ui.navigation.BaseRoute
import com.example.cupcake.ui.theme.CupcakeTheme

@Composable
fun MainScreen(
    navController: NavHostController,
    viewModel: MainViewModel = hiltViewModel(),
) {
    MainScreenContent(
        quantityOptions = quantityOptions,
        onCupcakeClick = { quantity ->
            viewModel.setQuantity(quantity)
            navController.navigate(BaseRoute.FlavorScreen)
        }
    )
}

@Composable
fun MainScreenContent(
    modifier: Modifier = Modifier,
    onCupcakeClick: (Int) -> Unit = {},
    quantityOptions: List<Pair<Int, Int>>,
) {
    CupCakeBaseScreen(
        topBar = {
            CupCakeAppBar(
                currentScreen = CupcakeScreensTitles.Flavor,
                canNavigateBack = false,
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
            Image(
                painter = painterResource(id = R.drawable.cake),
                contentDescription = "",
            )
            Text(
                modifier = Modifier.padding(top = 20.dp),
                text = stringResource(id = R.string.order_cupcake),
            )
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Bottom,
            ) {
                quantityOptions.forEach { item ->
                    CupCakeButton(
                        text = item.first,
                        onClick = {
                            onCupcakeClick(item.second)
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    CupcakeTheme {
        MainScreenContent(
            quantityOptions = quantityOptions,
            onCupcakeClick = {},
        )
    }
}