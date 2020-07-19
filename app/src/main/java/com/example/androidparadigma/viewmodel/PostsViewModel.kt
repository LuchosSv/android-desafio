package com.example.androidparadigma.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.example.androidparadigma.data.Repository
import com.example.androidparadigma.data.local.LocalDataSource
import com.example.androidparadigma.data.local.PersonDatabase
import com.example.androidparadigma.data.remote.PostsEntity
import com.example.androidparadigma.data.remote.RemoteDataSource
import com.example.androidparadigma.model.PostsResponse
import kotlinx.coroutines.launch
import java.lang.Exception

class PostsViewModel(private val applicationContext: Context): ViewModel(){

    private val dao = PersonDatabase.getInstance(applicationContext).PersonDao()
    private val repository = Repository(LocalDataSource(dao), RemoteDataSource())

    private val _postsList = MutableLiveData<List<PostsResponse>>()
    val postsList: LiveData<List<PostsResponse>>
        get() = _postsList

    val localPostsList: LiveData<List<PostsEntity>> = repository.getListPostsLocal()

    init {
        getPostList()
    }

    private fun getPostList() {
        viewModelScope.launch {
            try {
                _postsList.value = repository.getPostListRemote()
                Log.i("viewModel", "Success")
            } catch (e: Exception) {
                Log.e("viewModel", "Error, ${e.message}")
            }
        }
    }

    class PostsViewModelFactory(private val app: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PostsViewModel::class.java)) {
                return PostsViewModel(app) as T
            }
            throw IllegalArgumentException("Invalid Viewmodel")
        }
    }


}