package com.rfb.projetoapitmdb.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rfb.projetoapitmdb.domain.model.Details
import com.rfb.projetoapitmdb.domain.repository.DetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val repository: DetailsRepository) :
    ViewModel() {

    private val details = MutableLiveData<Details>()
    val _details: LiveData<Details> = details

    fun getDetails(id: Int) {
        viewModelScope.launch {
            details.postValue(repository.getDetails(id))
        }
    }


}