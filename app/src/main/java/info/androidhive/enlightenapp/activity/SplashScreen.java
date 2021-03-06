package info.androidhive.enlightenapp.activity;

/**
 * Created by carlos on 12/05/17.
 */
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.view.WindowManager;
import info.androidhive.enlightenapp.R;
public class SplashScreen extends Activity
{
    private final int DURACION_SPLASH = 3000; // 3 segundos

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent(SplashScreen.this, MainScreen.class);
                startActivity(intent);
                finish();
            };
        }, DURACION_SPLASH);
    }
}