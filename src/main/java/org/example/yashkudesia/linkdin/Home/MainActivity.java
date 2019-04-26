package org.example.yashkudesia.linkdin.Home;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.nostra13.universalimageloader.core.ImageLoader;

import org.example.yashkudesia.linkdin.R;
import org.example.yashkudesia.linkdin.Utils.BottomNavigationViewHelper;
import org.example.yashkudesia.linkdin.Utils.SectionsPagerAdapter;
import org.example.yashkudesia.linkdin.Utils.UniversalImageLoader;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int ACTIVITY_NUM = 0;
    private Context context = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initImageLoader();
        setupBottomNavigationView();
        setupViewPager();
    }


    private void initImageLoader() {
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(context);
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }


    private void setupViewPager() {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CameraFragment());      //index=0
        adapter.addFragment(new HomeFragment());        //index=1
        adapter.addFragment(new MessagesFragment());    //index=2

        ViewPager viewPager = findViewById(R.id.container);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_logo);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_send);
    }


    //bottom navigation view setup
    private void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView: Setting Navigation View");
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.enableNaviagtion(context, bottomNavigationView);

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setCheckable(true);

    }
}
