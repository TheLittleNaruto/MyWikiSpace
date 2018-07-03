package `in`.android.mywikispace.api.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import `in`.android.mywikispace.api.model.Search
import `in`.android.mywikispace.api.model.Searchinfo
import `in`.android.mywikispace.api.model.Continue


class Response {

    @SerializedName("batchcomplete")
    @Expose
    var batchcomplete: String? = null
    @SerializedName("continue")
    @Expose
    var `continue`: Continue? = null
    @SerializedName("query")
    @Expose
    var query: Query? = null

}



class Search {

    @SerializedName("ns")
    @Expose
    var ns: Int? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("pageid")
    @Expose
    var pageid: Int? = null
    @SerializedName("size")
    @Expose
    var size: Int? = null
    @SerializedName("wordcount")
    @Expose
    var wordcount: Int? = null
    @SerializedName("snippet")
    @Expose
    var snippet: String? = null
    @SerializedName("timestamp")
    @Expose
    var timestamp: String? = null

}

class Searchinfo {

    @SerializedName("totalhits")
    @Expose
    var totalhits: Int? = null

}

class Continue {

    @SerializedName("sroffset")
    @Expose
    var sroffset: Int? = null
    @SerializedName("continue")
    @Expose
    var `continue`: String? = null

}

class Query {

    @SerializedName("searchinfo")
    @Expose
    var searchinfo: Searchinfo? = null
    @SerializedName("search")
    @Expose
    var search: List<Search>? = null

}