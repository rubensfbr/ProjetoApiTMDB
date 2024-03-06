package com.rfb.projetoapitmdb.domain.model

import com.rfb.projetoapitmdb.data.dto.details.Genre

data class Details(
    val backdrop_path: String?,
    val genres: List<Genre>,
    val overview: String,
    val release_date: String,
    val runtime: Int,
    val title: String,
    )
