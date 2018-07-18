package `in`.android.mywikispace.bindings.adapter

import `in`.android.mywikispace.ui.adapter.HomeAdapter
import android.databinding.BindingAdapter
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class BindingAdapters {

    companion object {

        @JvmStatic @BindingAdapter("toggleLayoutManager")
        fun toggleLayoutManager(recyclerView: RecyclerView, isGrid: Boolean){
            val lM: RecyclerView.LayoutManager
            if(isGrid != null && isGrid){
                lM = GridLayoutManager(recyclerView.context, 2)
            }else{
                lM = LinearLayoutManager(recyclerView.context)
            }
            recyclerView.layoutManager = lM
        }

        @BindingAdapter("adapter")
        fun bindAdapter(rv: RecyclerView, adapter: RecyclerView.Adapter<out RecyclerView.ViewHolder>) {
            rv.adapter = adapter
        }
    }

}