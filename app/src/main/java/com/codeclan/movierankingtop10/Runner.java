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
        System.out.println("Searching for Movie Title...");
        Movie movie = top10movies.find("Dredd");
        System.out.println("Runner:" + "Found Movie: " + movie.getTitle() + " Genre: " + movie.getGenre().toString() + " Ranking: " + movie.getRanking());

        // sorting
        Top10Movies sortMovies = top10movies;
        sortMovies.sortByTitle();
        System.out.println("List sorted by title (not re-ranked):");
        for (Movie movie2 : sortMovies.getList()){
            System.out.println(movie2.toString());
        }

        // find using jump search
        System.out.println("searching for index of 'A Matter of Life and Death'");
        int index = sortMovies.findIndexForTitleByJumpSearch("A Matter of Life and Death");
        System.out.println(sortMovies.getByIndex(index).toString() + " found at Index = " + index);
        System.out.println("searching for index of 'Love and Death'");
        index = sortMovies.findIndexForTitleByJumpSearch("Love and Death");
        System.out.println(sortMovies.getByIndex(index).toString() + " found at Index = " + index);
        System.out.println("searching for index of 'Star Wars'");
        index = sortMovies.findIndexForTitleByJumpSearch("Star Wars");
        System.out.println("Index number for Star Wars = " + index);

    }
}
