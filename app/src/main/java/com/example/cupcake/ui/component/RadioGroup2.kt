package com.example.cupcake.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.cupcake.R

@Composable
fun<T> RadioGroup2(
    modifier: Modifier = Modifier,
    options:List<T>,
    selectedOption: T,
    onOptionSelected: (T) -> Unit,
    textMapper: (T) -> String = { it.toString() },
    radioColor: androidx.compose.ui.graphics.Color = colorResource(id = R.color.Purple740)
    ) {
    Column(modifier = modifier
        .fillMaxWidth()
        .padding(4.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
        options.forEach { option ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedOption == option,
                    onClick = { onOptionSelected(option) },
                    colors = RadioButtonDefaults.colors(radioColor)
                )
                Text(textMapper(option),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 8.dp)
                    )
            }
        }
    }

}