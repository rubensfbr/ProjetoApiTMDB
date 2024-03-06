package com.rfb.projetoapitmdb.data.repository

import com.rfb.projetoapitmdb.data.dto.popularMovies.toPopularMovies
import com.rfb.projetoapitmdb.data.remote.TMDB
import com.rfb.projetoapitmdb.domain.model.PopularMovies
import com.rfb.projetoapitmdb.domain.repository.PopularMoviesRepository
import javax.inject.Inject

class PopularMoviesRepositoryImpl @Inject constructor(private val tmdb: TMDB) :
    PopularMoviesRepository {

    private val listPopularMovies = mutableListOf<PopularMovies>()

    override suspend fun getPopularMovies(page: Int): List<PopularMovies> {

        try {
            val response = tmdb.getPolularMovies(page)
            if (response.isSuccessful && response.body() != null) {
                val responsePopularMovies = response.body()
                val listResult = responsePopularMovies?.results
                if (listResult != null) {
                    listPopularMovies.addAll(listResult.map { it.toPopularMovies() })
                    return listPopularMovies
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return emptyList()
    }
}