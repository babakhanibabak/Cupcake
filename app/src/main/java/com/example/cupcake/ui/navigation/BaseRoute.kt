package com.example.cupcake.ui.navigation

import kotlinx.serialization.Serializable

sealed class BaseRoute {

    @Serializable
    data object Route : BaseRoute()

    @Serializable
    data object MainScreen : BaseRoute()

    @Serializable
    data object OrderScreen : BaseRoute()

    @Serializable
    data object FlavorScreen : BaseRoute()

    @Serializable
    data object PickUpDateScreen : BaseRoute()
}