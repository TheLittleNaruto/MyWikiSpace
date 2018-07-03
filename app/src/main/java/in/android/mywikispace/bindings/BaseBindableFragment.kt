package `in`.android.mywikispace.bindings

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

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

    override fun onResume() {
        super.onResume()
        baseViewModel?.onResume()
    }

    override fun onPause() {
        super.onPause()
        baseViewModel?.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        baseViewModel?.onDestroy()
    }

    abstract fun getViewModel(): BaseViewModel

}