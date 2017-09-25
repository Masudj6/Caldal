package com.sk.chaldal.model;

/**
 * Created by sk on 9/20/2017.
 */

public class HeaderDataModel {
    private String headerName;
    private int image;

    public HeaderDataModel() {
    }

    public HeaderDataModel(String headerName, int image) {
        this.headerName = headerName;
        this.image = image;
    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
