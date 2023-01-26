package com.hex.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hex.compose.ui.theme.ComposePreviewTheme

class BlackHoleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePreviewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BlackHoleBody()
                }
            }
        }
    }
}

@Composable
fun BlackHoleBody() {
    val titleImg = painterResource(id = R.drawable.bg_blackhole)
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        Image( painter = titleImg, contentDescription = null)
        BlackHoleText()
    }
}

@Composable
fun BlackHoleText(){

    Text(
        text = stringResource(id = R.string.blackhole_title),
        fontSize = 24.sp,
        modifier = Modifier
            .padding(all = 16.dp))

    Text(
        text = stringResource(id = R.string.blackhole_desc),
        textAlign = TextAlign.Justify,
        fontSize = 16.sp,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp))

    Text(text = stringResource(id = R.string.blackhole_body),
        textAlign = TextAlign.Justify,
        fontSize = 16.sp,
        modifier = Modifier
            .padding(all = 16.dp))
}

@Preview(name = "Modulo Preview", showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposePreviewTheme {
        BlackHoleBody()
    }
}