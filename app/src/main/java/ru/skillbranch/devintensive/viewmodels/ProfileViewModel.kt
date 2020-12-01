package ru.skillbranch.devintensive.viewmodels

import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.skillbranch.devintensive.models.Profile
import ru.skillbranch.devintensive.repositories.PreferencesRepository

/**
 * Created by Drygin Nikita on 30,Ноябрь,2020
 */
class ProfileViewModel : ViewModel() {

    private val repository = PreferencesRepository
    private val profileData = MutableLiveData<Profile>()
    private val appTheme = MutableLiveData<Int>()

    init {
        profileData.value = repository.getProfile()
        appTheme.value = repository.getAppTheme()
    }

    fun getProfileData(): LiveData<Profile> = profileData

    fun getAppTheme(): LiveData<Int> = appTheme

    fun saveProfileDate(profile: Profile) {
        repository.saveProfile(profile)
        profileData.value = profile
    }

    fun switchTheme() {
        if (appTheme.value == AppCompatDelegate.MODE_NIGHT_YES)
            appTheme.value = AppCompatDelegate.MODE_NIGHT_NO
        else
            appTheme.value = AppCompatDelegate.MODE_NIGHT_YES

        repository.saveAppTheme(appTheme.value!!)
    }
}