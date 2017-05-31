package info.androidhive.enlightenapp.core;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by carlos on 28/05/17.
 */

public interface DetailService
{
    @GET("get.php?")
    Call<Detail> getDetail(@Query("code") String code);
}
