package `in`.android.mywikispace.api

import `in`.android.mywikispace.api.model.Response
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MyWikiApiManager {

    val BASE_URL = "https://en.wikipedia.org/w/"

    private var myWikiApiService: MyWikiApiService

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(OkHttpClient())
                .build()

        myWikiApiService = retrofit.create(MyWikiApiService::class.java)
    }

    fun getTopPicks(): Observable<Response> {
        return myWikiApiService.queryWiki("query", "search", "morelike:Featured", 10, 2, "json")
    }

}