package com.rfb.projetoapitmdb.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rfb.projetoapitmdb.domain.model.PopularMovies
import com.rfb.projetoapitmdb.domain.repository.PopularMoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularMoviesViewModel @Inject constructor(private val repository: PopularMoviesRepository) :
    ViewModel() {


    private val popularMovies = MutableLiveData<List<PopularMovies>>()
    val _popularMovies: LiveData<List<PopularMovies>> = popularMovies


    fun getPopularMovies(page: Int) {
        viewModelScope.launch {
            popularMovies.postValue(repository.getPopularMovies(page))
        }

    }


}