package com.devsparkle.githubexplorer.presentation.screen.base

import androidx.lifecycle.Lifecycle

interface BaseContract {

    interface View {

    }

    interface Presenter<V : View> {

        fun attachLifecycle(lifecycle: Lifecycle)

        fun detachLifecycle(lifecycle: Lifecycle)

        fun attachView(view: V)

        fun detachView()

        fun getView(): V

        fun onPresenterCreate()

        fun onPresenterDestroy()
    }
}