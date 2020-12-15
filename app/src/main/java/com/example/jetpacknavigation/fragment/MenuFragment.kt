package com.example.jetpacknavigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.jetpacknavigation.R
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        browserButton.setOnClickListener {
            val direction = MenuFragmentDirections.actionMenuFragmentToBrowserFragment()
            it.findNavController().navigate(direction)
        }
        cameraButton.setOnClickListener {
            val direction = MenuFragmentDirections.actionMenuFragmentToCameraFragment()
            it.findNavController().navigate(direction)
        }
        calculadoraButton.setOnClickListener {
            val direction = MenuFragmentDirections.actionMenuFragmentToCalculadora()
            it.findNavController().navigate(direction)
        }

    }
}