package com.example.moviesearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment

class MoviesList : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies_list, container, false)
        view.findViewById<ConstraintLayout>(R.id.film_card)?.apply {
            setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.main_container, MoviesDetails())
                    .addToBackStack(null)
                    .commit()
            }
        }
        return view
    }
}