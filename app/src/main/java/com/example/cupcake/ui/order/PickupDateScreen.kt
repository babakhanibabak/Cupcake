package com.example.cupcake.ui.order

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cupcake.R
import com.example.cupcake.ui.component.CupCakeButton
import com.example.cupcake.ui.component.RadioGroup
import com.example.cupcake.ui.component.StatementSubtotal
import com.example.cupcake.ui.component.pickDate
import com.example.cupcake.ui.theme.CupcakeTheme

@Composable
fun PickUpDateScreen(
    modifier: Modifier = Modifier,
    uiState: OrderUiState,
    onOptionSelected: (String) -> Unit,
    onNextClick: () -> Unit = {},
    onCancelClick: () -> Unit = {},
) {
    val options = pickDate()
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RadioGroup(
            options = options,
            onOptionSelected = onOptionSelected,
        )
        HorizontalDivider(thickness = 1.dp)
        StatementSubtotal(modifier = Modifier.padding(top = 16.dp), subtotal = uiState.price)
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.Bottom,
        ) {
            CupCakeButton(
                modifier = Modifier.weight(1f),
                text = R.string.Cancel,
                onClick = onCancelClick,
            )
            CupCakeButton(
                modifier = Modifier.weight(1f),
                text = R.string.Next,
                enabled = uiState.date.isNotEmpty(),
                onClick = onNextClick,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PickUpDateScreenPreview() {
    CupcakeTheme {
        PickUpDateScreen(
            uiState = OrderUiState(),
            onOptionSelected = {},
        )
    }
}