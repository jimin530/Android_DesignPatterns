package com.jmdroid.boxofficechart.dto.data;

/**
 * Created by jimin on 2017. 8. 11..
 */

public class BoxOffice {
    String rank; // 순위
    String movieNm; // 영화이름
    String openDt; // 개봉일
    String audiCnt; // 해당일 관객수
    String audiAcc; // 누적 관객수

    public BoxOffice() {
    }

    public BoxOffice(String rank, String movieNm, String openDt, String audiCnt, String audiAcc) {

        this.rank = rank;
        this.movieNm = movieNm;
        this.openDt = openDt;
        this.audiCnt = audiCnt;
        this.audiAcc = audiAcc;
    }

    public String getRank() {

        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getMovieNm() {
        return movieNm;
    }

    public void setMovieNm(String movieNm) {
        this.movieNm = movieNm;
    }

    public String getOpenDt() {
        return openDt;
    }

    public void setOpenDt(String openDt) {
        this.openDt = openDt;
    }

    public String getAudiCnt() {
        return audiCnt;
    }

    public void setAudiCnt(String audiCnt) {
        this.audiCnt = audiCnt;
    }

    public String getAudiAcc() {
        return audiAcc;
    }

    public void setAudiAcc(String audiAcc) {
        this.audiAcc = audiAcc;
    }
}
