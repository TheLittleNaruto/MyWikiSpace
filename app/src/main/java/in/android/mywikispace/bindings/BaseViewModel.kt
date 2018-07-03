package `in`.android.mywikispace.bindings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class BaseViewModel {

    abstract fun onCreate()
    abstract fun onResume()
    abstract fun onPause()
    abstract fun onDestroy()

    open fun onCreateView(inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle) {

    }
}