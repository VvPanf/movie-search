package com.example.moviesearch

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