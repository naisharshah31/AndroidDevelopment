package com.example.detailslab6;

public class UserHelperClass {

    String username, preferredCities, ageGroup, password;

    public UserHelperClass() {
    }

    public UserHelperClass(String username, String preferredCities, String ageGroup, String password) {
        this.username = username;
        this.preferredCities = preferredCities;
        this.ageGroup = ageGroup;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
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
