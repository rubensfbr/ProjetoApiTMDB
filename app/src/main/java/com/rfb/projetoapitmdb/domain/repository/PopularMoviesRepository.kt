package com.rfb.projetoapitmdb.domain.repository

import com.rfb.projetoapitmdb.domain.model.PopularMovies

interface PopularMoviesRepository {

    suspend fun getPopularMovies(page: Int): List<PopularMovies>



}