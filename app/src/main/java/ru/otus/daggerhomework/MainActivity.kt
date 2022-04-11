package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.components.DaggerMainActivityComponent
import ru.otus.daggerhomework.components.MainActivityComponent

class MainActivity : AppCompatActivity() {

    lateinit var activityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityComponent = DaggerMainActivityComponent
            .factory()
            .create(this, (application as App).appComponent)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, FragmentProducer())
            .add(R.id.fragment_container, FragmentReceiver())
            .commit()

    }
}