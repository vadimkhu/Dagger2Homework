package ru.otus.daggerhomework.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Named
import javax.inject.Qualifier

@ActivityScope
@Component(modules=[MainActivityModule::class], dependencies=[ApplicationComponent::class])
interface MainActivityComponent {
    @ActivityContext
    fun provideActivityContext(): Context

    @ApplicationContext
    fun provideAppContext(): Context

    fun provideState(): MutableStateFlow<Int>

    @Component.Factory
    interface Factory {
        fun create(@ActivityContext @BindsInstance context: Context, appComponent: ApplicationComponent): MainActivityComponent
    }
}

@Qualifier
annotation class ActivityContext