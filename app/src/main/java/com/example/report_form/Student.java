package com.example.report_form;

public class Student {



    String fullName;
    String email;
    String sitNumb;
    String Math;
    String english;
    String science;
    String computer;
    String social;
    String status;
    String percentage;


    //empty
    public Student() {
    }

    public Student(String fullName, String email, String sitNumb, String math, String english, String science, String computer, String social, String status, String percentage) {
        this.fullName = fullName;
        this.email = email;
        this.sitNumb = sitNumb;
        Math = math;
        this.english = english;
        this.science = science;
        this.computer = computer;
        this.social = social;
        this.status = status;
        this.percentage = percentage;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSitNumb() {
        return sitNumb;
    }

    public void setSitNumb(String sitNumb) {
        this.sitNumb = sitNumb;
    }

    public String getMath() {
        return Math;
    }

    public void setMath(String math) {
        Math = math;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getScience() {
        return science;
    }

    public void setScience(String science) {
        this.science = science;
    }

    public String getComputer() {
        return computer;
    }

    public void setComputer(String computer) {
        this.computer = computer;
    }

    public String getSocial() {
        return social;
    }

    public void setSocial(String social) {
        this.social = social;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}

