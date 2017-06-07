package info.androidhive.enlightenapp.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;


import info.androidhive.enlightenapp.core.Detail;
import info.androidhive.enlightenapp.fragments.Activities;
import info.androidhive.enlightenapp.fragments.Description;
import info.androidhive.enlightenapp.fragments.History;
import info.androidhive.enlightenapp.R;
import info.androidhive.enlightenapp.core.DetailService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TabsScreen extends AppCompatActivity
{

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Detail detail;
    private String code;
    private Activities activitiesFrag;
    private Description descriptionFrag;
    private History historyFrag;
    private boolean flag;
    public Retrofit jsonDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        activitiesFrag = new Activities();
        descriptionFrag = new Description();
        historyFrag = new History();

        historyFrag.setTextDescription(getIntent().getExtras().getString("Historia"));
        descriptionFrag.setTextDescription(getIntent().getExtras().getString("Descripcion"));
        activitiesFrag.setTextDescription(getIntent().getExtras().getString("Actividades"));
        //code = getIntent().getExtras().getString("Descripcion");
        //jsonDetail = new Retrofit.Builder().baseUrl("http://seminarioapp.dx.am/webservices/")
        //                                   .addConverterFactory(GsonConverterFactory.create())
        //                                   .build();
        //loadDetail();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

    }

    private void setupTabIcons()
    {
        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("Description");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_description, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("History");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_history, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("Activities");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_activities, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);
    }

    /*

    public void loadDetail()
    {


        DetailService detailService = jsonDetail.create(DetailService.class);
        Call<Detail> call = detailService.getDetail(code);
        call.enqueue(new Callback<Detail>()
        {
            @Override
            public void onResponse(Call<Detail> call, Response<Detail> response)
            {
                detail = response.body();
                historyFrag.setTextDescription(detail.getHistory());
                descriptionFrag.setTextDescription(detail.getDescription());
                activitiesFrag.setTextDescription(detail.getActivities());
                flag = true;
            }

            @Override
            public void onFailure(Call<Detail> call, Throwable t)
            {
            }
        });
    }

    */
    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(descriptionFrag, "ONE");
        adapter.addFrag(historyFrag, "TWO");
        adapter.addFrag(activitiesFrag, "THREE");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter
    {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager)
        {
            super(manager);
        }

        @Override
        public Fragment getItem(int position)
        {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount()
        {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title)
        {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            return mFragmentTitleList.get(position);
        }
    }
}
