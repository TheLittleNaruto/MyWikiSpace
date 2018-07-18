package `in`.android.mywikispace.ui.viewmodel

import `in`.android.mywikispace.api.MyWikiApiManager
import `in`.android.mywikispace.api.model.Response
import `in`.android.mywikispace.api.model.Search
import `in`.android.mywikispace.bindings.BaseViewModel
import `in`.android.mywikispace.ui.adapter.HomeAdapter
import android.util.Log
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.rxkotlin.subscribeBy


class HomeViewModel: BaseViewModel() {

    private val TAG = HomeViewModel::class.java.simpleName

    private var myWikiApiManager: MyWikiApiManager = MyWikiApiManager();
    private var homeItemViewModelList: MutableList<HomeItemViewModel> = ArrayList();

    val adapter: HomeAdapter

    init {
        adapter = HomeAdapter(homeItemViewModelList)
    }

    fun loadData() {

        myWikiApiManager.getTopPicks()
                .subscribeOn(Schedulers.io()) //To run on background thread
                .flatMap { t: Response -> Observable.fromIterable(t.query?.search) }
                .compose(homeItemVMTransformer)
                .observeOn(AndroidSchedulers.mainThread())//To get the data on main thread
                .subscribeBy (
                        onNext = { homeItemViewModelList.add(it) },
                        onError  = {},
                        onComplete = {
                            updateAdapter(homeItemViewModelList)
                        }
                )

    }

    private fun updateAdapter(homeItemViewModelList: MutableList<HomeItemViewModel>){
        Log.d(TAG, "Size of top picks is: " + homeItemViewModelList.size)
        adapter.notifyDataSetChanged()
    }


    var homeItemVMTransformer: ObservableTransformer<Search, HomeItemViewModel>
            = ObservableTransformer { upstream -> upstream.map { HomeItemViewModel(it) } }

}