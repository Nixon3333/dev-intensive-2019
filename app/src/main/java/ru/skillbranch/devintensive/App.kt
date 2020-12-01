package ru.skillbranch.devintensive

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import ru.skillbranch.devintensive.repositories.PreferencesRepository

/**
 * Created by Drygin Nikita on 30,Ноябрь,2020
 */
class App: Application() {
    companion object{
        private var instance: App? = null

        fun applicationContext(): Context = instance!!.applicationContext
    }

    init {
        instance = this
    }

    override fun onCreate() {
        setTheme(R.style.SplashTheme)
        super.onCreate()
    }
}