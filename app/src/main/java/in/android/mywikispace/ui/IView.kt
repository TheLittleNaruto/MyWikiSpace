package `in`.android.mywikispace.ui

import `in`.android.mywikispace.api.model.Search

interface IView {
    abstract fun error(e: Throwable)
    abstract fun error()
}

interface MainActivityView : IView {
    abstract fun load(searchList: List<Search>)
}