package org.example.yashkudesia.linkdin.Profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;

import org.example.yashkudesia.linkdin.R;

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "ProfileActivity";
    private static final int ACTIVITY_NUM = 4;
    private static final int NUM_GRID_COLUMNS = 3;
    private Context context = ProfileActivity.this;
    private ImageView profilePhoto;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: started profile activity");

//        setupBottomNavigationView();
//        setupToolbar();
//        setupActivityWidgets();
//        setProfileImage();
//        tempGridSetup();
        init();
    }

    private void init() {
        Log.d(TAG, "init: inflating" + getString(R.string.profile_fragment));
        ProfileFragment fragment = new ProfileFragment();
        FragmentTransaction transaction = ProfileActivity.this.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(getString(R.string.profile_fragment));
        transaction.commit();
    }
//    private void tempGridSetup(){
//        ArrayList<String> imgURLs = new ArrayList<>();
//        imgURLs.add("https://pbs.twimg.com/profile_images/616076655547682816/6gMRtQyY.jpg");
//        imgURLs.add("https://i.redd.it/9bf67ygj710z.jpg");
//        imgURLs.add("https://c1.staticflickr.com/5/4276/34102458063_7be616b993_o.jpg");
//        imgURLs.add("http://i.imgur.com/EwZRpvQ.jpg");
//        imgURLs.add("http://i.imgur.com/JTb2pXP.jpg");
//        imgURLs.add("https://i.redd.it/59kjlxxf720z.jpg");
//        imgURLs.add("https://i.redd.it/pwduhknig00z.jpg");
//        imgURLs.add("https://i.redd.it/clusqsm4oxzy.jpg");
//        imgURLs.add("https://i.redd.it/svqvn7xs420z.jpg");
//        imgURLs.add("http://i.imgur.com/j4AfH6P.jpg");
//        imgURLs.add("https://i.redd.it/89cjkojkl10z.jpg");
//        imgURLs.add("https://i.redd.it/aw7pv8jq4zzy.jpg");
//
//        setupImageGrid(imgURLs);
//    }
//
//    private void setupImageGrid(ArrayList<String> imgURLs )
//    {
//        GridView gridView=(GridView)findViewById(R.id.gridView);
//
//        int gridWidth = getResources().getDisplayMetrics().widthPixels;
//        int imageWidth = gridWidth/NUM_GRID_COLUMNS;
//        gridView.setColumnWidth(imageWidth);
//
//        GridImageAdapter adapter = new GridImageAdapter(context, R.layout.layout_grid_image_view, "", imgURLs);
//        gridView.setAdapter(adapter);
//
//    }
//    private void setProfileImage()
//    {
//        Log.d(TAG, "setProfileImage: seting profile image");
//        String imgURL = "www.androidcentral.com/sites/androidcentral.com/files/styles/xlarge/public/article_images/2016/08/ac-lloyd.jpg?itok=bb72IeLf";
//        UniversalImageLoader.setImage(imgURL,profilePhoto,progressBar,"https://");
//    }
//
//    private void setupActivityWidgets()
//    {
//        progressBar=(ProgressBar)findViewById(R.id.profile_progress_bar);
//        progressBar.setVisibility(View.GONE);
//        profilePhoto=(ImageView)findViewById(R.id.profile_photo);
//    }
//
//    private void setupToolbar(){
//        Toolbar toolbar =(Toolbar) findViewById(R.id.profileToolBar);
//        setSupportActionBar(toolbar);
//        ImageView profilemenu=(ImageView) findViewById(R.id.profileMenu);
//
//        profilemenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "onClick: Navigating to account settings");
//                Intent intent=new Intent(context,AccountSettingsActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
//
//    private void setupBottomNavigationView()
//    {
//        Log.d(TAG, "setupBottomNavigationView: Setting Navigation View");
//        BottomNavigationView bottomNavigationView=(BottomNavigationView) findViewById(R.id.bottomNavViewBar);
//        BottomNavigationViewHelper.enableNaviagtion(context,bottomNavigationView);
//
//        Menu menu=bottomNavigationView.getMenu();
//        MenuItem menuItem=menu.getItem(ACTIVITY_NUM);
//        menuItem.setCheckable(true);
//
//    }

}
