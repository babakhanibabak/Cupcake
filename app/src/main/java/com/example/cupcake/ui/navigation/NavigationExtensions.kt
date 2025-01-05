package com.example.cupcake.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.example.cupcake.R

@Composable
fun NavBackStackEntry.findCurrentRoute(): BaseRoute? {
    return when (destination.route) {
        BaseRoute.MainScreen::class.java.canonicalName -> BaseRoute.MainScreen
        BaseRoute.FlavorScreen::class.java.canonicalName -> BaseRoute.FlavorScreen
        BaseRoute.PickUpDateScreen::class.java.canonicalName -> BaseRoute.PickUpDateScreen
        BaseRoute.OrderScreen::class.java.canonicalName -> BaseRoute.OrderScreen
        else -> null
    }
}

fun NavHostController.navigateToMainScreen() = navigate(BaseRoute.MainScreen) {
    popUpTo(BaseRoute.MainScreen) {
        inclusive = true
    }
}

fun BaseRoute.getScreenTitleResId(): Int? {
    return when (this) {
        BaseRoute.MainScreen -> return R.string.app_name
        BaseRoute.FlavorScreen -> return R.string.choose_flavor
        BaseRoute.PickUpDateScreen -> return R.string.choose_pickup_date
        BaseRoute.OrderScreen -> return R.string.order_summary
        else -> null
    }
}