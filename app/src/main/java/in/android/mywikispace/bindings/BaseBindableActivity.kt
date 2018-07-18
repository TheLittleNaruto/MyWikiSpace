package `in`.android.mywikispace.bindings

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

abstract class BaseBindableActivity: AppCompatActivity() {

    var baseViewModel: BaseViewModel? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseViewModel = getViewModel()
    }

    abstract fun getViewModel(): BaseViewModel

}