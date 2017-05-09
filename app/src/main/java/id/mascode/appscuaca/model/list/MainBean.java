package id.mascode.appscuaca.model.list;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sn on 09/05/17.
 * Mascode.id
 */


public class MainBean {
    @SerializedName("temp")
    public double temp;
    @SerializedName("temp_min")
    public double temp_min;
    @SerializedName("temp_max")
    public double temp_max;
    @SerializedName("pressure")
    public double pressure;
    @SerializedName("sea_level")
    public double sea_level;
    @SerializedName("grnd_level")
    public double grnd_level;
    @SerializedName("humidity")
    public int humidity;
    @SerializedName("temp_kf")
    public double temp_kf;
}

