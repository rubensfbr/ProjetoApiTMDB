package com.rfb.projetoapitmdb.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rfb.projetoapitmdb.domain.model.Search
import com.rfb.projetoapitmdb.domain.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: SearchRepository) : ViewModel() {

    private val search = MutableLiveData<List<Search>>()
    val _search: LiveData<List<Search>> = search

    fun getSearch(query: String, language: String, page: Int) {
        viewModelScope.launch {
            search.postValue(repository.getSearch(query, language, page))
        }
    }


}