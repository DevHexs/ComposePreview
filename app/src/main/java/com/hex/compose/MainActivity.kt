package com.hex.compose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hex.compose.ui.theme.ComposePreviewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePreviewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ActivityIntro()
                }
            }
        }
    }
}

@Composable
fun ButtonWithIcon(intent: Intent, titleResource: Int){
    val context = LocalContext.current
    Button(
        onClick = { context.startActivity(intent) },
        contentPadding = ButtonDefaults.TextButtonContentPadding
    ) {
        Text(
            text = stringResource(id = titleResource),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .widthIn(min = 124.dp)
        )
    }
}

@Composable
fun ActivityIntro() {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        Image(
            painter = painterResource(id = R.drawable.ic_black_hole),
            contentDescription = null,
            modifier = Modifier
                .padding(64.dp)
        )

        ButtonWithIcon(
            intent = Intent(context, HappyBirthdayActivity::class.java),
            titleResource = R.string.title_activity_happy_birthday)

        ButtonWithIcon(
            intent = Intent(context, BlackHoleActivity::class.java),
            titleResource = R.string.title_activity_black_hole)

        ButtonWithIcon(
            intent = Intent(context, TasksActivity::class.java),
            titleResource = R.string.title_activity_tasks)

        ButtonWithIcon(
            intent = Intent(context, ComposeDialActivity::class.java),
            titleResource = R.string.title_activity_compose_dial)
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview4() {
    ComposePreviewTheme {
        ActivityIntro()
    }
}