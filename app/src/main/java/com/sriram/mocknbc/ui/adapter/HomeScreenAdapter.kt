package com.sriram.mocknbc.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sriram.mocknbc.databinding.ShelfViewBinding
import com.sriram.mocknbc.ui.model.Carousel

class HomeScreenAdapter(
    private val homeScreenContent: List<Carousel>,
    private val context: Context,
) :
    RecyclerView.Adapter<HomeScreenAdapter.HomeScreenViewHolder>() {
    inner class HomeScreenViewHolder(val binding: ShelfViewBinding) : ViewHolder(binding.root) {
        fun bind(carousel: Carousel) {
            val adapter = createCarouselAdapter()
            adapter.items = carousel.content
            with(binding) {
                shelfTitle.text = carousel.title
                carouselView.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                carouselView.adapter = adapter
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeScreenViewHolder {
        val binding = ShelfViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeScreenViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return homeScreenContent.size
    }

    override fun onBindViewHolder(holder: HomeScreenViewHolder, position: Int) {
        val carousel = homeScreenContent[position]
        holder.bind(carousel)
    }
}
