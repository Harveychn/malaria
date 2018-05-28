package com.edupractice.malaria.modules.outbreakAnalysis.pojo;

/**
 * 热力图展示层对象
 */
public class HotMapVO {
    private String addressID;
    private String lng;
    private String lat;

    public String getAddressID() {
        return addressID;
    }

    public void setAddressID(String addressID) {
        this.addressID = addressID;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
}
