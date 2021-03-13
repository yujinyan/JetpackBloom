package com.example.androiddevchallenge.ui.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

@Composable
fun TextWithPaddingFromBaseline(
    text: String,
    paddingTop: Dp,
    style: TextStyle?
) {
    Box {
        if (style != null) {
            Text(text, Modifier.paddingFromBaseline(paddingTop), style = style)
        } else {
            Text(text, Modifier.paddingFromBaseline(paddingTop))
        }
    }
}