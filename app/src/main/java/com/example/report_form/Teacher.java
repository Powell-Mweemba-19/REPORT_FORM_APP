package com.example.report_form;

public class Teacher {

    String fullName;
    String email;
    String passWord;
    String subject;
    String gender;

    //empty
    public Teacher() {
    }

    public Teacher(String fullName, String email, String passWord) {
        this.fullName = fullName;
        this.email = email;
        this.passWord = passWord;
    }

    public Teacher(String fullName,String passWord, String email,  String subject, String gender) {
        this.fullName = fullName;
        this.passWord = passWord;
        this.email = email;
        this.subject = subject;
        this.gender = gender;

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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
