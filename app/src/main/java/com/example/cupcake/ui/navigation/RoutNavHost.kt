package com.example.cupcake.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cupcake.ui.date.PickUpDateScreen
import com.example.cupcake.ui.flavor.FlavorScreen
import com.example.cupcake.ui.main.MainScreen
import com.example.cupcake.ui.summary.OrderSummaryScreen

@Composable
fun RootNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        route = BaseRoute.Route::class,
        startDestination = BaseRoute.MainScreen,
    ) {
        composable<BaseRoute.MainScreen> {
            MainScreen(navController = navController)
        }
        composable<BaseRoute.FlavorScreen> {
            FlavorScreen(
                navController = navController
            )
        }
        composable<BaseRoute.OrderScreen> {
            OrderSummaryScreen(
                navController = navController
            )
        }
        composable<BaseRoute.PickUpDateScreen> {
            PickUpDateScreen(
                navController = navController
            )
        }
    }
}