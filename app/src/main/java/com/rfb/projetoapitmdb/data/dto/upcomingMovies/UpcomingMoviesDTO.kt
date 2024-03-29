package com.rfb.projetoapitmdb.data.dto.upcomingMovies

data class UpcomingMoviesDTO(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)