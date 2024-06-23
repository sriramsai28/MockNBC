package com.sriram.mocknbc.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sriram.mocknbc.databinding.FragmentHomeBinding
import com.sriram.mocknbc.domain.viewmodel.HomeScreenViewModel
import com.sriram.mocknbc.ui.adapter.HomeScreenAdapter
import com.sriram.mocknbc.ui.model.toCarousel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel: HomeScreenViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel.getHomeScreenShelves(context)
        viewModel.shelveList.observe(viewLifecycleOwner) {
            with(binding) {
                shelfViewContainer.layoutManager = LinearLayoutManager(context)
                shelfViewContainer.adapter =
                    HomeScreenAdapter(
                        homeScreenContent = it.toCarousel(),
                        context = this@HomeFragment.requireContext(),
                    )
            }
        }
        return binding.root
    }
}
