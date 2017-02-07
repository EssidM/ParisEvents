
package com.frichti.parisevents.entity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fields {

    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("free_text")
    @Expose
    private String freeText;
    @SerializedName("latlon")
    @Expose
    private List<Double> latlon = null;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("pricing_info")
    @Expose
    private String pricingInfo;
    @SerializedName("date_start")
    @Expose
    private String dateStart;
    @SerializedName("department")
    @Expose
    private String department;
    @SerializedName("image_thumb")
    @Expose
    private String imageThumb;
    @SerializedName("date_end")
    @Expose
    private String dateEnd;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("tags")
    @Expose
    private String tags;
    @SerializedName("space_time_info")
    @Expose
    private String spaceTimeInfo;
    @SerializedName("timetable")
    @Expose
    private String timetable;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("placename")
    @Expose
    private String placename;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("program_uid")
    @Expose
    private String programUid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getFreeText() {
        return freeText;
    }

    public void setFreeText(String freeText) {
        this.freeText = freeText;
    }

    public List<Double> getLatlon() {
        return latlon;
    }

    public void setLatlon(List<Double> latlon) {
        this.latlon = latlon;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPricingInfo() {
        return pricingInfo;
    }

    public void setPricingInfo(String pricingInfo) {
        this.pricingInfo = pricingInfo;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getImageThumb() {
        return imageThumb;
    }

    public void setImageThumb(String imageThumb) {
        this.imageThumb = imageThumb;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getSpaceTimeInfo() {
        return spaceTimeInfo;
    }

    public void setSpaceTimeInfo(String spaceTimeInfo) {
        this.spaceTimeInfo = spaceTimeInfo;
    }

    public String getTimetable() {
        return timetable;
    }

    public void setTimetable(String timetable) {
        this.timetable = timetable;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getPlacename() {
        return placename;
    }

    public void setPlacename(String placename) {
        this.placename = placename;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getProgramUid() {
        return programUid;
    }

    public void setProgramUid(String programUid) {
        this.programUid = programUid;
    }

}
