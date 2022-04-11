package ru.otus.daggerhomework.components

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.ViewModelReceiver

@Module
interface FragmentReceiverModule {
    @Binds
    @IntoMap
    @ViewModelKey(ViewModelReceiver::class)
    fun bindViewModuleReceiver(viewModelReceiver: ViewModelReceiver): ViewModel
}