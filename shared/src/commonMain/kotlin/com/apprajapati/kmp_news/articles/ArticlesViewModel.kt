package com.apprajapati.kmp_news.articles

import com.apprajapati.kmp_news.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel: BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> =  MutableStateFlow(ArticlesState(loading = true))

    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    init{
        getArticles()
    }

    private fun getArticles(){
        scope.launch {
            delay(500)
            val fetched = fetchArticles()
            _articlesState.emit(ArticlesState(articles = fetched))
        }
    }

    private fun fetchArticles(): List<Article>{
        return mockArticles
    }

}

data class ArticlesState (
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error : String = ""
)


//mock data
private val mockArticles = listOf(
    Article("Stock market1",
        "Whatever data that can be added 1",
        "2024-11-09",
        "https://cdn.shopify.com/s/files/1/0533/2089/files/img-url-filter.jpg?v=1515074624"),

    Article("Stock market2",
        "Whatever data that can be added 2",
        "2024-11-09",
        "https://cdn.shopify.com/s/files/1/0533/2089/files/img-url-filter.jpg?v=1515074624"),

    Article("Stock market3",
        "Whatever data that can be added 3",
        "2024-11-09",
        "https://cdn.shopify.com/s/files/1/0533/2089/files/img-url-filter.jpg?v=1515074624"),
)