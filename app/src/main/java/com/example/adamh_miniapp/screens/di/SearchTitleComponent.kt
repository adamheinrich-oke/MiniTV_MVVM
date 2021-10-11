package com.example.adamh_miniapp.screens.di

import com.example.adamh_miniapp.di.AppComponent
import com.example.adamh_miniapp.screens.search.SearchTitleFragment
import dagger.Component

@SearchTitleScope
@Component(dependencies = [AppComponent::class])
interface SearchTitleComponent {
    fun inject(fragment: SearchTitleFragment)
}