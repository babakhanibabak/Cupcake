package com.example.cupcake.ui.order

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
import androidx.compose.ui.unit.dp
import androidx.core.util.Pair
import com.example.cupcake.R
import com.example.cupcake.ui.component.CupCakeButton

@Composable
fun StartOrderScreen(
    modifier: Modifier = Modifier,
    onCupcakeClick: (Int) -> Unit = {},
    quantityOptions: List<Pair<Int, Int>>,
) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.weight(1f),
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
        }
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