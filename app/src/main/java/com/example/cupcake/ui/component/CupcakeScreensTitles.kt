package com.example.cupcake.ui.component

import androidx.annotation.StringRes
import com.example.cupcake.R

enum class CupcakeScreensTitles (@StringRes val title:Int){
    Start(title = R.string.app_name),
    Flavor(title = R.string.choose_flavor),
    Pickup(title = R.string.choose_pickup_date),
    Summary(title = R.string.order_summary)
}

