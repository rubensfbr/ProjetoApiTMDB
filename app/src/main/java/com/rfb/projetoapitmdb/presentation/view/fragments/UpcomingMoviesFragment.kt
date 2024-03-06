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
import com.rfb.exapitmdb.databinding.FragmentUpcomingMoviesBinding
import com.rfb.projetoapitmdb.data.adapter.UpcomingMoviesAdapter
import com.rfb.projetoapitmdb.domain.model.UpcomingMovies
import com.rfb.projetoapitmdb.presentation.viewmodel.UpcomingMoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpcomingMoviesFragment : Fragment(R.layout.fragment_upcoming_movies) {

    private lateinit var binding: FragmentUpcomingMoviesBinding

    private val viewModel: UpcomingMoviesViewModel by viewModels()

    private lateinit var recyclerView: RecyclerView
    private val adapter = UpcomingMoviesAdapter({ onClick(it) }, { onBottonListener() })

    private var page = 1
    private var init = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUpcomingMoviesBinding.bind(view)

        callRecyclerView()
    }

    override fun onStart() {
        super.onStart()

        if (init == 1) {
            getUpcomingMovies()
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
        getUpcomingMovies(page)
    }

    private fun getUpcomingMovies(page: Int = 1) {
        viewModel.getUpcomingMovies(page)
    }

    private fun observe() {
        viewModel._upcomingMovies.observe(this) {
            adapter.setList(it)
        }
    }

    private fun callRecyclerView() {
        recyclerView = binding.recyclerUpcomingMovies
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }

    private fun onClick(it: UpcomingMovies) {
        val args = bundleOf(
            "id" to it.id
        )
        findNavController().navigate(R.id.detailsFragment, args = args)
    }


}