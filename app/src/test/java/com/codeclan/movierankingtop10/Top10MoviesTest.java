package com.codeclan.movierankingtop10;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 13/03/2017.
 */

public class Top10MoviesTest {

    private Top10Movies top10movies;
    private Movie[] starterList ={
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

    @Before
    public void before() throws Exception {

    }

    @Test
    public void canCreateList() throws Exception {
        top10movies = new Top10Movies();
        assertEquals(10, top10movies.getList().length);
    }

    @Test
    public void canAddMoviesToList() throws Exception {
        top10movies = new Top10Movies();
        top10movies.setList(starterList);
        assertEquals("The Exorcist", top10movies.getByIndex(0).getTitle());
        assertEquals(MovieGenres.SCIFI, top10movies.getByIndex(8).getGenre());
        assertEquals(1, top10movies.getByIndex(0).getRanking());
    }

    @Test
    public void canGetByRanking() throws Exception {
        top10movies = new Top10Movies();
        top10movies.setList(starterList);
        assertEquals("Blazing Saddles", top10movies.getByRanking(10).getTitle());
        assertEquals("The Exorcist", top10movies.getByRanking(1).getTitle());
    }

    @Test
    public void canReplaceLastMovie() throws Exception {
        top10movies = new Top10Movies();
        top10movies.setList(starterList);
        Movie newmovie = new Movie("Logan", MovieGenres.SCIFI, 10);
        top10movies.setNumber10(newmovie);
        assertEquals("Logan", top10movies.getByRanking(10).getTitle());
    }

    @Test
    public void canFindMovieByTitle() throws Exception {
        top10movies = new Top10Movies();
        top10movies.setList(starterList);
        assertEquals("Dredd", top10movies.find("Dredd").getTitle());
        assertNull(top10movies.find("Jaws"));
    }

    @Test
    public void canSwapMoviesInList() throws Exception {
        top10movies = new Top10Movies();
        top10movies.setList(starterList);
        top10movies.promoteRanking(9);
        assertEquals("Dredd", top10movies.getByRanking(8).getTitle());
        assertEquals(9, top10movies.getByRanking(9).getRanking());
        assertEquals(8, top10movies.getByRanking(8).getRanking());
        assertEquals("Love and Death", top10movies.getByRanking(9).getTitle());
    }

    @Test
    public void canSwapMoviesInListReverse() throws Exception {
        top10movies = new Top10Movies();
        top10movies.setList(starterList);
        top10movies.demoteRanking(1);
        assertEquals("Brazil", top10movies.getByRanking(1).getTitle());
        assertEquals(2, top10movies.getByRanking(2).getRanking());
        assertEquals(1, top10movies.getByRanking(1).getRanking());
        assertEquals("The Exorcist", top10movies.getByRanking(2).getTitle());
    }
}
