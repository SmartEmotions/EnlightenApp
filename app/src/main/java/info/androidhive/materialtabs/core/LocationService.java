package info.androidhive.materialtabs.core;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by carlos on 27/05/17.
 */

public interface LocationService
{
    @GET("webservices/getLocations.php")
    Call<Locations> getLocations();
}
