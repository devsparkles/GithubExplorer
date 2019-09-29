package com.devsparkle.githubexplorer.presentation.screen.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket
import javax.inject.Inject

open class BasePresenter<V : BaseContract.View>: BaseContract.Presenter<V> {

    // LifeCycle code and view injection code
    @Inject
    lateinit var view: V

    // end of  LifeCycle code


    // start of in background thanks to disposable code, because every network call should be done not in the uiThread
    private val disposable: CompositeDisposable = CompositeDisposable()

    fun <T> fetch(single: Single<T>, success: (T) -> Unit, error: (Throwable) -> Unit = {}) {
        disposable.add(
            single
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(success, error)
        )
    }

    fun <T> fetch(maybe: Maybe<T>, success: (T) -> Unit, error: (Throwable) -> Unit = {}) {
        disposable.add(
            maybe
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(success, error)
        )
    }

    fun <T> fetch(flowable: Flowable<T>, success: (T) -> Unit, error: (Throwable) -> Unit = {}) {
        disposable.add(
            flowable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(success, error)
        )
    }

    fun complete(
        completable: Completable,
        success: () -> Unit = {},
        error: (Throwable) -> Unit = {}
    ) {
        disposable.add(
            completable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(success, error)
        )
    }

    fun clear() {
        disposable.clear()
    }

    //
}