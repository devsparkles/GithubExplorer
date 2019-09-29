package com.devsparkle.githubexplorer.presentation.screen.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver

open class BasePresenter<V : BaseContract.View>: BaseContract.Presenter<V>, LifecycleObserver {

    // LifeCycle code and view injection code
    internal var view: V? = null
        private set

    val isViewAttached: Boolean
        get() = view != null

    override fun attachLifecycle(lifecycle: Lifecycle) = lifecycle.addObserver(this)
    override fun detachLifecycle(lifecycle: Lifecycle) = lifecycle.removeObserver(this)
    override fun attachView(view: V) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    override fun onPresenterCreate() {
    }

    override fun onPresenterDestroy() {

    }

    override fun getView(): V = view!!

    // end of  LifeCycle code
}