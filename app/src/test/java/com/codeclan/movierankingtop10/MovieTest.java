package com.codeclan.movierankingtop10;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 13/03/2017.
 */

public class MovieTest {


    Movie movie;

    @Before
    public void before(){
        movie = new Movie("Title", MovieGenres.EPIC, 99 );

    }

    @Test
    public void movieHasTitleGenreRanking(){   // test constructor
        assertEquals("Title", movie.getTitle());
        assertEquals(MovieGenres.EPIC, movie.getGenre());
        assertEquals(99, movie.getRanking());
    }

    @Test
    public void toStringTest() throws Exception {
        assertEquals("Title: 'Title', Genre: EPIC, Ranking: 99", movie.toString());
    }


}

