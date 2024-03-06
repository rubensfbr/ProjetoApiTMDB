package com.rfb.projetoapitmdb.di

import com.rfb.projetoapitmdb.data.remote.TMDB
import com.rfb.projetoapitmdb.data.repository.DetailsRepositoryImpl
import com.rfb.projetoapitmdb.data.repository.PopularMoviesRepositoryImpl
import com.rfb.projetoapitmdb.data.repository.SearchRepositoryImpl
import com.rfb.projetoapitmdb.data.repository.TopRatedMoviesMoviesRepositoryImpl
import com.rfb.projetoapitmdb.data.repository.UpcomingMoviesRepositoryImpl
import com.rfb.projetoapitmdb.domain.repository.DetailsRepository
import com.rfb.projetoapitmdb.domain.repository.PopularMoviesRepository
import com.rfb.projetoapitmdb.domain.repository.SearchRepository
import com.rfb.projetoapitmdb.domain.repository.TopRatedMoviesRepository
import com.rfb.projetoapitmdb.domain.repository.UpcomingMoviesRepository
import com.rfb.projetoapitmdb.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .writeTimeout(10, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val requestConstructor = chain.request().newBuilder()
                val request = requestConstructor.addHeader(
                    "Authorization", "Bearer ${Constants.TOKEN}"
                ).build()
                return chain.proceed(request)
            }
        })
        .build()


    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideTMDB(retrofit: Retrofit): TMDB {
        return retrofit.create(TMDB::class.java)
    }

    @Provides
    fun providePopularMovieRepository(tmdb: TMDB): PopularMoviesRepository {
        return PopularMoviesRepositoryImpl(tmdb)
    }

    @Provides
    fun provideUpcomingMoviesRepository(tmdb: TMDB): UpcomingMoviesRepository {
        return UpcomingMoviesRepositoryImpl(tmdb)
    }

    @Provides
    fun provideTopRatedMoviesRepository(tmdb: TMDB): TopRatedMoviesRepository {
        return TopRatedMoviesMoviesRepositoryImpl(tmdb)
    }

    @Provides
    fun provideDetailsRepository(tmdb: TMDB): DetailsRepository {
        return DetailsRepositoryImpl(tmdb)
    }

    @Provides
    fun provideSearchRepository(tmdb: TMDB): SearchRepository {
        return SearchRepositoryImpl(tmdb)
    }

}