package com.rfb.projetoapitmdb.data.repository

import com.rfb.projetoapitmdb.data.dto.topRatedMovies.toTopRatedMovies
import com.rfb.projetoapitmdb.data.remote.TMDB
import com.rfb.projetoapitmdb.domain.model.TopRatedMovies
import com.rfb.projetoapitmdb.domain.repository.TopRatedMoviesRepository
import javax.inject.Inject

class TopRatedMoviesMoviesRepositoryImpl @Inject constructor(private val tmdb: TMDB) :
    TopRatedMoviesRepository {

    private val listTopRatedMovies = mutableListOf<TopRatedMovies>()

    override suspend fun getTopRatedMovies(page: Int): List<TopRatedMovies> {

        try {
            val response = tmdb.getTopRatedMovies(page)
            if (response.isSuccessful && response.body() != null) {
                val responseTopRatedMovies = response.body()
                val listResult = responseTopRatedMovies?.results
                if (listResult != null) {
                    listTopRatedMovies.addAll(listResult.map { it.toTopRatedMovies() })
                    return listTopRatedMovies
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return emptyList()
    }
}