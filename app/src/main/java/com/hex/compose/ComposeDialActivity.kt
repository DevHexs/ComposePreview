package com.hex.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hex.compose.ui.theme.ComposePreviewTheme

class ComposeDialActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePreviewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DialBodyCompose()
                }
            }
        }
    }
}

@Composable
fun InfoCard(title: String, message: String, color: Color, modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = message,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun DialBodyCompose() {

    Column(Modifier.fillMaxWidth()){
        Row(Modifier.weight(1f)) {
            InfoCard(
                title = stringResource(id = R.string.title_text),
                message = stringResource(id = R.string.body_text),
                color = Color.Magenta,
                modifier = Modifier.weight(1f)
            )
            InfoCard(
                title = stringResource(id = R.string.title_text),
                message = stringResource(id = R.string.body_text),
                color = Color.Green,
                modifier = Modifier.weight(1f)
            )
        }

        Row(Modifier.weight(1f)) {
            InfoCard(
                title = stringResource(id = R.string.title_text),
                message = stringResource(id = R.string.body_text),
                color = Color.Yellow,
                modifier = Modifier.weight(1f)
            )
            InfoCard(
                title = stringResource(id = R.string.title_text),
                message = stringResource(id = R.string.body_text),
                color = Color.Red,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview3() {
    ComposePreviewTheme {
        DialBodyCompose()
    }
}