package com.example.adamh_miniapp.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.adamh_miniapp.di.viewmodel.ViewModelKey
import com.example.adamh_miniapp.screens.search.SearchTitleViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @Binds
    @Singleton
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @Singleton
    @IntoMap
    @ViewModelKey(SearchTitleViewModel::class)
    abstract fun splashViewModel(viewModel: SearchTitleViewModel): ViewModel
}