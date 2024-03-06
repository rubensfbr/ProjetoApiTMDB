package com.rfb.projetoapitmdb.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rfb.projetoapitmdb.domain.model.UpcomingMovies
import com.rfb.projetoapitmdb.domain.repository.UpcomingMoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpcomingMoviesViewModel @Inject constructor(private val repository: UpcomingMoviesRepository) :
    ViewModel() {

    private val upcomingMovies = MutableLiveData<List<UpcomingMovies>>()
    val _upcomingMovies: LiveData<List<UpcomingMovies>> = upcomingMovies

    fun getUpcomingMovies(page: Int) {
        viewModelScope.launch {
            upcomingMovies.postValue(repository.getUpcomingMovies(page))

        }

    }


}