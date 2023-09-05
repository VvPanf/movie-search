package com.example.moviesearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.*
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create

class MoviesList : Fragment() {

    companion object {
        private const val BASE_URL = "https://www.omdbapi.com/"
    }

    private val json = Json {
        ignoreUnknownKeys = true
    }
    private val client = OkHttpClient()
        .newBuilder()
        .addInterceptor(ApiKeyInterceptor())
        .build()
    private val contentType = "application/json".toMediaType()
    private val retrofitClient = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(json.asConverterFactory(contentType))
        .client(client)
        .build()
    private val movieApiService: MovieApiService = retrofitClient.create()
    private val scope = CoroutineScope(Dispatchers.IO)

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
        val movieIds = getMovieIdList()
        val movieResponses = runBlocking {
            loadMovies(movieIds)
        }
        val movies: List<Movie> = movieResponses.map { it.mapMovie() }.toList()
        val adapter = MoviesAdapter(movies).apply {
            setHasStableIds(true)
        }
        view.findViewById<RecyclerView>(R.id.movies_list)?.also {
            it.setHasFixedSize(true)
            it.adapter = adapter
        }
    }

    private suspend fun loadMovies(movieIds: List<String>): List<MovieResponse> {
        return coroutineScope {
            movieIds
                .map { async { movieApiService.getFilmById(it) } }
                .awaitAll()
        }
    }
}