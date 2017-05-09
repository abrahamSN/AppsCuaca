package id.mascode.appscuaca.model;

import id.mascode.appscuaca.model.city.CoordBean;

/**
 * Created by sn on 09/05/17.
 * Mascode.id
 */


public class CityBean {

    private int id;
    private String name;
    private CoordBean coord;
    private String country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CoordBean getCoord() {
        return coord;
    }

    public void setCoord(CoordBean coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
