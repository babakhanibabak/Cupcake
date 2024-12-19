package com.example.cupcake.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun pickDate (): List<String> {
    val dateOptions = mutableListOf<String>()
    val formatter = SimpleDateFormat("E  MMM d", Locale.getDefault())
    val calendar = Calendar.getInstance()
    repeat(4) {
        dateOptions.add(formatter.format(calendar.time))
        calendar.add(Calendar.DATE, 1)
    }
    return dateOptions
}

@Composable
fun PickDateColumn() {
    val dateOptions = pickDate() // Call the pickDate function to get the list of dates

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), // Add padding around the column
        verticalArrangement = Arrangement.spacedBy(8.dp) // Add spacing between rows
    ) {
        dateOptions.forEach { dateOption ->
            Text(
                text = dateOption,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp) // Add padding around each Text
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPickDateColumn() {
    PickDateColumn()
}