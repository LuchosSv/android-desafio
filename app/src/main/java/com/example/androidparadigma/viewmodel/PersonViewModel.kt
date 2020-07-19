package com.example.androidparadigma.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.androidparadigma.data.Repository
import com.example.androidparadigma.data.local.LocalDataSource
import com.example.androidparadigma.data.local.PersonDatabase
import com.example.androidparadigma.data.local.PersonEntity
import com.example.androidparadigma.data.remote.RemoteDataSource
import kotlinx.coroutines.launch

class PersonViewModel (private val applicationContext: Context): ViewModel(){

    private val dao = PersonDatabase.getInstance(applicationContext).PersonDao()
    private val repository = Repository(LocalDataSource(dao), RemoteDataSource())

    //get object person of database
    val localPersonList: LiveData<PersonEntity> = repository.getPersonLocalRepository()

    //insert object person in database
    fun insertLocalPerson(id: Int, nombre: String, apellido: String, ocupacion: String, nacimiento: String){
        viewModelScope.launch {
            repository.insertLocalRepositoryPerson(PersonEntity(id = id, nombre = nombre, apellido = apellido, ocupacion = ocupacion, nacimiento = nacimiento))
        }
    }

    class PersonListViewModelFactory(private val app: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PersonViewModel::class.java)) {
                return PersonViewModel(app) as T
            }
            throw IllegalArgumentException("Invalid Viewmodel")
        }
    }

}