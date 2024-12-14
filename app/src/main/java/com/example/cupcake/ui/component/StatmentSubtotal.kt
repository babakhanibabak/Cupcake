package com.example.cupcake.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cupcake.R
import com.example.cupcake.ui.theme.CupcakeTheme
import java.util.Locale

@Composable
fun StatementSubtotal(
    modifier: Modifier = Modifier,
    subtotal: String = "24"
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            modifier = Modifier.padding(end = 12.dp),
            text = stringResource(id = R.string.Subtotal),
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 25.sp
        )
        Text(
            text = "$${String.format(Locale("%.2f"), subtotal)}",
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 25.sp
        )
    }
}

@Preview
@Composable
private fun StatementSubtotalPreview() {
    CupcakeTheme {
        StatementSubtotal()
    }
}