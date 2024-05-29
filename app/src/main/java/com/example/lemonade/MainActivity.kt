package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeImageWithText(modifier: Modifier = Modifier) {
    var tapsCount by remember { mutableStateOf(0) }
    var currentImage = R.drawable.lemon_tree
    var currentDescriptor = R.string.lemon_tree
    var currentText = R.string.lemon_tree_content_description

    when(tapsCount) {
        0 -> {
            currentImage = R.drawable.lemon_tree
            currentText = R.string.lemon_tree
            currentDescriptor = R.string.lemon_tree_content_description
        }
        in 1..5 -> {
            currentImage = R.drawable.lemon_squeeze
            currentText = R.string.lemon
            currentDescriptor = R.string.lemon_content_description
        }
        6 -> {
            currentImage = R.drawable.lemon_drink
            currentText = R.string.lemonade_full
            currentDescriptor = R.string.lemonade_full_content_description
        }
        else -> {
            currentImage = R.drawable.lemon_restart
            currentText = R.string.lemonade_empty
            currentDescriptor = R.string.lemonade_empty_content_description
        }
    }

    Column (modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(border = BorderStroke(2.dp, Color(105, 205, 216)), onClick = {
            tapsCount++
            if(tapsCount > 7) tapsCount = 0
        }) {
            Image(
                painter = painterResource(id = currentImage),
                contentDescription = stringResource(currentDescriptor)
            )
        }
        Spacer(modifier = Modifier.height(36.dp))
        Text(
            text = stringResource(currentText),
            fontSize = 18.sp
        )
    }
}

@Preview
@Composable
fun LemonadeApp() {
    LemonadeImageWithText(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}