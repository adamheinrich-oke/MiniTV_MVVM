package com.example.adamh_miniapp.screens.di

import com.example.adamh_miniapp.screens.search.SearchTitleFragment
import dagger.Component

@PerSearchTitle
@Component(dependencies = [AppComponent::class])
interface SearchTitleComponent {
    fun inject(fragment: SearchTitleFragment)

}