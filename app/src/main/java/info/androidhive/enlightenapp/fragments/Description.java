package info.androidhive.enlightenapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import info.androidhive.enlightenapp.R;


public class Description extends Fragment
{
    private TextView textView;
    private String text;
    public Description()
    {
    }
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_description, container, false);
        textView = (TextView)view.findViewById(R.id.descriptiontextview);
        textView.setText(text);
        return view;
    }
    public void setTextDescription(String description)
    {
        text = description;
    }
}
