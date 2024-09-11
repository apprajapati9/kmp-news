package com.apprajapati.kmp_news.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apprajapati.kmp_news.Platform
import com.apprajapati.kmp_news.android.screens.AboutScreen
import com.apprajapati.kmp_news.android.screens.ArticlesScreen
import com.apprajapati.kmp_news.articles.ArticlesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val info = Platform().osName

        val articlesModel : ArticlesViewModel by viewModels()

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(Modifier.padding(8.dp).fillMaxSize()) {
                       // GreetingView("Hello Ajay $info")
                       // AboutScreen()
                        ArticlesScreen(articlesViewModel = articlesModel)
                    }

                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
