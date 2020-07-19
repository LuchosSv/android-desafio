package com.example.androidparadigma.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.example.androidparadigma.data.Repository
import com.example.androidparadigma.data.local.LocalDataSource
import com.example.androidparadigma.data.local.PersonDatabase
import com.example.androidparadigma.data.remote.RemoteDataSource
import com.example.androidparadigma.model.CommentsResponse
import com.example.androidparadigma.model.PostsResponse
import kotlinx.coroutines.launch
import java.lang.Exception

class CommentsViewModel (private val applicationContext: Context): ViewModel(){

    private val dao = PersonDatabase.getInstance(applicationContext).PersonDao()
    private val repository = Repository(LocalDataSource(dao), RemoteDataSource())

    private val _commentsList = MutableLiveData<List<CommentsResponse>>()
    val commentsList: LiveData<List<CommentsResponse>>
        get() = _commentsList

    init {
        getCommentsList()
    }

    //get list of posts
    private fun getCommentsList() {
        viewModelScope.launch {
            try {
                _commentsList.value = repository.getComments()
                Log.i("viewModel", "Success comment")
            } catch (e: Exception) {
                Log.e("viewModel", "Error comment , ${e.message}")
            }
        }
    }

    class PostsViewModelFactory(private val app: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CommentsViewModel::class.java)) {
                return CommentsViewModel(app) as T
            }
            throw IllegalArgumentException("Invalid Viewmodel")
        }
    }

}