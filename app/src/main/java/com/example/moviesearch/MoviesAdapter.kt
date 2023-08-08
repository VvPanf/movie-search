package com.example.moviesearch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MoviesAdapter(
    private var movies: List<Movie>
) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {
    override fun getItemCount(): Int = movies.size
    override fun getItemId(position: Int): Long = position.toLong()
    private fun getItem(position: Int): Movie = movies[position]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MovieViewHolder(view: View) : ViewHolder(view), View.OnClickListener {
        private val image: ImageView = itemView.findViewById(R.id.film_image)
        private val age: TextView = itemView.findViewById(R.id.film_age)
        private val like: ImageView = itemView.findViewById(R.id.film_like)
        private val genre: TextView = itemView.findViewById(R.id.film_genre)
        private val rating: ImageView = itemView.findViewById(R.id.film_image_rating)
        private val reviews: TextView = itemView.findViewById(R.id.film_reviews)
        private val title: TextView = itemView.findViewById(R.id.film_title)
        private val length: TextView = itemView.findViewById(R.id.film_length)

        init {
            itemView.setOnClickListener {
                onClick(it)
            }
        }

        fun bind(movie: Movie) {
            val idField = R.drawable::class.java.getDeclaredField(movie.image)
            this.image.setImageResource(idField.getInt(idField))
            this.age.text = movie.age.toString() + "+"
            this.like.setImageResource(if (movie.like) R.drawable.ic_like else R.drawable.ic_not_like)
            this.genre.text = movie.genre
            this.reviews.text = movie.reviews.toString() + " REVIEWS"
            this.title.text = movie.title
            this.length.text = movie.length.toString() + " MIN"
        }

        override fun onClick(view: View) {
            val activity = view.context as AppCompatActivity
            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, MoviesDetails())
                .addToBackStack(null)
                .commit()
        }
    }
}