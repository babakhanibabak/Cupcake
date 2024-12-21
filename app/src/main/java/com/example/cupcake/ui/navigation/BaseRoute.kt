package com.example.cupcake.ui.navigation

import kotlinx.serialization.Serializable

sealed class BaseRoute {
    sealed class Graph : BaseRoute() {
        @kotlinx.serialization.Serializable
        data object Root : Graph()

        @kotlinx.serialization.Serializable
        data object MainScreen : Graph()
    }
@Serializable
    sealed class MainScreen : BaseRoute() {
        @kotlinx.serialization.Serializable
        data object onNumberOfCupcake : MainScreen()
    }

    @kotlinx.serialization.Serializable
    data object OrderScreen : BaseRoute()

    @kotlinx.serialization.Serializable
    data object FlavorScreen : BaseRoute()

    @Serializable
    data object PickUpDateScreen : BaseRoute()


}