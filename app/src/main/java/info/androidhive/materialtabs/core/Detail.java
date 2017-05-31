package info.androidhive.materialtabs.core;

import com.google.gson.annotations.SerializedName;

/**
 * Created by carlos on 28/05/17.
 */

public class Detail
{
    @SerializedName("id")
    private String id;
    @SerializedName("description")
    private  String description;
    @SerializedName("history")
    private  String history;
    @SerializedName("activities")
    private  String activities;

    public String getDescription()
    {
        return description;
    }
    public String getHistory()
    {
        return history;
    }
    public String getActivities()
    {
        return activities;
    }

}
