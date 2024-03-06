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
import com.rfb.exapitmdb.databinding.FragmentSearchBinding
import com.rfb.projetoapitmdb.data.adapter.SearchAdapter
import com.rfb.projetoapitmdb.domain.model.Search
import com.rfb.projetoapitmdb.presentation.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {

    private lateinit var binding: FragmentSearchBinding

    private val viewModel: SearchViewModel by viewModels()

    private lateinit var recyclerView: RecyclerView
    private val adapter = SearchAdapter({ search -> onClick(search) }, { onBottonListener() })

    private var page = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchBinding.bind(view)

        callRecyclerView()

    }

    override fun onStart() {
        super.onStart()
        binding.buttonSearch.setOnClickListener {
            val search = binding.TextSearch.text.toString().trim()
            val language = "en-US"
            searchMovies(search, language)
        }
    }

    override fun onResume() {
        super.onResume()

        observer()
    }

    private fun observer() {
        viewModel._search.observe(this) {list ->
            adapter.setlist(list)
        }


    }

    private fun searchMovies(search: String, language: String, page: Int = 1) {
        viewModel.getSearch(search, language, page)
    }

    private fun onBottonListener() {
//        if (page > 1000) {
//            page++
//        }
//        val search = binding.TextSearch.text.toString()
//        searchMovies(search, "en-US", page)
    }

    private fun callRecyclerView() {
        recyclerView = binding.recyclerSearch
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        recyclerView.setItemViewCacheSize(20)
    }

    private fun onClick(search: Search) {
        val args = bundleOf(
            "id" to search.id
        )
        findNavController().navigate(R.id.detailsFragment, args = args)
    }

}