package id.mascode.appscuaca.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.view.View;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import id.mascode.appscuaca.AppApplication;
import id.mascode.appscuaca.Env;
import id.mascode.appscuaca.R;
import id.mascode.appscuaca.data.AppService;
import id.mascode.appscuaca.model.ListBean;
import id.mascode.appscuaca.model.response.ForecastResponse;
import id.mascode.appscuaca.view.MainActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by sn on 10/05/17.
 * Mascode.id
 */

public class MainViewModel extends Observable {

    public ObservableInt weatherProgress;
    public ObservableInt weatherRecycler;
    public ObservableInt weatherLabel;
    public ObservableField<String> messageLabel;

    private List<ListBean> listBeanList;
    private Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MainViewModel(@NonNull Context context) {

        this.context = context;
        this.listBeanList = new ArrayList<>();
        weatherProgress = new ObservableInt(View.GONE);
        weatherRecycler = new ObservableInt(View.GONE);
        weatherLabel = new ObservableInt(View.VISIBLE);
        messageLabel = new ObservableField<>(context.getString(R.string.default_loading_weather));
    }

    public void onClickFabLoad(View view) {
        initializeViews();
        fetchWeatherList();
    }

    public void initializeViews() {
        weatherLabel.set(View.GONE);
        weatherRecycler.set(View.GONE);
        weatherProgress.set(View.VISIBLE);
    }

    private void fetchWeatherList() {
        AppApplication appApplication = AppApplication.create(context);
        AppService appService = appApplication.getWeatherService();

        Disposable disposable = appService.getForecast(Env.CORE_URL)
                .subscribeOn(appApplication.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ForecastResponse>() {
                    @Override
                    public void accept(ForecastResponse forecastResponse) throws Exception {
                        changeWeatherDataSet(forecastResponse.getList());
                        weatherLabel.set(View.GONE);
                        weatherRecycler.set(View.VISIBLE);
                        weatherProgress.set(View.GONE);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        messageLabel.set(context.getString(R.string.error_loading_weather));
                        weatherLabel.set(View.GONE);
                        weatherRecycler.set(View.VISIBLE);
                        weatherProgress.set(View.GONE);
                    }
                });
        compositeDisposable.add(disposable);
    }

    private void changeWeatherDataSet(List<ListBean> listBeen) {
        listBeanList.addAll(listBeen);
        setChanged();
        notifyObservers();
    }

    public List<ListBean> getWeatherList() {
        return listBeanList;
    }

    private void unSubscribeFromObservable() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    public void reset() {
        unSubscribeFromObservable();
        compositeDisposable = null;
        context = null;
    }
}
