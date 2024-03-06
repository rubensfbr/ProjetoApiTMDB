package com.rfb.projetoapitmdb.domain.repository

import com.rfb.projetoapitmdb.domain.model.TopRatedMovies

interface TopRatedMoviesRepository {

    suspend fun getTopRatedMovies(page: Int): List<TopRatedMovies>


}