package com.rfb.projetoapitmdb.data.repository

import com.rfb.projetoapitmdb.data.dto.details.toDetails
import com.rfb.projetoapitmdb.data.remote.TMDB
import com.rfb.projetoapitmdb.domain.model.Details
import com.rfb.projetoapitmdb.domain.repository.DetailsRepository
import javax.inject.Inject

class DetailsRepositoryImpl @Inject constructor(private val tmdb: TMDB) : DetailsRepository {

    override suspend fun getDetails(id: Int): Details {
        try {
            val response = tmdb.getDetails(id)
            if (response.isSuccessful && response.body() != null) {
                response.body()?.apply {
                    return this.toDetails()
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return Details("", emptyList(), "", "", -1, "")
    }


}