package com.estimote.indoorapp.estimote;

/**
 * Created by tombarrett on 03/08/2017.
 */

public class Product {

    private String name;
    private String summary;

    public Product(String name, String summary) {
        this.name = name;
        this.summary = summary;
    }

    public String getName() {
        return name;
    }

    public String getSummary() {
        return summary;
    }
}
