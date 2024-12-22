package com.example.cupcake.ui.navigation

import kotlinx.serialization.Serializable

sealed class BaseRoute {
    sealed class Graph : BaseRoute() {
        @Serializable
        data object Root : Graph()

        @Serializable
        data object MainScreen : Graph()
    }

    sealed class MainScreen : BaseRoute() {
        @Serializable
        data object onNumberOfCupcake : MainScreen()
    }

    @Serializable
    data object OrderScreen : BaseRoute()

    @Serializable
    data object FlavorScreen : BaseRoute()

    @Serializable
    data object PickUpDateScreen : BaseRoute()


}