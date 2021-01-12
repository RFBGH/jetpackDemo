package com.example.rfb.jetpackdemo.navigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.example.rfb.jetpackdemo.R

class IndexDestinationFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_index_destination, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.findViewById<View>(R.id.btn_to_fragment2)
                ?.setOnClickListener {
                    val navController = NavHostFragment.findNavController(this)
                    navController.navigate(R.id.to_fragment2)
                }
    }

    override fun onStart() {
        super.onStart()
        Log.e("flypig", "fragment1 onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("flypig", "fragment1 onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("flypig", "fragment1 onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("flypig", "fragment1 onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("flypig", "fragment1 onDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("flypig", "fragment1 onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("flypig", "fragment1 onDetach")
    }
}