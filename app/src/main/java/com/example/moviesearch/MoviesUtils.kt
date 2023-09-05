package com.example.moviesearch

import kotlin.math.roundToInt

fun getMovieList(): List<Movie> = listOf(
    Movie("Avengers: End Game", 137, "Action, Adventure, Drama", 4, 125, 13, false, "film1"),
    Movie("Tenet", 97, "Action, Sci-Fi, Thriller ", 5, 98, 16, true, "film2"),
    Movie("Black Widow", 102, "Action, Adventure, Sci-Fi", 4, 38, 13, false, "film3"),
    Movie("Wonder Woman 1984", 120, "Action, Adventure, Fantasy", 5, 74, 13, false, "film4"),
)

fun getActorList(): List<Actor> = listOf(
    Actor("Robert Downey Jr.", "actor1"),
    Actor("Chris Evans", "actor2"),
    Actor("Mark Ruffalo", "actor3"),
    Actor("Chris Hemsworth", "actor4"),
)

fun getMovieIdList(): List<String> = listOf(
    "tt3896198",
    "tt1285016",
    "tt0111161",
    "tt0068646",
    "tt0050083",
    "tt0060196"
)

fun MovieResponse.mapMovie(): Movie
    = Movie(
        title=this.Title,
        length=this.Runtime.replace(" min", "").toInt(),
        genre=this.Genre,
        rating=(this.imdbRating.toDouble()/2).roundToInt(),
        reviews=this.imdbVotes.replace(",","").toInt(),
        age=this.Year.toInt(),
        like=false,
        image=this.Poster
    )