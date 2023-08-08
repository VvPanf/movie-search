package com.example.moviesearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class MoviesList : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies_list, container, false)
//        view.findViewById<ConstraintLayout>(R.id.film_card)?.apply {
//            setOnClickListener {
//                parentFragmentManager.beginTransaction()
//                    .replace(R.id.main_container, MoviesDetails())
//                    .addToBackStack(null)
//                    .commit()
//            }
//        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val movies = getMovieList()
        val adapter = MoviesAdapter(movies).apply {
            setHasStableIds(true)
        }
        view.findViewById<RecyclerView>(R.id.movies_list)?.also {
            it.setHasFixedSize(true)
            it.adapter = adapter
        }
    }
}