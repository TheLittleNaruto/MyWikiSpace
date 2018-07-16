package `in`.android.mywikispace.ui.viewmodel

import `in`.android.mywikispace.api.MyWikiApiManager
import `in`.android.mywikispace.bindings.BaseViewModel
import `in`.android.mywikispace.ui.MainActivityView
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel(): BaseViewModel() {

    private var disposable: Disposable? = null
    var view: MainActivityView?=null

    constructor(mView: MainActivityView):this(){
        view = mView
    }

    override fun onCreate() {

    }
    override fun onResume() {
        disposable = MyWikiApiManager().getTopPicks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { response -> view?.load(response.query?.search!!) },
                        //{ response -> "${response.query?.search}" },
                        { error -> Log.d("HomeViewModel",error.message) }
                )
    }

    override fun onPause() {
        disposable?.dispose()
    }

    override fun onDestroy() {

    }
}