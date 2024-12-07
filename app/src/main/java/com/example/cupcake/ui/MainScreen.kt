package com.example.cupcake.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.cupcake.ui.theme.CupcakeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onCupcakeClick: () -> Unit = {},
    onSixCupcakesClick: () -> Unit = {},
    onTwelveCupcakesClick: () -> Unit = {}
) {
    Scaffold(modifier = modifier.padding()) { paddingValues ->
        TopAppBar(modifier = Modifier
            .padding(paddingValues)
            .background(color = Color.Blue),
            colors = TopAppBarDefaults.topAppBarColors( containerColor = Color.Blue),
            title = { Text(text = "Cupcake") })
    }
}


@Preview
@Composable
private fun MainScreenPreview() {
    CupcakeTheme {
        MainScreen()
    }
}