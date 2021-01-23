package com.example.detailslab6;

public class UserHelperClass {

    String username, preferredCities, ageGroup;

    public UserHelperClass() {
    }

    public UserHelperClass(String username, String preferredCities, String ageGroup) {
        this.username = username;
        this.preferredCities = preferredCities;
        this.ageGroup = ageGroup;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPreferredCities() {
        return preferredCities;
    }

    public void setPreferredCities(String preferredCities) {
        this.preferredCities = preferredCities;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }
}
