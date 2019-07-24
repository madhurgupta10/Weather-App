package com.example.weatherapp.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Geometry {

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("geometries")
    @Expose
    private List<Geometries> geometries = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Geometries> getGeometries() {
        return geometries;
    }

    public void setGeometries(List<Geometries> geometries) {
        this.geometries = geometries;
    }

}
