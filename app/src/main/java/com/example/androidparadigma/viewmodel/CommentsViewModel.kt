package com.example.androidparadigma.viewmodel

import android.content.Context
import androidx.lifecycle.*
import com.example.androidparadigma.data.Repository
import com.example.androidparadigma.data.local.LocalDataSource
import com.example.androidparadigma.data.local.PersonDatabase
import com.example.androidparadigma.data.remote.RemoteDataSource
import com.example.androidparadigma.model.CommentsResponse
import com.example.androidparadigma.util.ERROR
import com.example.androidparadigma.util.LOADING
import com.example.androidparadigma.util.SUCCESS
import kotlinx.coroutines.launch
import java.lang.Exception

class CommentsViewModel(private val applicationContext: Context) : ViewModel() {

    private val dao = PersonDatabase.getInstance(applicationContext).PersonDao()
    private val repository = Repository(LocalDataSource(dao), RemoteDataSource())

    private val _commentsList = MutableLiveData<List<CommentsResponse>>()
    val commentsList: LiveData<List<CommentsResponse>>
        get() = _commentsList

    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    init {
        getCommentsList()
    }

    //get list of posts
    private fun getCommentsList() {
        viewModelScope.launch {
            _status.value = LOADING
            try {
                _commentsList.value = repository.getComments()
                _status.value = SUCCESS
            } catch (e: Exception) {
                _status.value = ERROR
                _errorMessage.value = e.message
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