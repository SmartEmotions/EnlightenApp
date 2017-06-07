package info.androidhive.enlightenapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import java.util.Timer;
import java.util.TimerTask;
import info.androidhive.enlightenapp.R;
import info.androidhive.enlightenapp.core.Position;

public class MainScreen extends AppCompatActivity
{
    private int[] gallery = { R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4};
    private static final Integer DURATION = 4000;
    private ImageSwitcher slider;
    private Button btnDetails;
    private Timer timer = null;
    private int pos;
    public Position position;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        position = new Position(this);
        setContentView(R.layout.activity_main);
        slider = (ImageSwitcher) findViewById(R.id.slider);
        btnDetails = (Button) findViewById(R.id.btnCustomIconTabs);
        btnDetails.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent details = new Intent(new Intent(MainScreen.this, TabsScreen.class));
                details.putExtra("Code", "27");
                startActivity(details);
            }
        });
        slider.setFactory(new ViewSwitcher.ViewFactory()
        {

            public View makeView()
            {
                return new ImageView(MainScreen.this);
            }
        });
        Animation fadeIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        Animation fadeOut = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        slider.setInAnimation(fadeIn);
        slider.setOutAnimation(fadeOut);
        startSlider();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
    }
    @Override
    protected void onStop()
    {
        position.disconnect();
        super.onStop();
    }

    public void startSlider()
    {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask()
        {

            public void run()
            {
                runOnUiThread(new Runnable()
                {
                    public void run()
                    {
                        slider.setImageResource(gallery[pos]);
                        pos++;
                        if (pos == gallery.length)
                        {
                            pos = 0;
                        }
                    }
                });
            }

        }, 0, DURATION);
    }

    @Override
    public void onPause()
    {
        super.onPause();
    }
}
