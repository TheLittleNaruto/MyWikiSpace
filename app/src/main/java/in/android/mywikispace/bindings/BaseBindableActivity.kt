package `in`.android.mywikispace.bindings

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

abstract class BaseBindableActivity: AppCompatActivity() {

    var baseViewModel: BaseViewModel? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseViewModel = getViewModel()
        baseViewModel?.onCreate()
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