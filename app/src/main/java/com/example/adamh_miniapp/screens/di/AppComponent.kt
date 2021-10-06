package com.example.adamh_miniapp.screens.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class])

interface AppComponent {
    fun getViewModelFactory(): ViewModelFactory
}