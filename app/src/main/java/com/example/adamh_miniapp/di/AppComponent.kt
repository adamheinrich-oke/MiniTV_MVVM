package com.example.adamh_miniapp.di

import com.example.adamh_miniapp.data.DataModule
import com.example.adamh_miniapp.di.viewmodel.ViewModelFactory
import com.example.adamh_miniapp.di.viewmodel.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ViewModelModule::class,
        DataModule::class,
    ])
interface AppComponent {

    val factory: ViewModelFactory
}