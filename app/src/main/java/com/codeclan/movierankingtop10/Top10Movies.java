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
}