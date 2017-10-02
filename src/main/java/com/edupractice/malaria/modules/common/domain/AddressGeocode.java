package com.edupractice.malaria.modules.common.domain;

public class AddressGeocode {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address_geocode.addressID
     *
     * @mbggenerated
     */
    private Integer addressid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address_geocode.lat
     *
     * @mbggenerated
     */
    private String lat;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address_geocode.lng
     *
     * @mbggenerated
     */
    private String lng;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address_geocode.precise
     *
     * @mbggenerated
     */
    private String precise;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address_geocode.confidence
     *
     * @mbggenerated
     */
    private String confidence;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address_geocode.level
     *
     * @mbggenerated
     */
    private String level;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address_geocode.address
     *
     * @mbggenerated
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address_geocode.addrNationID
     *
     * @mbggenerated
     */
    private Integer addrnationid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address_geocode.addressID
     *
     * @return the value of address_geocode.addressID
     *
     * @mbggenerated
     */
    public Integer getAddressid() {
        return addressid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address_geocode.addressID
     *
     * @param addressid the value for address_geocode.addressID
     *
     * @mbggenerated
     */
    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address_geocode.lat
     *
     * @return the value of address_geocode.lat
     *
     * @mbggenerated
     */
    public String getLat() {
        return lat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address_geocode.lat
     *
     * @param lat the value for address_geocode.lat
     *
     * @mbggenerated
     */
    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address_geocode.lng
     *
     * @return the value of address_geocode.lng
     *
     * @mbggenerated
     */
    public String getLng() {
        return lng;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address_geocode.lng
     *
     * @param lng the value for address_geocode.lng
     *
     * @mbggenerated
     */
    public void setLng(String lng) {
        this.lng = lng == null ? null : lng.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address_geocode.precise
     *
     * @return the value of address_geocode.precise
     *
     * @mbggenerated
     */
    public String getPrecise() {
        return precise;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address_geocode.precise
     *
     * @param precise the value for address_geocode.precise
     *
     * @mbggenerated
     */
    public void setPrecise(String precise) {
        this.precise = precise == null ? null : precise.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address_geocode.confidence
     *
     * @return the value of address_geocode.confidence
     *
     * @mbggenerated
     */
    public String getConfidence() {
        return confidence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address_geocode.confidence
     *
     * @param confidence the value for address_geocode.confidence
     *
     * @mbggenerated
     */
    public void setConfidence(String confidence) {
        this.confidence = confidence == null ? null : confidence.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address_geocode.level
     *
     * @return the value of address_geocode.level
     *
     * @mbggenerated
     */
    public String getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address_geocode.level
     *
     * @param level the value for address_geocode.level
     *
     * @mbggenerated
     */
    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address_geocode.address
     *
     * @return the value of address_geocode.address
     *
     * @mbggenerated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address_geocode.address
     *
     * @param address the value for address_geocode.address
     *
     * @mbggenerated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address_geocode.addrNationID
     *
     * @return the value of address_geocode.addrNationID
     *
     * @mbggenerated
     */
    public Integer getAddrnationid() {
        return addrnationid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address_geocode.addrNationID
     *
     * @param addrnationid the value for address_geocode.addrNationID
     *
     * @mbggenerated
     */
    public void setAddrnationid(Integer addrnationid) {
        this.addrnationid = addrnationid;
    }
}