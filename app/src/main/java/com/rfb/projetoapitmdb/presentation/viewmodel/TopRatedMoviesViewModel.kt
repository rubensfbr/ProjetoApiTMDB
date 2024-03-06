package com.rfb.projetoapitmdb.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rfb.projetoapitmdb.domain.model.TopRatedMovies
import com.rfb.projetoapitmdb.domain.repository.TopRatedMoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopRatedMoviesViewModel @Inject constructor(private val repository: TopRatedMoviesRepository) :
    ViewModel() {

    private val topRatedMovies = MutableLiveData<List<TopRatedMovies>>()
    val _topRatedMovies: LiveData<List<TopRatedMovies>> = topRatedMovies


    fun getTopRatedMovies(page: Int) {
        viewModelScope.launch {
            topRatedMovies.postValue(repository.getTopRatedMovies(page))
        }
    }

}