package com.rfb.projetoapitmdb.domain.repository

import com.rfb.projetoapitmdb.domain.model.UpcomingMovies

interface UpcomingMoviesRepository {

    suspend fun getUpcomingMovies(page: Int): List<UpcomingMovies>

}