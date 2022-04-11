package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.components.ApplicationContext
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Named

class ViewModelReceiver @Inject constructor(
    @ApplicationContext private val context: Context,
    private val state: MutableStateFlow<Int>
) : ViewModel() {

    private var updateColor: Job? = null

    fun observeColors(action: ((Int) -> Unit)?) {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        updateColor = viewModelScope.launch {
            state.collect {
                Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
                action?.invoke(it)
            }
        }
    }

    fun stopObserving() {
        updateColor?.cancel()
    }
}