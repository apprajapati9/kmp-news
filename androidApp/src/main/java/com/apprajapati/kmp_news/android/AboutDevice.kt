package com.apprajapati.kmp_news.android

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.apprajapati.kmp_news.Platform

@Composable
fun AboutScreen(){
    Column {
        Toolbar()
        ContentView()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(){
    TopAppBar(title = { Text(text = "About device") })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentView() {
    val items = makeItems()

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items) {
            row ->
            RowView(title = row.first,
                subtitle = row.second)
        }
    }
}

private fun makeItems(): List<Pair<String, String>> {
    val platform = Platform()
    platform.logSystemInfo()

    return listOf(Pair("OS ", platform.osName),
        Pair("Device", platform.deviceModel),
        Pair("Density", platform.density.toString())
    )
}

@Composable
fun RowView(title: String,
            subtitle: String ){
    Column(Modifier.padding(8.dp)) {
        Text(text = title,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray)

        Text(text = subtitle,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Black)

        Divider()
    }
}