package com.example.androidparadigma.fragment

import android.os.Bundle
import android.view.ContextMenu
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.example.androidparadigma.R
import com.example.androidparadigma.databinding.FragmentWelcomeBinding
import com.example.androidparadigma.viewmodel.PersonViewModel

class WelcomeFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: FragmentWelcomeBinding
    private val personViewModel: PersonViewModel by viewModels {
        PersonViewModel.PersonListViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeBinding.inflate(inflater)
        binding.lifecycleOwner = this@WelcomeFragment
        binding.person = this@WelcomeFragment.personViewModel

        //set opacity button
        binding.buttonWelcomeFragment.background.alpha = 128

        //fill spinners
        ArrayAdapter.createFromResource(
            requireContext(), R.array.day, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerDay.adapter = adapter
        }

        //Save user when register in app
        binding.buttonWelcomeFragment.setOnClickListener {

            //validate if camp is not null
            if (binding.editTextNombre.text.isEmpty()) {
                Toast.makeText(context, "Campo nombre requerido", Toast.LENGTH_LONG).show()
            } else if (binding.editTextApellido.text.isEmpty()) {
                Toast.makeText(context, "Campo apellido requerido", Toast.LENGTH_LONG).show()
            } else if (binding.editTextOcupacion.text.isEmpty()) {
                Toast.makeText(context, "Campo nombre requerido", Toast.LENGTH_LONG).show()
            } else {
                //save user register in database
                personViewModel.insertLocalPerson(
                    id = 1,
                    nombre = binding.editTextNombre.text.toString(),
                    apellido = binding.editTextApellido.text.toString(),
                    ocupacion = binding.editTextOcupacion.text.toString(),
                    nacimiento = "04-08-1997"
                )
                //navigation to postsFragment
                findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToPostsFragment())
            }
        }

        return binding.root
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

}