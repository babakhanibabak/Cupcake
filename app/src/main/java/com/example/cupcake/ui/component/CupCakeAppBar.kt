package com.example.cupcake.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.cupcake.R
import com.example.cupcake.ui.theme.CupcakeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CupCakeAppBar(
    @StringRes titleResId: Int?,
    modifier: Modifier = Modifier,
    canNavigateBack: Boolean = true,
    navigateUp: () -> Unit = {}
) {
    TopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(containerColor = colorResource(id = R.color.Pink)),
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "",
                    )
                }
            }
        },
        title = {
            Text(
                text = titleResId?.let { stringResource(it) } ?: "",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
        }
    )
}

@Preview
@Composable
private fun CupCakeAppBarPreview() {
    CupcakeTheme {
        CupCakeAppBar(titleResId = R.string.app_name)
    }
}