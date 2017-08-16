package com.estimote.indoorapp;

/**
 * Created by tombarrett on 10/08/2017.
 */

public class EmpDetails {

    private String name = "unset";
    private String email;
    private String id;
    private String job;
    private String phone;

    public EmpDetails(String name, String email, String id, String job, String phone) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.job = job;
        this.phone = phone;
    }

    public EmpDetails() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}


