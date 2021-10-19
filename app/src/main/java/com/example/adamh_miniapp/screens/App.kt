package com.example.adamh_miniapp.screens

import android.app.Application
import com.example.adamh_miniapp.di.AppComponent
import com.example.adamh_miniapp.di.DaggerAppComponent

class App : Application() {

    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.create()
    }

    fun getAppComponent(): AppComponent = component
}