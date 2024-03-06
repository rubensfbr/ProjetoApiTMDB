package com.rfb.projetoapitmdb.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.rfb.exapitmdb.databinding.ItemRecyclerviewBinding
import com.rfb.projetoapitmdb.domain.model.Search
import com.rfb.projetoapitmdb.util.Constants
import com.squareup.picasso.Picasso

class SearchAdapter (
    private val onClick: (Search) -> Unit,
    private val listenerBotton: () -> Unit
) : androidx.recyclerview.widget.ListAdapter<Search, SearchViewHolder>(diffCallback) {

    fun setlist(list: List<Search>) {
        this.submitList(ArrayList(list))
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            ItemRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(getItem(position), onClick)

        if (itemCount != 0) {
            if (position == (itemCount - 1)) {
                listenerBotton()
            }
        }
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Search>() {
            override fun areItemsTheSame(oldItem: Search, newItem: Search): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Search, newItem: Search):
                    Boolean {
                return oldItem == newItem
            }

        }
    }
}


class SearchViewHolder(val binding: ItemRecyclerviewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Search, onClick: (Search) -> Unit) {

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