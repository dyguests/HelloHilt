package com.fanhl.hellohilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fanhl.hellohilt.ui.theme.HelloHiltTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloHiltTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel = hiltViewModel<MailViewModel>()
                    LazyColumn {
                        items(List(100) { it }) {
                            Greeting("Item$it", viewModel)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, viewModel: MailViewModel) {
    //    val viewModel = hiltViewModel<MailViewModel>()
    Text(
        text = "Hello $name ${viewModel.hi}!",
        modifier = Modifier.padding(8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloHiltTheme {
        Greeting("Android", hiltViewModel<MailViewModel>())
    }
}