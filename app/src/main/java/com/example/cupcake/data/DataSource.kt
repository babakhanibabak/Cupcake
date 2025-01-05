package com.example.cupcake.data

import androidx.core.util.Pair
import com.example.cupcake.R

object DataSource {
    val flavors = listOf(
        R.string.vanilla,
        R.string.chocolate,
        R.string.red_velvet,
        R.string.salted_caramel,
        R.string.coffee
    )
    val quantityOptions = listOf(
        Pair(R.string.One_cupcake, 1),
        Pair(R.string.Six_cupcake, 6),
        Pair(R.string.Twelve_cupcakes, 12)
    )
}

