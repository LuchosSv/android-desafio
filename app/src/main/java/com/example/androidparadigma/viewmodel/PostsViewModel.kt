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
import com.example.androidparadigma.util.ERROR
import com.example.androidparadigma.util.LOADING
import com.example.androidparadigma.util.SUCCESS
import kotlinx.coroutines.launch
import java.lang.Exception

class PostsViewModel(private val applicationContext: Context) : ViewModel() {

    //reference of dao and repository
    private val dao = PersonDatabase.getInstance(applicationContext).PersonDao()
    private val repository = Repository(LocalDataSource(dao), RemoteDataSource())

    //live data to list of posts
    private val _postsList = MutableLiveData<List<PostsResponse>>()
    val postsList: LiveData<List<PostsResponse>>
        get() = _postsList

    //live data to object posts go detail
    private val _postsById = MutableLiveData<PostsResponse>()
    val postsById: LiveData<PostsResponse>
        get() = _postsById

    //live data for status of the app
    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

    //live data for error message
    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    fun insertPostsLocal(postsEntity: PostsEntity) {
        viewModelScope.launch {
            repository.insertPostsLocal(postsEntity)
        }
    }

    init {
        getPostList()
    }

    //get list of posts
    private fun getPostList() {
        viewModelScope.launch {
            _status.value = LOADING
            try {
                _postsList.value = repository.getPostListRemote()
                _status.value = SUCCESS
            } catch (e: Exception) {
                _status.value = ERROR
                _errorMessage.value = e.message
            }
        }
    }

    //get object posts with argument
    fun getProfileData(id: Int) {
        viewModelScope.launch {
            try {
                _postsById.value = repository.getPostsByIdRemote(id)
                Log.i("viewModel", "Success by id")
            } catch (e: Exception) {
                Log.e("viewModel, Profile", "Error by id, ${e.message}")
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