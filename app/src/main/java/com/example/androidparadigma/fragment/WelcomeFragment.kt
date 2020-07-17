package com.example.androidparadigma.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androidparadigma.R
import com.example.androidparadigma.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeBinding.inflate(inflater)

        binding.buttonWelcomeFragment.setOnClickListener{
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToPostsFragment())
        }

        return binding.root
    }

}