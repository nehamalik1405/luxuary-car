package com.a.luxurycar.code_files.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.a.luxurycar.R
import com.a.luxurycar.databinding.FragmentHomeBinding
import com.demo.myapplication.ui.home.HomeViewModel
import com.google.android.material.tabs.TabLayoutMediator


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        //  list = arrayListOf()
        //list.add()
        val adapter = ImageAdapter()
         val photos_viewpager = binding.photosViewpager
        photos_viewpager.adapter= adapter

        TabLayoutMediator(binding.tabLayout, photos_viewpager) { tab, position ->


        }.attach()

        homeViewModel.text.observe(viewLifecycleOwner) {
            // textView.text = it
        }





        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}