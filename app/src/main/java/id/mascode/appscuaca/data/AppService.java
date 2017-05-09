package id.mascode.appscuaca.data;

import id.mascode.appscuaca.model.response.ForecastResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by sn on 09/05/17.
 * Mascode.id
 */

public interface AppService {

    @GET
    Observable<ForecastResponse> getForecast(@Url String url);
}
