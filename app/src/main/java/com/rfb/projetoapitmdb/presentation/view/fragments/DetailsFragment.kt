package com.rfb.projetoapitmdb.presentation.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.rfb.exapitmdb.R
import com.rfb.exapitmdb.databinding.FragmentDetailsBinding
import com.rfb.projetoapitmdb.presentation.viewmodel.DetailsViewModel
import com.rfb.projetoapitmdb.util.Constants
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {

    private lateinit var binding: FragmentDetailsBinding

    private val viewModel: DetailsViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailsBinding.bind(view)


    }

    override fun onStart() {
        super.onStart()

        val id = requireArguments().getInt("id")
        viewModel.getDetails(id)
    }

    override fun onResume() {
        super.onResume()

        observer()

    }

    private fun observer() {

        viewModel._details.observe(this) {
            binding.textTitle.text = it.title
            binding.textOverview.text = it.overview

            val date = it.release_date
            val format = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            val dateConverter = LocalDate.parse(date, format)
            val newFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy")
            binding.textRelease.text = dateConverter.format(newFormat)

            if (it.runtime >= 60) {
                val totalMinutes = it.runtime
                val hours = totalMinutes / 60
                val minutes = totalMinutes % 60
                val runtime = "${hours}h ${minutes}m"
                binding.textRuntime.text = runtime
            } else {
                val runtime = "${it.runtime}m"
                binding.textRuntime.text = runtime
            }

            val nameMovie = it.backdrop_path
            val size = "w1280"
            val baseUrl = Constants.BASE_URL_IMAGE
            val posterUrl = baseUrl + size + nameMovie

            Picasso.get()
                .load(posterUrl)
                .into(binding.imagebackdrop)


            val genres = mutableListOf<String>()
            it.genres.forEach {
                genres.add(it.name)
            }
            binding.textGenres.text = genres.toString().replace("[", "").replace("]", "")

        }


    }


}