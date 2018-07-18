package `in`.android.mywikispace.ui.adapter

import `in`.android.mywikispace.R
import `in`.android.mywikispace.databinding.HomeListItemViewBinding
import `in`.android.mywikispace.ui.viewmodel.HomeItemViewModel
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.databinding.DataBindingUtil



class HomeAdapter(topPicksItems: MutableList<HomeItemViewModel>): RecyclerView.Adapter<HomeAdapter.HomeListItemViewHolder>() {

    var topPicks: MutableList<HomeItemViewModel> = topPicksItems

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListItemViewHolder {
        val dataBinding = DataBindingUtil.inflate<HomeListItemViewBinding>(LayoutInflater.from(parent.context),
                R.layout.home_list_item_view, parent, false)
        return HomeListItemViewHolder(dataBinding)
    }

    override fun getItemCount(): Int {
        return topPicks.size;
    }

    override fun onBindViewHolder(holder: HomeListItemViewHolder, position: Int) {
        holder.dataBinding.homeItemViewModel = topPicks.get(position)
        holder.dataBinding.executePendingBindings()
    }


    class HomeListItemViewHolder(itemView: HomeListItemViewBinding) : RecyclerView.ViewHolder(itemView.getRoot()) {
        var dataBinding: HomeListItemViewBinding
            internal set

        init {
            dataBinding = itemView
        }
    }

}