package com.example.mystudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mystudy.ui.theme.MyStudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyStudyTheme {
                // Scaffold(modifier = Modifier.fillMaxSize()) {
                Surface {
                    var result: String = practice()
                    ResultScreen(result)
                }
            }
        }
    }
}

@Composable
fun ResultScreen(result: String){
    Column {
        Text("$result",
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Blue
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ResultScreenPreview(){
    MyStudyTheme {
        ResultScreen("Android")
    }
}