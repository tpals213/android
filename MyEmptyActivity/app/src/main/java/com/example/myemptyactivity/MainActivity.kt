package com.example.myemptyactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myemptyactivity.ui.theme.MyEmptyActivityTheme

class MainActivity : ComponentActivity() {

    val viewModel : MyStudyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyEmptyActivityTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String,
             viewModel: MyStudyViewModel,
             modifier: Modifier = Modifier) {

    // var text by remember { mutableStateOf("입력하세요") }
    var text : String by viewModel.text
    var image: Int by viewModel.image

//    fun changeName(name: String): Unit {
//        text = "이름은 " + name
//    }


    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hello $name!",
                textAlign = TextAlign.Center
            )
            Row {
                Button(
                    modifier = Modifier.padding(end = 8.dp),
                    onClick = {viewModel.changeName("1번 장세민")}
                ) {
                    Text(text = stringResource(R.string.button1))
                }
                Button(
                    modifier = Modifier.padding(end = 8.dp),
                    onClick = {viewModel.changeName("2번 가족원")}
                ) {
                    Text(text = stringResource(R.string.button2))
                }
            }
            Row {
                Button(
                    modifier = Modifier.padding(end = 8.dp),
                    onClick = {viewModel.changeName("3번 친구들")}
                ) {
                    Text(text = stringResource(R.string.button3))
                }
                Button(
                    modifier = Modifier.padding(end = 8.dp),
                    onClick = {viewModel.changeName("4번 친척들")}
                ) {
                    Text(text = stringResource(R.string.button4))
                }
            }
            OutlinedTextField(
                modifier = Modifier.padding(all = 16.dp),
                value = text,
                onValueChange = { text = it},
                textStyle = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Green
                ),
                label = {Text("입력")},
                placeholder = {Text("이름을 입력하세요")}
            )
            Image(
                painter = painterResource(id = image),
                contentDescription = "dog",
                modifier = Modifier.height(128.dp).width(128.dp)
                // modifier = Modifier.size(240.dp)
                // modifier = Modifier.scale(1.5f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyEmptyActivityTheme {
        Greeting("Android", viewModel = MyStudyViewModel())
    }
}

