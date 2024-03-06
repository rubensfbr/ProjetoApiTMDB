package com.rfb.projetoapitmdb.data.remote

import com.rfb.projetoapitmdb.data.dto.details.DetailsDTO
import com.rfb.projetoapitmdb.data.dto.popularMovies.PopularMoviesDTO
import com.rfb.projetoapitmdb.data.dto.search.SearchDTO
import com.rfb.projetoapitmdb.data.dto.topRatedMovies.TopRatedMoviesDTO
import com.rfb.projetoapitmdb.data.dto.upcomingMovies.UpcomingMoviesDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TMDB {

    @GET("movie/popular?language=pt-BR")
    suspend fun getPolularMovies(@Query("page") page: Int): Response<PopularMoviesDTO>

    @GET("movie/upcoming?language=pt-BR")
    suspend fun getUpcomingMovies(@Query("page") page: Int): Response<UpcomingMoviesDTO>

    @GET("movie/top_rated?language=pt-BR")
    suspend fun getTopRatedMovies(@Query("page") page: Int): Response<TopRatedMoviesDTO>

    @GET("movie/{movie_id}?language=pt-BR")
    suspend fun getDetails(@Path("movie_id") id: Int): Response<DetailsDTO>

    @GET("search/movie")
    suspend fun getSearch(@Query("query") query: String,
                          @Query("language") language: String,
                          @Query("page") page: Int): Response<SearchDTO>

}