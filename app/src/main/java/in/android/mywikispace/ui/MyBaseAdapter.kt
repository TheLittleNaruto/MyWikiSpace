package `in`.android.mywikispace.ui

import `in`.android.mywikispace.R
import `in`.android.mywikispace.api.model.Search
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MyBaseAdapter : RecyclerView.Adapter<MyBaseAdapter.MyBaseViewHolder>() {

    private var mSearchList:List<Search>?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyBaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.search_row_layout,parent,false)
        return MyBaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyBaseViewHolder, position: Int) {
        if(mSearchList != null)holder.update(mSearchList?.get(position))
    }

    fun setData(searchlist: List<Search>){
        mSearchList = searchlist
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        if(mSearchList != null)return mSearchList?.size!!
        return 0
    }

    class MyBaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var mTextView:TextView?=null

        init {
            mTextView = view.findViewById(R.id.mSearchTitle) as TextView
        }

        fun update(trendsItem: Search?) {
            mTextView?.text = trendsItem?.title
        }
}

}