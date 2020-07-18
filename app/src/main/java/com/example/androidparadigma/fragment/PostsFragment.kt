package com.example.androidparadigma.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.androidparadigma.R
import com.example.androidparadigma.databinding.FragmentPostsBinding
import com.example.androidparadigma.viewmodel.PersonViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class PostsFragment : Fragment() {

    private lateinit var binding: FragmentPostsBinding
    private val personPostViewModel: PersonViewModel by viewModels {
        PersonViewModel.PersonListViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.fragment_posts, container, false)
        binding = FragmentPostsBinding.inflate(inflater)
        binding.lifecycleOwner = this@PostsFragment
        binding.personPost = this@PostsFragment.personPostViewModel

        /*binding.menuContainer.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.postsFragment -> ,
                R.id.profileFragment ->
            }
        }*/

        return binding.root
    }

}