package com.codeclan.movierankingtop10;

import android.icu.text.SymbolTable;
import android.util.Log;

/**
 * Created by DRC on 24/03/2017.
 */

public class Runner {

    // use of array
    private static Movie[] starterList ={
            new Movie("The Exorcist", MovieGenres.HORROR, 1),
            new Movie("Brazil", MovieGenres.COMEDY, 2),
            new Movie("Citizen Kane", MovieGenres.PERIOD, 3),
            new Movie("The Devils", MovieGenres.HORROR, 4),
            new Movie("Don’t Look Now", MovieGenres.HORROR, 5),
            new Movie("A Matter of Life and Death", MovieGenres.ADVENTURE, 6),
            new Movie("It’s a Wonderful Life", MovieGenres.COMEDY, 7),
            new Movie("Love and Death", MovieGenres.COMEDY, 8),
            new Movie("Dredd", MovieGenres.SCIFI, 9),
            new Movie("Blazing Saddles", MovieGenres.COMEDY, 10)
    };

    public static void main(String[] args) {
        Top10Movies top10movies;

        top10movies = new Top10Movies();
        top10movies.setList(starterList);

        // Using the search function
        Movie movie = top10movies.find("Dredd");
        System.out.println("Runner:" + "Found Movie: " + movie.getTitle());

        // sorting
        Top10Movies sortMovies = top10movies;
        sortMovies.sortByTitle();

        for (Movie movie2 : sortMovies.getList()){
            System.out.println(movie2.toString());
        }
    }
}
