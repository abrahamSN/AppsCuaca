package id.mascode.appscuaca.data;

import id.mascode.appscuaca.Env;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sn on 09/05/17.
 * Mascode.id
 */

public class AppFactory {

    public static AppService create() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Env.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(AppService.class);
    }
}
