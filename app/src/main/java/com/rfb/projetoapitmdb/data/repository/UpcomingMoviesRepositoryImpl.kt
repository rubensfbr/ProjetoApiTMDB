package com.rfb.projetoapitmdb.data.repository

import com.rfb.projetoapitmdb.data.dto.upcomingMovies.toUpcomingMovies
import com.rfb.projetoapitmdb.data.remote.TMDB
import com.rfb.projetoapitmdb.domain.model.UpcomingMovies
import com.rfb.projetoapitmdb.domain.repository.UpcomingMoviesRepository
import javax.inject.Inject

class UpcomingMoviesRepositoryImpl @Inject constructor(private val tmdb: TMDB) :
    UpcomingMoviesRepository {

    private val listUpcomingMovies = mutableListOf<UpcomingMovies>()

    override suspend fun getUpcomingMovies(page: Int): List<UpcomingMovies> {

        try {
            val response = tmdb.getUpcomingMovies(page)
            if (response.isSuccessful && response.body() != null) {
                val responseUpcomingMovies = response.body()
                val listResults = responseUpcomingMovies?.results
                if (listResults != null) {
                    listUpcomingMovies.addAll(listResults.map { it.toUpcomingMovies() })
                    return listUpcomingMovies
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return emptyList()
    }

}