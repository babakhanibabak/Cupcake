package com.example.cupcake.ui

import android.content.Intent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cupcake.data.DataSource
import com.example.cupcake.ui.component.CupCakeAppBar
import com.example.cupcake.ui.component.CupCakeBaseScreen
import com.example.cupcake.ui.navigation.BaseRoute
import com.example.cupcake.ui.navigation.findCurrentRoute
import com.example.cupcake.ui.navigation.getScreenTitleResId
import com.example.cupcake.ui.navigation.navigateToMainScreen
import com.example.cupcake.ui.order.FlavorScreen
import com.example.cupcake.ui.order.OrderSummaryScreen
import com.example.cupcake.ui.order.OrderViewModel
import com.example.cupcake.ui.order.PickUpDateScreen
import com.example.cupcake.ui.order.StartOrderScreen

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: OrderViewModel = hiltViewModel(),
    navController: NavHostController = rememberNavController(),
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()

    // Get current destination
    val currentDestination = backStackEntry?.findCurrentRoute() ?: BaseRoute.MainScreen

    CupCakeBaseScreen(
        modifier = modifier,
        topBar = {
            CupCakeAppBar(
                titleResId = currentDestination.getScreenTitleResId(),
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = navController::navigateUp,
            )
        }
    ) {
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        NavHost(
            modifier = Modifier.fillMaxSize(),
            navController = navController,
            route = BaseRoute.Route::class,
            startDestination = BaseRoute.MainScreen,
        ) {
            composable<BaseRoute.MainScreen> {
                StartOrderScreen(
                    quantityOptions = DataSource.quantityOptions,
                    onCupcakeClick = {
                        viewModel.setQuantity(it)
                        navController.navigate(BaseRoute.FlavorScreen)
                    },
                )
            }
            composable<BaseRoute.FlavorScreen> {
                FlavorScreen(
                    uiState = uiState,
                   onOptionSelected = {
                       viewModel.setFlavor(it)
                   },
                    onCancelClick = {
                        navController.cancelOrderAndNavigateToStart(viewModel)
                    },
                    onNextClick = {
                        navController.navigate(BaseRoute.PickUpDateScreen)
                    }
                )
            }
            composable<BaseRoute.PickUpDateScreen> {
                PickUpDateScreen(
                    uiState = uiState,
                    onOptionSelected = {
                        viewModel.setDate(it)
                    },
                    onCancelClick = {
                        navController.cancelOrderAndNavigateToStart(viewModel)
                    },
                    onNextClick = {
                        navController.navigate(BaseRoute.OrderScreen)
                    }
                )
            }
            composable<BaseRoute.OrderScreen> {
                OrderSummaryScreen(
                    uiState = uiState,
                    onCancelClicked = {
                        navController.cancelOrderAndNavigateToStart(viewModel)
                    },
                    onSendOrderClicked = { context, subject, message ->
                        // TODO: implement sending order
                        val intent = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(Intent.EXTRA_SUBJECT, subject)
                            putExtra(Intent.EXTRA_TEXT, message)
                        }
                        // Verify there's an app that can handle the intent
                        if (intent.resolveActivity(context.packageManager) != null) {
                            context.startActivity(intent)
                        }
                    }
                )
            }
        }
    }
}

private fun NavHostController.cancelOrderAndNavigateToStart(viewModel: OrderViewModel) {
    viewModel.resetOrder()
    navigateToMainScreen()
}

