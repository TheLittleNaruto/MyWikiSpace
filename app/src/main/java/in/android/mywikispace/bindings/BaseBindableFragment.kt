package `in`.android.mywikispace.bindings

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.arch.lifecycle.ViewModelProviders



abstract class BaseBindableFragment: Fragment() {

    var baseViewModel: BaseViewModel? = null;
    var viewDataBinding: ViewDataBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseViewModel = getViewModel();
    }

    fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceStat: Bundle?, @LayoutRes layoutResId: Int,
                     bindingVariable: Int,
                     viewModel: BaseViewModel): View? {

        baseViewModel = viewModel

        viewDataBinding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        viewDataBinding?.setVariable(bindingVariable, baseViewModel)
        viewDataBinding?.setLifecycleOwner(this)
        return viewDataBinding?.root
    }

    abstract fun getViewModel(): BaseViewModel

}