package com.example.androidparadigma.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.androidparadigma.R
import com.example.androidparadigma.adapter.PostsAdapter
import com.example.androidparadigma.databinding.FragmentPostsBinding
import com.example.androidparadigma.viewmodel.PersonViewModel
import com.example.androidparadigma.viewmodel.PostsViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class PostsFragment : Fragment() {

    private lateinit var binding: FragmentPostsBinding
    private val personPostViewModel: PersonViewModel by viewModels {
        PersonViewModel.PersonListViewModelFactory(requireContext())
    }
    private val postsViewModel: PostsViewModel by viewModels {
        PostsViewModel.PostsViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostsBinding.inflate(inflater)
        binding.lifecycleOwner = this@PostsFragment
        binding.personPost = this@PostsFragment.personPostViewModel
        binding.posts = this@PostsFragment.postsViewModel

        binding.recycleViewPosts.adapter = PostsAdapter(getPostsCallback())

        return binding.root
    }

    private fun getPostsCallback() = PostsAdapter.OnClickListener {
        this.findNavController().navigate(
            PostsFragmentDirections.actionPostsFragmentToDetailFragment(it.id)
        )
    }

}