package com.devsparkle.githubexplorer.presentation.screen.base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.annotation.Nullable
import javax.inject.Inject

abstract class BaseActivity<V: BaseContract.View, P: BaseContract.Presenter<V>> : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var presenter : P



    @CallSuper
    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        presenter.attachLifecycle(lifecycle)
        presenter.attachView(this as V)

    }

    override fun androidInjector(): AndroidInjector<Any>? {
        return androidInjector
    }
}