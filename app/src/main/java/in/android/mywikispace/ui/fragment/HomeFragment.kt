package `in`.android.mywikispace.ui.fragment

import `in`.android.mywikispace.BR
import `in`.android.mywikispace.R
import `in`.android.mywikispace.api.model.Search
import `in`.android.mywikispace.bindings.BaseBindableFragment
import `in`.android.mywikispace.bindings.BaseViewModel
import `in`.android.mywikispace.ui.MainActivityView
import `in`.android.mywikispace.ui.MyBaseAdapter
import `in`.android.mywikispace.ui.viewmodel.HomeViewModel
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class HomeFragment: BaseBindableFragment(),MainActivityView {

    var homeAdapter: MyBaseAdapter?=null
    private var homePageList: RecyclerView?=null

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = onCreateView(inflater, container, savedInstanceState, R.layout.fragment_home, BR.homeViewModel, getViewModel())
        homePageList = view?.findViewById(R.id.homePageList) as RecyclerView
        homeAdapter = MyBaseAdapter()
        homePageList?.adapter = homeAdapter
        return view
    }

    override fun load(searchList: List<Search>) {
        for (item: Search in searchList){
            Log.d("HomeFragment",item.title)
        }
        homeAdapter?.setData(searchList)
    }

    override fun error(e: Throwable) {
    }

    override fun error() {
    }

    override fun getViewModel(): BaseViewModel {
        return HomeViewModel(this)
    }
}