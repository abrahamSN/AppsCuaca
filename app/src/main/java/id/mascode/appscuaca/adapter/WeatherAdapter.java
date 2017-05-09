package id.mascode.appscuaca.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.Collections;
import java.util.List;

import id.mascode.appscuaca.R;
import id.mascode.appscuaca.databinding.ItemWeatherBinding;
import id.mascode.appscuaca.model.ListBean;
import id.mascode.appscuaca.viewmodel.ItemWeatherViewModel;

/**
 * Created by sn on 10/05/17.
 * Mascode.id
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherAdapterViewHolder> {

    private List<ListBean> listBeen;

    public WeatherAdapter() {
        this.listBeen = Collections.emptyList();
    }

    @Override
    public WeatherAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemWeatherBinding itemWeatherBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_weather,
                        parent, false);
        return new WeatherAdapterViewHolder(itemWeatherBinding);
    }

    @Override
    public void onBindViewHolder(WeatherAdapter.WeatherAdapterViewHolder holder, int position) {
        holder.bindWeather(listBeen.get(position));
    }

    @Override
    public int getItemCount() {
        return listBeen.size();
    }

    public void setWeatherList(List<ListBean> listBean) {
        this.listBeen = listBean;
        notifyDataSetChanged();
    }

    public static class WeatherAdapterViewHolder extends RecyclerView.ViewHolder {

        ItemWeatherBinding itemWeatherBinding;

        public WeatherAdapterViewHolder(ItemWeatherBinding itemWeatherBinding) {
            super(itemWeatherBinding.itemWeather);
            this.itemWeatherBinding = itemWeatherBinding;
        }

        void bindWeather(ListBean listBean) {
            if(itemWeatherBinding.getWeatherViewModel() == null) {
                itemWeatherBinding.setWeatherViewModel(
                        new ItemWeatherViewModel(listBean, itemView.getContext())
                );
            } else {
                itemWeatherBinding.getWeatherViewModel().setWeather(listBean);
            }
        }
    }
}
