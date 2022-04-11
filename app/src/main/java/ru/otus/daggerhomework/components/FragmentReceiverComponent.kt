package ru.otus.daggerhomework.components

import dagger.Component
import ru.otus.daggerhomework.FragmentReceiver

@FragmentScope
@Component(modules = [FragmentReceiverModule::class], dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {
    fun inject(receiver: FragmentReceiver)
}