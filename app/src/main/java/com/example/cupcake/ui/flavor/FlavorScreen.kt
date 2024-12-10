package com.example.cupcake.ui.flavor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cupcake.R
import com.example.cupcake.ui.component.MyButtons
import com.example.cupcake.ui.component.RadioGroup
import com.example.cupcake.ui.component.StatementSubtotal
import com.example.cupcake.ui.theme.CupcakeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlavorScreen(
    modifier: Modifier = Modifier,
    onNextClick: () -> Unit = {},
    onCancelClick: () -> Unit = {},
    onBackClick: () -> Unit = {},
    defaultcolor:Color=Color.White,
    clickedColor:Color= colorResource(id = R.color.Purple740)
) {
    var buttonColor by remember { mutableStateOf(defaultcolor) }
    Scaffold(modifier = modifier.padding()) { paddingValues ->
        TopAppBar(modifier = Modifier
            .padding(paddingValues)
            .background(color = Color.Blue),
            colors = TopAppBarDefaults.topAppBarColors(containerColor = colorResource(id = R.color.Pink)),
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
                }
            },
            title = { Text(text = "Choose Flavor") })
        Column(
            modifier = Modifier
                .padding(top = 80.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RadioGroup()
            HorizontalDivider(thickness = 1.dp)
            StatementSubtotal(modifier = Modifier.padding(top = 16.dp))
            Row(
                modifier = Modifier
                    .padding(top = 380.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                MyButtons(
                    modifier = Modifier.weight(1f),
                    text = stringResource(id = R.string.Cancel),
                    onClick = {onCancelClick()
                        buttonColor =clickedColor }
                )
                MyButtons(
                    modifier = Modifier.weight(1f),
                    text = stringResource(id = R.string.Next),
                    onClick = {onNextClick()
                            buttonColor =clickedColor}
                )
            }
        }

    }
}

@Preview
@Composable
private fun FlavorScreenPreview() {
    CupcakeTheme {
        FlavorScreen()
    }
}