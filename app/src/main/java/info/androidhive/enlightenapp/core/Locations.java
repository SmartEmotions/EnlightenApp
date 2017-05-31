package info.androidhive.enlightenapp.core;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by carlos on 25/05/17.
 */

public class Locations
{
    @SerializedName("Places")
    private ArrayList<Place> locations;

    public ArrayList<Place> getLocations()
    {
        return locations;
    }
}
