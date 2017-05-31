package info.androidhive.materialtabs.core;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by carlos on 28/05/17.
 */

public interface DetailService
{
    @GET("get.php?")
    Call<Details> getDetail(@Query("code") String code);
}
