package info.androidhive.enlightenapp.core;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;

import info.androidhive.enlightenapp.activity.MainScreen;
import info.androidhive.enlightenapp.activity.TabsScreen;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.lang.Math.round;

/**
 * Created by carlos on 21/05/17.
 */

public class Position implements GoogleApiClient.ConnectionCallbacks,
                                 GoogleApiClient.OnConnectionFailedListener,
                                 LocationListener
{
    private final String TAG = "TestApp";
    private LocationRequest locRequest;
    private GoogleApiClient apiClient;
    private Locations points;
    private boolean flag;
    public Retrofit jsonService;
    public MainScreen context;


    public Position(MainScreen main)
    {
        context = main;
        flag = false;
        jsonService = new Retrofit.Builder().baseUrl("http://seminarioapp.dx.am/")
                                            .addConverterFactory(GsonConverterFactory.create())
                                            .build();
        loadLocations();
        apiClient = new GoogleApiClient.Builder(context)
                                       .addApi(LocationServices.API)
                                       .addConnectionCallbacks(this)
                                       .addOnConnectionFailedListener(this)
                                       .build();
        apiClient.connect();
    }
    @Override
    public void onConnected(Bundle bundle)
    {
        locRequest = LocationRequest.create();
        locRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locRequest.setInterval(1000);
        LocationServices.FusedLocationApi.requestLocationUpdates(apiClient, locRequest, this);
    }

    @Override
    public void onConnectionSuspended(int i)
    {
        Log.i(TAG, "La conexión de GPS se ha suspendido");
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult)
    {
        Log.i(TAG, "La conexión de GPS falló");
    }

    @Override
    public void onLocationChanged(Location location)
    {
        if (flag)
        {
            ArrayList<Place> places = points.getLocations();
            for (int i = 0 ; i < places.size() ; i++)
            {
                double distance = round(location.distanceTo(places.get(i).getLocation()));
                if (distance < 50)
                {
                    Intent details = new Intent(new Intent(context, TabsScreen.class));
                    details.putExtra("Code", places.get(i).getId());
                    context.startActivity(details);
                    break;
                }
            }
        }
    }

    public void disconnect()
    {
        apiClient.disconnect();
    }

    public void pause()
    {
        apiClient.disconnect();
    }

    public void loadLocations()
    {
        /*final Retrofit retrofit = new Retrofit.Builder().baseUrl("http://seminarioapp.dx.am/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();*/
        LocationService service = jsonService.create(LocationService.class);
        Call<Locations> call = service.getLocations();

        call.enqueue(new Callback<Locations>()
        {
            @Override
            public void onResponse(Call<Locations> call, Response<Locations> response)
            {
                points = response.body();
                flag = true;
            }

            @Override
            public void onFailure(Call<Locations> call, Throwable t)
            {
                flag = false;
            }
        });
    }
}
