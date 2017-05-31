package info.androidhive.enlightenapp.core;

import android.location.Location;
import android.net.ParseException;

import com.google.gson.annotations.SerializedName;

/**
 * Created by carlos on 27/05/17.
 */

public class Place
{
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private  String name;
    @SerializedName("latitude")
    private  String latitude;
    @SerializedName("longitude")
    private  String longitude;

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public Location getLocation()
    {
        Location loc = new Location(name);
        try
        {
            loc.setLatitude(Double.parseDouble(latitude));
            loc.setLongitude(Double.parseDouble(longitude));
            return loc;
        }
        catch (ParseException e)
        {
            loc.setLatitude(0.000000);
            loc.setLongitude(0.000000);
            return loc;
        }
    }
}
