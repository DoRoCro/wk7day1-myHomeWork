package com.codeclan.movierankingtop10;

/**
 * Created by user on 13/03/2017.
 */

public class Top10Movies {

    private Movie[] list;

    public Top10Movies() {
        this.list = new Movie[10];
    }

    public Movie[] getList() {
        return list;
    }

    public void setList(Movie[] list) {
        this.list = list;
    }


    public Movie getByIndex(int i) {
        return this.list[i];
    }


    public Movie getByRanking(int ranking) {
        return this.getByIndex(ranking - 1);
    }

    public void setNumber10(Movie newmovie) {
        this.list[9] = newmovie;
    }

    public Movie find(String title) {
        for(Movie movie : this.list){
            if (movie.getTitle() == title) {return movie;}
        }
        return null;
    }
}