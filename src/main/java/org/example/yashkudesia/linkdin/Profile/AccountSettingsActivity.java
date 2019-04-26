package org.example.yashkudesia.linkdin.Profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import org.example.yashkudesia.linkdin.R;
import org.example.yashkudesia.linkdin.Utils.SectionsStatePagerAdapter;

import java.util.ArrayList;

public class AccountSettingsActivity extends AppCompatActivity {
    private static final String TAG = "AccountSettingsActivity";
    private Context context;
    private SectionsStatePagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountsettings);

        viewPager = findViewById(R.id.container);
        relativeLayout = findViewById(R.id.relLayout1);
        context = AccountSettingsActivity.this;
        Log.d(TAG, "onCreate: started account settings");
        setupSettingsList();
        setupFragments();

        //setting up the back arrow to navigating back to profile activity
        ImageView backArrow = findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: navigating back to profile activity");
                finish();
            }
        });

    }

    private void setupFragments() {
        pagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new EditProfileFragment(), getString(R.string.edit_profile));
        pagerAdapter.addFragment(new SignOutFragment(), getString(R.string.sign_out));
    }

    private void setViewPager(int fragmentNumber) {
        relativeLayout.setVisibility(View.GONE);
        Log.d(TAG, "setViewPager: navigating to fragment #: " + fragmentNumber);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(fragmentNumber);
    }

    private void setupSettingsList() {
        Log.d(TAG, "setupSettingsList: initiliasing the Account Setting list");
        ListView listView = findViewById(R.id.lvAccountSettings);
        ArrayList options = new ArrayList();
        options.add(getString(R.string.edit_profile));
        options.add(getString(R.string.sign_out));

        ArrayAdapter adapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, options);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "setViewPager: navigating to fragment #: " + position);
                setViewPager(position);
            }
        });
    }
}
