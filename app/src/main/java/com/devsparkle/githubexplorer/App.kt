package com.devsparkle.githubexplorer

import android.app.Application
import com.devsparkle.githubexplorer.di.component.DaggerAppComponent
import dagger.android.HasAndroidInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject
import dagger.android.AndroidInjector

class App : Application(), HasAndroidInjector  {

    @set:Inject
    var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>? = null


    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.create()
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector!!
    }
}