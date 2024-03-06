package com.rfb.projetoapitmdb.domain.repository

import com.rfb.projetoapitmdb.domain.model.Search

interface SearchRepository {

    suspend fun getSearch(query: String, language: String, page: Int): List<Search>

}