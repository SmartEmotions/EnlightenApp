package info.androidhive.enlightenapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import info.androidhive.enlightenapp.R;


public class History extends Fragment
{
    private TextView textView;
    private String text;
    public History()
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
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        textView = (TextView)view.findViewById(R.id.historytextview);
        textView.setText(text);
        return view;
    }
    public void setTextDescription(String description)
    {
        text = description;
    }
}
