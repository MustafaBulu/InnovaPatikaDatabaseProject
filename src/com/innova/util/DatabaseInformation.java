package com.innova.util;

abstract public class DatabaseInformation {

    //object variables
    private String url;
    private String userName;
    private String userPassword;
    //Class yapısını göstermek için forNameData
    private String forNameData;

    //constructure

    public DatabaseInformation() {
        /*
        //postgresql

        this.url="jdbc:postgresql://localhost:5432/innova_patika_project_1";
        this.userName="postgres";
        this.userPassword="postgres";
        this.forNameData="org.postgresql.Driver"; */

        //mysql

        this.url="jdbc:mysql://localhost:3331/innova_patika_project_1";
        this.userName="root";
        this.userPassword="root";
        this.forNameData="com.mysql.jdbc.Driver";

    }

    public DatabaseInformation(String url, String userName, String userPassword, String forNameData) {
        this.url = url;
        this.userName = userName;
        this.userPassword = userPassword;
        this.forNameData = forNameData;
    }

    //tostring

    @Override
    public String toString() {
        return "DatabaseInformation{" +
                "url='" + url + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", forNameData='" + forNameData + '\'' +
                '}';
    }

    //getter setter

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getForNameData() {
        return forNameData;
    }

    public void setForNameData(String forNameData) {
        this.forNameData = forNameData;
    }


}
