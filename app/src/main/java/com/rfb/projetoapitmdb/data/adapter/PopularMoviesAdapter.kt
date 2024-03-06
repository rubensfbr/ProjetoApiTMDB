package com.rfb.projetoapitmdb.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.rfb.exapitmdb.databinding.ItemRecyclerviewBinding
import com.rfb.projetoapitmdb.domain.model.PopularMovies
import com.rfb.projetoapitmdb.util.Constants
import com.squareup.picasso.Picasso

class PopularMoviesAdapter(
    private val onClick: (PopularMovies) -> Unit,
    private val listenerBotton: () -> Unit
) :
    ListAdapter<PopularMovies, PopularMoviesViewHolder>(diffCallback) {

    fun setlist(list: List<PopularMovies>) {
        this.submitList(ArrayList(list))
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMoviesViewHolder {
        return PopularMoviesViewHolder(
            ItemRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PopularMoviesViewHolder, position: Int) {
        holder.bind(getItem(position), onClick)

        if (itemCount != 0) {
            if (position == (itemCount - 1)) {
                listenerBotton()
            }
        }
    }

    companion object {
        val diffCallback = object : ItemCallback<PopularMovies>() {
            override fun areItemsTheSame(oldItem: PopularMovies, newItem: PopularMovies): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: PopularMovies, newItem: PopularMovies):
                    Boolean {
                return oldItem == newItem
            }

        }
    }
}


class PopularMoviesViewHolder(val binding: ItemRecyclerviewBinding) : ViewHolder(binding.root) {

    fun bind(item: PopularMovies, onClick: (PopularMovies) -> Unit) {

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
