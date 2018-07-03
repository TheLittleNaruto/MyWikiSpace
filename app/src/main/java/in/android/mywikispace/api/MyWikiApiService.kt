package `in`.android.mywikispace.api

import `in`.android.mywikispace.api.model.Response
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MyWikiApiService {

    // https://en.wikipedia.org/w/api.php?
    // action=query&list=search&srsearch=morelike:Featured
    // &srlimit=10&formatversion=2&format=json
    @GET("api.php")
    fun queryWiki(@Query("action") action: String, @Query("list") list: String,
                  @Query("srsearch") srsearch: String, @Query("srlimit") srlimit: Int,
                  @Query("formatversion") formatversion: Int, @Query("format") format: String) : Observable<Response>
}