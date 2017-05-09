package id.mascode.appscuaca.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

import java.util.Observable;
import java.util.Observer;

import id.mascode.appscuaca.R;
import id.mascode.appscuaca.adapter.WeatherAdapter;
import id.mascode.appscuaca.data.AppFactory;
import id.mascode.appscuaca.databinding.ActivityMainBinding;
import id.mascode.appscuaca.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity implements Observer{

    private ActivityMainBinding activityMainBinding;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDataBinding();
        setSupportActionBar(activityMainBinding.toolbar);
        setupListWeatherView(activityMainBinding.listWeather);
        setupObserver(mainViewModel);
    }

    private void initDataBinding() {
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = new MainViewModel(this);
        activityMainBinding.setMainViewModel(mainViewModel);
    }

    private void setupListWeatherView(RecyclerView listWeather) {
        WeatherAdapter weatherAdapter = new WeatherAdapter();
        listWeather.setAdapter(weatherAdapter);
        listWeather.setLayoutManager(new LinearLayoutManager(this));
    }

    public void setupObserver(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainViewModel.reset();
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof MainViewModel) {
            WeatherAdapter weatherAdapter = (WeatherAdapter) activityMainBinding.listWeather.getAdapter();
            MainViewModel mainViewModel = (MainViewModel) o;
            weatherAdapter.setWeatherList(mainViewModel.getWeatherList());
        }
    }
}
