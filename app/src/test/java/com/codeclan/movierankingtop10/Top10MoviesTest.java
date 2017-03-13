package com.codeclan.movierankingtop10;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 13/03/2017.
 */

public class Top10MoviesTest {

    private Top10Movies top10movies;
    private Movie[] starterList;

    @Before
    public void before() throws Exception {
        Movie[] starterList = {
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
    }

    @Test
    public void canCreateList() throws Exception {
        top10movies = new Top10Movies();
        assertEquals(10, top10movies.getList().length);
    }

    @Test
    public void canAddMoviesToList() throws Exception {
        top10movies = new Top10Movies();
        Movie[] starterList = {
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
        top10movies.setList(starterList);
        assertEquals("The Exorcist", top10movies.getByIndex(0).getTitle());
        assertEquals(MovieGenres.SCIFI, top10movies.getByIndex(8).getGenre());
        assertEquals(1, top10movies.getByIndex(0).getRanking());
    }
}
