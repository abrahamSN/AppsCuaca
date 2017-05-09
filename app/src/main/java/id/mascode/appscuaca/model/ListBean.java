package id.mascode.appscuaca.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import id.mascode.appscuaca.model.list.MainBean;
import id.mascode.appscuaca.model.list.WeatherBean;

/**
 * Created by sn on 09/05/17.
 * Mascode.id
 */


public class ListBean {
    @SerializedName("dt")
    public int dt;
    @SerializedName("main")
    public MainBean main;
    @SerializedName("dt_txt")
    public String dt_txt;
    @SerializedName("weather")
    public List<WeatherBean> weather;

}
