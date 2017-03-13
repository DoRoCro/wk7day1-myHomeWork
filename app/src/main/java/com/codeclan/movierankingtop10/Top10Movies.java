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

    public void promoteRanking(int rankingtopromote) {
        if (rankingtopromote <= 1 || rankingtopromote > 10) {
            return;
        }
        Movie tmpmovie = this.list[rankingtopromote - 2];
        tmpmovie.setRanking(rankingtopromote);
        this.list[rankingtopromote - 2] = this.list[rankingtopromote-1];
        this.list[rankingtopromote - 2].setRanking(rankingtopromote - 1);
        this.list[rankingtopromote - 1] = tmpmovie;

    }

    public void demoteRanking(int rankingtodemote) {
        if (rankingtodemote <= 0 || rankingtodemote > 9) {
            return;
        }
        Movie tmpmovie = this.list[rankingtodemote - 1];
        tmpmovie.setRanking(rankingtodemote + 1);
        this.list[rankingtodemote - 1] = this.list[rankingtodemote];
        this.list[rankingtodemote] = tmpmovie;
        this.list[rankingtodemote - 1 ].setRanking(rankingtodemote);
    }
}