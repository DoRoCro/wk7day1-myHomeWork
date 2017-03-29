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
                    swapMoviesByIndex(i, i+1);
                    isInOrder = false;
                }
                // last pass will do no swaps, isInOrder remains true
            }
        }
        return this;
    }

    public void swapMoviesByIndex(int a, int b){
        // swap two movies in list using array indexes, no bounds checking
        Movie tmpmovie = this.list[a];
        this.list[a] = this.list[b];
        this.list[b] = tmpmovie;
    }

    public int findIndexForTitleByJumpSearch(String target){
        // calculate jump size
        Double jumpSizeAsDouble = Math.floor(Math.sqrt(this.list.length));
        int jumpSize = (int)jumpSizeAsDouble.longValue();

        // jump through list until find a value > target or reach last value less than length of array
        int jumpTo = jumpSize;
        while ( jumpTo <= this.list.length - 1){
            if (this.list[(int)jumpTo].getTitle().compareToIgnoreCase(target)>0){
                // have found the right block to search so search it with linear search
                // starting at jumpTo - jumpSize
                for (int i=jumpTo - jumpSize; i<= jumpTo ; i++ ){
                    if ( this.list[i].getTitle().compareToIgnoreCase(target)==0 ){
                        // title found
                        return i;
                    }
                }
                // target not found
                return -1;
            }
            jumpTo = jumpTo + jumpSize;
            if (jumpTo > this.list.length -1) jumpTo = this.list.length -1;
            // should not get stuck in loop here as should fall into linear search and return found or not found
        }
        return -1;
    }
}