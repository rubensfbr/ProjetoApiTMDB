package com.rfb.projetoapitmdb.presentation.view.fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rfb.exapitmdb.R
import com.rfb.exapitmdb.databinding.FragmentTopRatedMoviesBinding
import com.rfb.projetoapitmdb.data.adapter.TopRatedMoviesAdapter
import com.rfb.projetoapitmdb.domain.model.TopRatedMovies
import com.rfb.projetoapitmdb.presentation.viewmodel.TopRatedMoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopRatedMoviesFragment : Fragment(R.layout.fragment_top_rated_movies) {

    private lateinit var binding: FragmentTopRatedMoviesBinding

    private val viewModel: TopRatedMoviesViewModel by viewModels()

    private lateinit var recyclerView: RecyclerView
    private val adapter = TopRatedMoviesAdapter({ onClick(it) }, { onBottonListener() })

    private var page = 1
    private var init = 1


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTopRatedMoviesBinding.bind(view)

        callRecyclerView()

    }

    override fun onStart() {
        super.onStart()

        if (init == 1) {
            getTopRatedMovies()
            init++
        }
    }

    override fun onResume() {
        super.onResume()

        observer()

    }

    private fun onBottonListener() {
        if (page < 1000) {
            page++
        }
        getTopRatedMovies(page)
    }

    private fun getTopRatedMovies(page: Int = 1) {
        viewModel.getTopRatedMovies(page)

    }

    private fun observer() {
        viewModel._topRatedMovies.observe(this) {
            adapter.setList(it)
        }

    }

    private fun callRecyclerView() {
        recyclerView = binding.recyclerTopRatedMovies
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }

    private fun onClick(it: TopRatedMovies) {
        val args = bundleOf(
            "id" to it.id
        )
        findNavController().navigate(R.id.detailsFragment, args = args)
    }

}