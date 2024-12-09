package com.example.cupcake.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.cupcake.R
import com.example.cupcake.ui.theme.CupcakeTheme

@Composable
fun RadioGroup(
    modifier: Modifier = Modifier
) {
    val options = listOf("Vanilla","Chocolate","Red Velvet","Salted Caramel","Coffee")
    val selectedOption = remember { mutableStateOf(options[0]) }

    Column(modifier = modifier.fillMaxWidth()) {
        options.forEach { option ->
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                RadioButton(
                    selected = selectedOption.value == option,
                    onClick = { selectedOption.value = option },
                    colors = RadioButtonDefaults.colors(colorResource(id = R.color.Purple740))
                )
                Text(option)
            }
        }
    }
}


@Preview
@Composable
private fun RadioGroupPreview() {
    CupcakeTheme {
        RadioGroup()
    }
}