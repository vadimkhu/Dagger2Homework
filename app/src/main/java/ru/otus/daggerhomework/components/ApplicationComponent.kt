package ru.otus.daggerhomework.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named
import javax.inject.Qualifier
import javax.inject.Scope
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {
    @ApplicationContext
    fun provideAppContext(): Context

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @ApplicationContext context: Context): ApplicationComponent
    }
}

@Scope
annotation class ActivityScope

@Scope
annotation class FragmentScope

@Qualifier
annotation class ApplicationContext