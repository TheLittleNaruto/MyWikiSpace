package `in`.android.mywikispace.ui.fragment

import `in`.android.mywikispace.R
import `in`.android.mywikispace.BR
import `in`.android.mywikispace.bindings.BaseBindableFragment
import `in`.android.mywikispace.bindings.BaseViewModel
import `in`.android.mywikispace.bindings.adapter.BindingAdapters
import `in`.android.mywikispace.ui.viewmodel.HomeViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: BaseBindableFragment() {
    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        baseViewModel = getViewModel();
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return onCreateView(inflater, container, savedInstanceState, R.layout.fragment_home, BR.homeViewModel, this.baseViewModel!!)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        BindingAdapters.bindAdapter(home_rv, (baseViewModel as HomeViewModel).adapter)
        (baseViewModel as HomeViewModel).loadData()
    }


    override fun getViewModel(): BaseViewModel {
        return ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }
}