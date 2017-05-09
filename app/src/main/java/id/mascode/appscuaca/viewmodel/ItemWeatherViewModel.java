package id.mascode.appscuaca.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.view.View;

import java.util.List;

import id.mascode.appscuaca.WeatherDetailActivity;
import id.mascode.appscuaca.model.ListBean;

/**
 * Created by sn on 10/05/17.
 * Mascode.id
 */

public class ItemWeatherViewModel extends BaseObservable {

    private ListBean listBean;
    private Context context;

    public ItemWeatherViewModel(ListBean listBean, Context context) {
        this.listBean = listBean;
        this.context = context;
    }

    public void onItemClick(View view) {
        //context.startActivity(WeatherDetailActivity.launchDetail(view.getContext(), listBean));
    }

    public String getDtTxt() {
        return listBean.dt_txt;
    }

    public String getTempMax() {
        return String.valueOf(listBean.main.temp_max);
    }

    public String getTempMin() {
        return String.valueOf(listBean.main.temp_min);
    }

    public void setWeather(ListBean listBean) {
        this.listBean = listBean;
        notifyChange();
    }
}
