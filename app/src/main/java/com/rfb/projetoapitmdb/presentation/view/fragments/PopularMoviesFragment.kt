package com.rfb.projetoapitmdb.presentation.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rfb.exapitmdb.R
import com.rfb.exapitmdb.databinding.FragmentPopularMoviesBinding
import com.rfb.projetoapitmdb.data.adapter.PopularMoviesAdapter
import com.rfb.projetoapitmdb.domain.model.PopularMovies
import com.rfb.projetoapitmdb.presentation.viewmodel.PopularMoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularMoviesFragment : Fragment(R.layout.fragment_popular_movies) {

    private lateinit var binding: FragmentPopularMoviesBinding

    private val viewModel: PopularMoviesViewModel by viewModels()

    private lateinit var recyclerView: RecyclerView
    private val adapter = PopularMoviesAdapter({ popularMovies -> onClick(popularMovies) },
        { onBottonListener() })
    private var page = 1
    private var init = 1


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPopularMoviesBinding.bind(view)

        callRecyclerView()


    }

    override fun onStart() {
        super.onStart()

        if (init == 1) {
            getPopularMovies()
            init++
        }
    }


    override fun onResume() {
        super.onResume()

        observe()

    }

    private fun onBottonListener() {
        if (page < 1000) {
            page++
        }
        getPopularMovies(page)
    }

    private fun getPopularMovies(page: Int = 1) {
        viewModel.getPopularMovies(page)
    }

    private fun observe() {
        viewModel._popularMovies.observe(this) {
            Log.i("recycler", "list: ${it.size} ")
            adapter.setlist(it)
        }

    }

    private fun callRecyclerView() {
        recyclerView = binding.recyclerPopularMovies
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        recyclerView.setItemViewCacheSize(20)
    }

    private fun onClick(popularMovies: PopularMovies) {
        val args = bundleOf(
            "id" to popularMovies.id
        )
        findNavController().navigate(R.id.detailsFragment, args = args)
    }

}