package com.example.myapplication


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.Activity3Binding
import androidx.navigation.fragment.findNavController

class Fragment3 : Fragment() {

    private var binding: Activity3Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = Activity3Binding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding!!) {
            bnToFirst.setOnClickListener {
                findNavController().navigate(R.id.action_fragment3_to_fragment1)
            }

            bnToSecond.setOnClickListener {
                findNavController().navigate(R.id.action_fragment3_to_fragment2)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

