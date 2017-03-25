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
        this.list = list;            // should probably use clone here
//        this.list = list.clone();  // so that we're dealing with a new independent object, not referring to the original object passed in
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
        //
        // post homework comment - could use Collections.swap with an array list
        // but would probably need to access via Arrays.asList() method - see example solution
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

    // example  simple sort for PDA
    // returns copy of top10movie list in array sorter by title, with rankings updated
    public Top10Movies sortByTitle(){
        // sort loop with stopping condition
        // does NOT change rankings to match returned order
        boolean isInOrder = false;
        while(isInOrder == false){
            isInOrder = true;
            for(int i=0; i <= this.list.length - 2; i++){
                // compare neighbouring movies and swap if out of order, flagging list as unsorted
                if (this.list[i].getTitle().compareToIgnoreCase(this.list[i+1].getTitle())> 0) {
                    Movie tmpmovie = this.list[i];
                    this.list[i] = this.list[i+1];
                    this.list[i+1] = tmpmovie;
                    isInOrder = false;
                }
                // last pass will do no swaps, isInOrder remains true
            }
        }
        return this;
    }
}