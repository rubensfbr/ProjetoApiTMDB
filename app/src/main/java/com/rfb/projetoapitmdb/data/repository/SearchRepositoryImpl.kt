package com.rfb.projetoapitmdb.data.repository

import com.rfb.projetoapitmdb.data.dto.search.toSearch
import com.rfb.projetoapitmdb.data.remote.TMDB
import com.rfb.projetoapitmdb.domain.model.Search
import com.rfb.projetoapitmdb.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(private val tmdb: TMDB): SearchRepository {

    private val listSearch = mutableListOf<Search>()

    override suspend fun getSearch(query: String, language: String, page: Int): List<Search> {

        try {
            val response = tmdb.getSearch(query, language, page)
            listSearch.clear()
            if (response.isSuccessful && response.body() != null) {
                val responseSearch = response.body()
                val listResult = responseSearch?.results
                if (listResult != null) {
                   listSearch.addAll(listResult.map { it.toSearch() })
                    return listSearch
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return emptyList()
    }
}