package com.hex.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hex.compose.ui.theme.ComposePreviewTheme

class HappyBirthdayActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePreviewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BirthdayGreetingWithImage(
                        title = getString(R.string.home_title),
                        message = getString(R.string.home_message))
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithImage(title: String, message: String){

    val imageBlackHole = painterResource(id = R.drawable.bg_blackhole)
    Box{
        Image(
            painter = imageBlackHole,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
                contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(title = title, message = message)
    }
}

@Composable
fun BirthdayGreetingWithText(title: String, message: String){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(
            text = title,
            fontSize = 24.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
        )
        Text(
            text = message,
            fontSize = 18.sp,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End)
                .padding(end = 16.dp)
        )
    }
}

@Preview(name = "Home", showSystemUi = true)
@Composable
fun BirthdayCardPreview(){
    ComposePreviewTheme{
        BirthdayGreetingWithImage(
            title = "Happy Birthday Gildo!!!",
            message = "From Hex")
    }
}