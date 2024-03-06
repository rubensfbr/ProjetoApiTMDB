package com.rfb.projetoapitmdb.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rfb.exapitmdb.databinding.ItemRecyclerviewBinding
import com.rfb.projetoapitmdb.domain.model.TopRatedMovies
import com.rfb.projetoapitmdb.util.Constants
import com.squareup.picasso.Picasso

class TopRatedMoviesAdapter(
    private val onClick: (TopRatedMovies) -> Unit,
    private val listenerBotton: () -> Unit
) :
    ListAdapter<TopRatedMovies, TopRatedMoviesViewHolder>(diffCallback) {

    fun setList(list: List<TopRatedMovies>) {
        this.submitList(ArrayList(list))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedMoviesViewHolder {
        return TopRatedMoviesViewHolder(
            ItemRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: TopRatedMoviesViewHolder, position: Int) {
        holder.bind(getItem(position), onClick)

        if (itemCount != 0) {
            if (position == (itemCount - 1)) {
                listenerBotton()
            }
        }
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<TopRatedMovies>() {
            override fun areItemsTheSame(
                oldItem: TopRatedMovies,
                newItem: TopRatedMovies
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: TopRatedMovies, newItem: TopRatedMovies):
                    Boolean {
                return oldItem == newItem
            }

        }
    }

}

class TopRatedMoviesViewHolder(val binding: ItemRecyclerviewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: TopRatedMovies, onClick: (TopRatedMovies) -> Unit) {

        val nameMovie = item.poster_path
        val size = "w780"
        val baseUrl = Constants.BASE_URL_IMAGE

        val posterUrl = baseUrl + size + nameMovie


        Picasso.get()
            .load(posterUrl)
            .into(binding.imageMovies)

        binding.cl.setOnClickListener {
            onClick(item)
        }

    }


}