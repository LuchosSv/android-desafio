package com.example.androidparadigma.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.androidparadigma.R
import com.example.androidparadigma.adapter.CommentsAdapter
import com.example.androidparadigma.adapter.PostsAdapter
import com.example.androidparadigma.data.remote.PostsEntity
import com.example.androidparadigma.databinding.FragmentDetailBinding
import com.example.androidparadigma.viewmodel.CommentsViewModel
import com.example.androidparadigma.viewmodel.PostsViewModel

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val argumentDetail: DetailFragmentArgs by navArgs()
    private val postsViewModel: PostsViewModel by viewModels {
        PostsViewModel.PostsViewModelFactory(requireContext())
    }
    private val commentsViewModel: CommentsViewModel by viewModels {
        CommentsViewModel.PostsViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this@DetailFragment
        binding.postsDetail = this@DetailFragment.postsViewModel
        binding.commentDetail = this@DetailFragment.commentsViewModel

        binding.recycleViewComments.adapter = CommentsAdapter()

        if (argumentDetail.loadDetailPosts % 2 == 0) {
            binding.containerPostById.setBackgroundColor(Color.parseColor("#CCE2A3"))
        } else {
            binding.containerPostById.setBackgroundColor(Color.parseColor("#DACC3E"))
        }

        binding.imageBackButton.setOnClickListener {
            findNavController().navigateUp()
        }
        postsViewModel.getProfileData(argumentDetail.loadDetailPosts)

        binding.floatingActionButton.setOnClickListener {
            Toast.makeText(context, "Posts Guardado en Perfil", Toast.LENGTH_LONG).show()
            postsViewModel.postsById.observe(viewLifecycleOwner, Observer {
                it.let {
                    postsViewModel.insertPostsLocal(
                        PostsEntity(
                            userId = it.userId,
                            id = it.id,
                            title = it.title,
                            body = it.body
                        )
                    )
                }
            })
        }

        return binding.root
    }

}