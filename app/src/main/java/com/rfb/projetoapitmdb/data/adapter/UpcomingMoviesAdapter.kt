package com.rfb.projetoapitmdb.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rfb.exapitmdb.databinding.ItemRecyclerviewBinding
import com.rfb.projetoapitmdb.domain.model.UpcomingMovies
import com.rfb.projetoapitmdb.util.Constants
import com.squareup.picasso.Picasso

class UpcomingMoviesAdapter(
    private val onClick: (UpcomingMovies) -> Unit,
    private val listenerBotton: () -> Unit
) : ListAdapter<UpcomingMovies, UpcomingMoviesViewHolder>(diffCallback) {

    fun setList(list: List<UpcomingMovies>) {
        this.submitList(ArrayList(list))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingMoviesViewHolder {
        return UpcomingMoviesViewHolder(
            ItemRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: UpcomingMoviesViewHolder, position: Int) {
        holder.bind(getItem(position), onClick)

        if (itemCount != 0) {
            if (position == (itemCount - 1)) {
                listenerBotton()
            }
        }
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<UpcomingMovies>() {
            override fun areItemsTheSame(
                oldItem: UpcomingMovies,
                newItem: UpcomingMovies
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: UpcomingMovies, newItem: UpcomingMovies):
                    Boolean {
                return oldItem == newItem
            }

        }
    }

}

class UpcomingMoviesViewHolder(val binding: ItemRecyclerviewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: UpcomingMovies, onClick: (UpcomingMovies) -> Unit) {

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