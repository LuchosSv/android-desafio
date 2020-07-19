package com.example.androidparadigma.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.androidparadigma.R
import com.example.androidparadigma.adapter.PostsAdapter
import com.example.androidparadigma.adapter.ProfileAdapter
import com.example.androidparadigma.databinding.FragmentDetailBinding
import com.example.androidparadigma.databinding.FragmentPostsBinding
import com.example.androidparadigma.databinding.FragmentProfileBinding
import com.example.androidparadigma.viewmodel.PostsViewModel
import com.example.androidparadigma.viewmodel.ProfileViewModel

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val profileViewModel: ProfileViewModel by viewModels {
        ProfileViewModel.ProfileViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.fragment_profile, container, false)
        binding = FragmentProfileBinding.inflate(inflater)
        binding.lifecycleOwner = this@ProfileFragment
        binding.profile = this@ProfileFragment.profileViewModel

        binding.recycleViewProfile.adapter = ProfileAdapter()

        return binding.root
    }

}