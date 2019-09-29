package com.devsparkle.githubexplorer

import android.app.Application
import com.devsparkle.githubexplorer.di.component.DaggerAppComponent
import com.facebook.stetho.Stetho
import dagger.android.HasAndroidInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject
import dagger.android.AndroidInjector

class App : Application(), HasAndroidInjector  {

    @set:Inject
    var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>? = null


    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        DaggerAppComponent.create()
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector!!
    }
}