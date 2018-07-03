package `in`.android.mywikispace.bindings.adapter

import android.databinding.BindingAdapter
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class BindingAdapters {

    @BindingAdapter("toggleLayoutManager")
    fun toggleLayoutManager(recyclerView: RecyclerView, isGrid: Boolean){
        val lM: RecyclerView.LayoutManager
        if(isGrid != null && isGrid){
            lM = GridLayoutManager(recyclerView.context, 2)
        }else{
            lM = LinearLayoutManager(recyclerView.context)
        }
        recyclerView.layoutManager = lM
    }
}