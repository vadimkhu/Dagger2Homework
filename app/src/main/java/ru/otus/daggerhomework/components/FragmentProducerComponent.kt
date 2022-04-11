package ru.otus.daggerhomework.components

import dagger.Component
import ru.otus.daggerhomework.FragmentProducer

@FragmentScope
@Component(modules = [FragmentProducerModule::class], dependencies = [MainActivityComponent::class])
interface FragmentProducerComponent {
    fun inject(producer: FragmentProducer)
}
