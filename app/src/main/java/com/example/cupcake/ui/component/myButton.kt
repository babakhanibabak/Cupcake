package com.example.cupcake.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cupcake.R
import com.example.cupcake.ui.theme.CupcakeTheme

@Composable
fun MyButtons(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(),
    @StringRes text: Int,
    onClick: () -> Unit,
    shape: Shape=RoundedCornerShape(15.dp),
    color: Color?=null
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = shape,
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Purple740))
    ) {
        Row(
            modifier = Modifier.padding(contentPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = stringResource(id = text),
                style = TextStyle(fontFamily = FontFamily.Serif, color = Color.White, fontSize = 20.sp)
            )
        }
    }
}
//
//@Preview
//@Composable
//private fun MyButtonsPreview() {
//    CupcakeTheme {
//        MyButtons(
//            text = stringResource(id = R.string.One_cupcake),
//            onClick = {},
//            shape = RoundedCornerShape(15.dp),
//           color = Color.Blue
//        )
//    }
//}