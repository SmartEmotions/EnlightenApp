package info.androidhive.materialtabs.activity;

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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.materialtabs.R;
import info.androidhive.materialtabs.core.Detail;
import info.androidhive.materialtabs.core.DetailService;
import info.androidhive.materialtabs.core.Details;
import info.androidhive.materialtabs.fragments.Activity;
import info.androidhive.materialtabs.fragments.Description;
import info.androidhive.materialtabs.fragments.History;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.widget.Toast.LENGTH_SHORT;

public class TabsScreen extends AppCompatActivity
{

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Details detail;
    private boolean flag;
    public Retrofit jsonDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
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
        Call<Details> call = detailService.getDetail(getIntent().getExtras().getString("Code"));
        call.enqueue(new Callback<Details>()
        {
            @Override
            public void onResponse(Call<Details> call, Response<Details> response)
            {
                detail = response.body();
                flag = true;
                setDetail();
            }

            @Override
            public void onFailure(Call<Details> call, Throwable t)
            {
            }
        });
    }

    public void setDetail()
    {
        TextView activityText = (TextView) findViewById(R.id.activities);
        TextView descriptionText = (TextView) findViewById(R.id.description);
        TextView historyText = (TextView) findViewById(R.id.history);
        activityText.setText(detail.getDetail().getActivities());
        descriptionText.setText(detail.getDetail().getDescription());
        //historyText.setText(detail.getDetail().getHistory());
    }

    /**
     * Adding fragments to ViewPager
     * @param viewPager
     */
    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Description(), "ONE");
        adapter.addFrag(new History(), "TWO");
        adapter.addFrag(new Activity(), "THREE");
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
