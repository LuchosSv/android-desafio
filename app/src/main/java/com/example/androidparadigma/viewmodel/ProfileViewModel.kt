package com.example.androidparadigma.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.androidparadigma.data.Repository
import com.example.androidparadigma.data.local.LocalDataSource
import com.example.androidparadigma.data.local.PersonDatabase
import com.example.androidparadigma.data.remote.PostsEntity
import com.example.androidparadigma.data.remote.RemoteDataSource
import kotlinx.coroutines.launch

class ProfileViewModel (private val applicationContext: Context): ViewModel(){

    private val dao = PersonDatabase.getInstance(applicationContext).PersonDao()
    private val repository = Repository(LocalDataSource(dao), RemoteDataSource())

    val localPostListProfile: LiveData<List<PostsEntity>> = repository.getListPostLocal()

    fun deleteLocalUser(postsEntity: PostsEntity){
        viewModelScope.launch {
            repository.deletePostsLocal(postsEntity)
        }
    }

    class ProfileViewModelFactory(private val app: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
                return ProfileViewModel(app) as T
            }
            throw IllegalArgumentException("Invalid Viewmodel")
        }
    }

}