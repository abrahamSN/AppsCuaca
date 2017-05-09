package id.mascode.appscuaca.model.list;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sn on 09/05/17.
 * Mascode.id
 */


public class WeatherBean {

    @SerializedName("id")
    public int id;
    @SerializedName("main")
    public String main;
    @SerializedName("description")
    public String description;
    @SerializedName("icon")
    public String icon;

}
