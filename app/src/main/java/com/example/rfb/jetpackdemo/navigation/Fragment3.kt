package com.example.rfb.jetpackdemo.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.rfb.jetpackdemo.R

class Fragment3 : Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.findViewById<View>(R.id.btn_to_fragment1)
                ?.setOnClickListener {
                    val navController = NavHostFragment.findNavController(this)
                    navController.navigate(R.id.to_fragment1)
                }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_3, container, false)
    }
}