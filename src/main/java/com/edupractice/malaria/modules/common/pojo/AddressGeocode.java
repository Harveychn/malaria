package com.edupractice.malaria.modules.common.pojo;

public class AddressGeocode {
    private Integer addressId;

    private String lat;

    private String lng;

    private String precise;

    private String confidence;

    private String level;

    private String address;

    private Integer addrNationId;

    public AddressGeocode(Integer addressId, String lat, String lng, String precise, String confidence, String level, String address, Integer addrNationId) {
        this.addressId = addressId;
        this.lat = lat;
        this.lng = lng;
        this.precise = precise;
        this.confidence = confidence;
        this.level = level;
        this.address = address;
        this.addrNationId = addrNationId;
    }

    public AddressGeocode() {
        super();
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng == null ? null : lng.trim();
    }

    public String getPrecise() {
        return precise;
    }

    public void setPrecise(String precise) {
        this.precise = precise == null ? null : precise.trim();
    }

    public String getConfidence() {
        return confidence;
    }

    public void setConfidence(String confidence) {
        this.confidence = confidence == null ? null : confidence.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getAddrNationId() {
        return addrNationId;
    }

    public void setAddrNationId(Integer addrNationId) {
        this.addrNationId = addrNationId;
    }
}