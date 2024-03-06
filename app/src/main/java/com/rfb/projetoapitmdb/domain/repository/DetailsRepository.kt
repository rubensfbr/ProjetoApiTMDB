package com.rfb.projetoapitmdb.domain.repository

import com.rfb.projetoapitmdb.domain.model.Details

interface DetailsRepository {

    suspend fun getDetails(id: Int): Details


}