package `in`.android.mywikispace.ui.fragment

import `in`.android.mywikispace.R
import `in`.android.mywikispace.BR
import `in`.android.mywikispace.bindings.BaseBindableFragment
import `in`.android.mywikispace.bindings.BaseViewModel
import `in`.android.mywikispace.ui.viewmodel.HomeViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class HomeFragment: BaseBindableFragment() {
    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return onCreateView(inflater, container, savedInstanceState, R.layout.fragment_home, BR.homeViewModel, getViewModel())
    }


    override fun getViewModel(): BaseViewModel {
        return HomeViewModel()
    }
}