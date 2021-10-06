package com.example.adamh_miniapp.screens

import android.app.Application
import com.example.adamh_miniapp.screens.di.AppComponent
import com.example.adamh_miniapp.screens.di.DaggerAppComponent

class App : Application() {
    lateinit var component: AppComponent
    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.create()
    }

    fun getAppComponent(): AppComponent = component

}