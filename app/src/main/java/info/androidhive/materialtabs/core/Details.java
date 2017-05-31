package info.androidhive.materialtabs.core;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by carlos on 29/05/17.
 */

public class Details
{
    @SerializedName("Details")
    private Detail detail;

    public Detail getDetail()
    {
        return detail;
    }
}
