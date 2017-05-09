package id.mascode.appscuaca;

import android.app.Application;
import android.content.Context;

import id.mascode.appscuaca.data.AppFactory;
import id.mascode.appscuaca.data.AppService;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by sn on 09/05/17.
 * Mascode.id
 */

public class AppApplication extends Application {

    private AppService appService;
    private Scheduler scheduler;

    private static AppApplication get(Context context) {
        return (AppApplication) context.getApplicationContext();
    }

    public static AppApplication create(Context context) {
        return AppApplication.get(context);
    }

    public AppService getWeatherService() {
        if(appService == null) {
            appService = AppFactory.create();
        }

        return appService;
    }

    public Scheduler subscribeScheduler() {
        if(scheduler == null) {
            scheduler = Schedulers.io();
        }
        return scheduler;
    }

    public void setAppService(AppService appService) {
        this.appService = appService;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }
}
