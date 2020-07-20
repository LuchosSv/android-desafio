package com.example.androidparadigma.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.androidparadigma.adapter.ProfileAdapter
import com.example.androidparadigma.databinding.FragmentProfileBinding
import com.example.androidparadigma.viewmodel.PersonViewModel
import com.example.androidparadigma.viewmodel.ProfileViewModel

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val profileViewModel: ProfileViewModel by viewModels {
        ProfileViewModel.ProfileViewModelFactory(requireContext())
    }
    private val personViewModel: PersonViewModel by viewModels {
        PersonViewModel.PersonListViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater)
        binding.lifecycleOwner = this@ProfileFragment
        binding.profile = this@ProfileFragment.profileViewModel
        binding.personPostProfile = this@ProfileFragment.personViewModel

        binding.recycleViewProfile.adapter = ProfileAdapter(getPostsToProfileCallback(), getPostsToProfileCallback2())

        return binding.root
    }

    private fun getPostsToProfileCallback() = ProfileAdapter.OnClickListener {
        this.findNavController().navigate(
            ProfileFragmentDirections.actionProfileFragmentToDetailFragment(it.id)
        )
    }

    private fun getPostsToProfileCallback2() = ProfileAdapter.OnClickListener2 {
        Toast.makeText(context, "Posts Eliminado", Toast.LENGTH_LONG).show()
        profileViewModel.deleteLocalUser(it)
    }

}