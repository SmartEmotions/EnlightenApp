package info.androidhive.enlightenapp.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.TextView;

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
    private TextView description, history, activities;
    private Detail detail;
    private String code;
    private boolean flag;
    public Retrofit jsonDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        code = getIntent().getExtras().getString("Code");
        jsonDetail = new Retrofit.Builder().baseUrl("http://seminarioapp.dx.am/webservices/")
                                           .addConverterFactory(GsonConverterFactory.create())
                                           .build();

        setContentView(R.layout.activity_details);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        loadDetail();
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
                activities = (TextView) findViewById(R.id.activities);
                description = (TextView) findViewById(R.id.description);
                history = (TextView) findViewById(R.id.history);
                //activities.setText(detail.getActivities());
                description.setText(detail.getDescription());
                //history.setText(detail.getHistory());
                flag = true;
            }

            @Override
            public void onFailure(Call<Detail> call, Throwable t)
            {
            }
        });
    }
    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Description(), "ONE");
        adapter.addFrag(new History(), "TWO");
        adapter.addFrag(new Activities(), "THREE");
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
