package com.jmdroid.boxofficechart.dto.res;


import com.jmdroid.boxofficechart.dto.data.BoxOffice;

import java.util.List;

/**
 * Created by jimin on 2017. 8. 11..
 */

public class ResBoxOffice {

    BoxOfficeResult boxOfficeResult;

    public BoxOfficeResult getBoxOfficeResult() {
        return boxOfficeResult;
    }

    public void setBoxOfficeResult(BoxOfficeResult boxOfficeResult) {
        this.boxOfficeResult = boxOfficeResult;
    }

    public class BoxOfficeResult {
        private String boxofficeType;
        private String showRange;
        private List<BoxOffice> dailyBoxOfficeList;

        public String getBoxofficeType() {
            return boxofficeType;
        }

        public void setBoxofficeType(String boxofficeType) {
            this.boxofficeType = boxofficeType;
        }

        public String getShowRange() {
            return showRange;
        }

        public void setShowRange(String showRange) {
            this.showRange = showRange;
        }

        public List<BoxOffice> getDailyBoxOfficeList() {
            return dailyBoxOfficeList;
        }

        public void setDailyBoxOfficeList(List<BoxOffice> dailyBoxOfficeList) {
            this.dailyBoxOfficeList = dailyBoxOfficeList;
        }
    }
}
