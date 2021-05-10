package com.ytooo.bean;

/**
 * Author: 王乾
 * Date: 2021/5/8 13:15
 */
public class Movie {
    private  static double  leastToTopMovie=50;
    private static double allMovieMeanScore=3.328;

    String movieId;
    double WRscore;
    double meanscore;
    int voteNumber;
    String country;
    public double getWRScore(){
        WRscore=(voteNumber)*meanscore/(voteNumber+leastToTopMovie)+(leastToTopMovie)*allMovieMeanScore/(voteNumber+leastToTopMovie);
        return WRscore;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public double getWRscore() {
        return WRscore;
    }

    public void setWRscore(double WRscore) {
        this.WRscore = WRscore;
    }

    public double getMeanscore() {
        return meanscore;
    }

    public void setMeanscore(double meanscore) {
        this.meanscore = meanscore;
    }

    public int getVoteNumber() {
        return voteNumber;
    }

    public void setVoteNumber(int voteNumber) {
        this.voteNumber = voteNumber;
    }
}
