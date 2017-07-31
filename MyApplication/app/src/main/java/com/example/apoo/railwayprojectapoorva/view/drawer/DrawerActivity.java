package com.example.apoo.railwayprojectapoorva.view.drawer;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.apoo.railwayprojectapoorva.R;
import com.example.apoo.railwayprojectapoorva.adapter.drawer.GridViewAdapter;
import com.example.apoo.railwayprojectapoorva.adapter.drawer.DrawerAdapter;
import com.example.apoo.railwayprojectapoorva.entities.drawer.DataModel;
import com.example.apoo.railwayprojectapoorva.view.canceltrain.CancelTrainEnqAct;
import com.example.apoo.railwayprojectapoorva.view.livetrainstatus.LiveTraiEnqActivity;
import com.example.apoo.railwayprojectapoorva.view.trainarrivalsatsta.TrainArrivalAtStationEnquiryActivity;
import com.example.apoo.railwayprojectapoorva.view.trainbetweensta.TrainbtwnEnqAct;
import com.example.apoo.railwayprojectapoorva.view.trainfare.TrainFareEnquiAct;
import com.example.apoo.railwayprojectapoorva.view.root.TrainRootEnqActivity;
import com.example.apoo.railwayprojectapoorva.view.trainnmnumbr.TraiNmEnquiAct;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;

import java.util.HashMap;

public class DrawerActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private String[] mDrawerItemTitles;
    private ListView mDrawerList;
    Toolbar toolbar;
    private CharSequence charSequenceDrawertitles;
    private CharSequence mTitle;
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mDrawerToggle;
    GridView gridView;
    private SliderLayout mDemoSlider;
    private BottomBar bottombar;
    RecyclerView recyclerview_menu_list;

    public static String[] gridViewStrings = {
            "Train Between Station",
            "Train Arrival" ,
            "Train Fare",
            "Train Runnig Day",
            "Helpline",
           /* "About us",
            "HelpLine",
            "AboutUs"*/
    };


    public static int[] gridViewImages = {
            R.mipmap.ic_train_between_stations,
            R.mipmap.ic_train_arrival,
            R.mipmap.ic_train_fare,
            R.mipmap.ic_train_running_day,
            R.mipmap.ic_train_help,
           /* R.mipmap.ic_train_help_icon,
            R.mipmap.ic_train_about_us_icon,*/
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        mTitle = charSequenceDrawertitles = getTitle();
        mDrawerItemTitles = getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDemoSlider = (SliderLayout)findViewById(R.id.slider);
        bottombar = (BottomBar) findViewById(R.id.bottomBar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerId);
        recyclerview_menu_list = (RecyclerView) findViewById(R.id.menu_list);

        DataModel[] drawerItem = new DataModel[4];
        drawerItem[0] = new DataModel(R.drawable.ic_face_profile, "Profile");
        drawerItem[1] = new DataModel(R.drawable.ic_rescheduled, "Rescheduled Train");
        drawerItem[2] = new DataModel(R.drawable.ic_info, "Info");
        drawerItem[3] = new DataModel(R.drawable.ic_about_us, "About Us");

       /* setUpMenu();*/

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        DrawerAdapter menuAdapter = new DrawerAdapter(this,drawerItem);
        recyclerview_menu_list.setAdapter(menuAdapter);
        recyclerview_menu_list.setLayoutManager(linearLayoutManager);

        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");


        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Hassel free train Enquiry",R.drawable.collage1);
        file_maps.put("Search for seat availability",R.drawable.collage2);
        file_maps.put("Find train between stations",R.drawable.collage3);
        file_maps.put("Find train's live status", R.drawable.collage4);


        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }



        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator));
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);
        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new GridViewAdapter(this, gridViewStrings,gridViewImages));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        Intent intent2 = new Intent(getApplicationContext(), TrainbtwnEnqAct.class);
                         startActivity(intent2);
                        break;

                    case 1:
                        Intent intent = new Intent(getApplicationContext(), TrainArrivalAtStationEnquiryActivity.class);
                        startActivity(intent);
                        break;

                    case 2:
                        Intent intent1 = new Intent(getApplicationContext(), TrainFareEnquiAct.class);
                        startActivity(intent1);
                        break;

                    case 3:
                        Intent intent3 = new Intent(getApplicationContext(), TraiNmEnquiAct.class);
                        startActivity(intent3);
                        break;

                    case 4:
                        AlertDialog.Builder builder = new AlertDialog.Builder(DrawerActivity.this);
                        LayoutInflater inflater = DrawerActivity.this.getLayoutInflater();
                        builder.setView(inflater.inflate(R.layout.custom_helpline, null))
                                .setTitle("HelpLine")
                                .setNegativeButton(R.string.exit, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.dismiss();
                                    }
                                });
                        builder.show();

                        break;

                   /* case 5:
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(DrawerActivity.this);
                        LayoutInflater inflater1 = DrawerActivity.this.getLayoutInflater();
                        builder1.setView(inflater1.inflate(R.layout.custom_aboutus, null))
                                .setTitle("HelpLine")
                                .setNegativeButton(R.string.exit, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.dismiss();
                                    }
                                });
                        builder1.show();
                        break;*/
                }
            }
        });

       /* bottombar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {

            }
        });*/



        bottombar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_root) {
                    Intent intent = new Intent(DrawerActivity.this,TrainRootEnqActivity.class);
                    startActivity(intent);
                }

                if (tabId == R.id.tab_pnr) {

                    Intent intent = new Intent(DrawerActivity.this,LiveTraiEnqActivity.class);
                    startActivity(intent);
                }


                if (tabId == R.id.tab_seat) {

                    Intent intent = new Intent(DrawerActivity.this,CancelTrainEnqAct.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
       // Toast.makeText(this,"---",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPageSelected(int position) {

        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_custom_indicator:
                mDemoSlider.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator));
                break;
            case R.id.action_custom_child_animation:
                //    mDemoSlider.setCustomAnimation(new ChildAnimationExample());
                break;
            case R.id.action_restore_default:
                mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
                mDemoSlider.setCustomAnimation(new DescriptionAnimation());
                break;
            case R.id.action_github:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/daimajia/AndroidImageSlider"));
                startActivity(browserIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setUpMenu() {

       }

}
//--------------------------------------------                        ----------------------------------------------
        //TODO: called the methods of setting the toolbar
       /* setToolbar();
*/
        //TODO: filling the datamodel through the drawer data

       /* DataModel[] drawerItem = new DataModel[3];
        drawerItem[0] = new DataModel(R.drawable.ic_alarm_on,"Connect");
        drawerItem[1] = new DataModel(R.drawable.ic_android_black_24dp,"Fixture");
        drawerItem[2] = new DataModel(R.drawable.bg,"Table");
*/
        /*getSupportActionBar().setDisplayHomeAsUpEnabled(false);*/
        /*getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

/*

        int width = getResources().getDisplayMetrics().widthPixels/2;
        DrawerLayout.LayoutParams params = (android.support.v4.widget.DrawerLayout.LayoutParams) mDrawerList.getLayoutParams();
        params.width = width;
        mDrawerList.setLayoutParams(params);

        drawerItemCustmAdap adapter = new drawerItemCustmAdap(this,
                R.layout.list_row_item_layout,drawerItem);
        mDrawerList.setAdapter(adapter);
*/

        //TODO: inner class for setting the drawer
        //TODO: called the DrawerLayout class's setDrawer method here
/*
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setupDrawerToggle();*/





    /*
    * @class - a class for the the list view item click listener
    * this class is inner class here
    * */


   /* private class DrawerItemClickListener implements ListView.OnItemClickListener {


        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

            selectItem(position);
        }
    }
*/
    /*
    * @method to select item
    * */

  /*  private void selectItem (int position) {
*//*

        Fragment fragment = null;

        switch (position)
        {

            case 0:
               // fragment = new Fragment1();
                break;
            case 1 :
                fragment = new Fragment2();
                break;

            default:
                break;
        }
*//*

     *//* if (fragment != null) {
          FragmentManager fragmentManager  = getSupportFragmentManager();
          fragmentManager.beginTransaction().replace(R.id.content_frame,fragment).commit();

          mDrawerList.setSelection(position);
          setTitle(mDrawerItemTitles[position]);
          mDrawerLayout.closeDrawer(mDrawerList);

      } else {

          Log.d("", "selectItem: ");
      }
*//*
    }

 */   /*
    * menu options selected
    * */

  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    /*
    * @method - overided
    * */

    /*public void setmTitle(CharSequence mTitle) {
        this.mTitle = mTitle;
        getSupportActionBar().setTitle(mTitle);
    }
*/
   /* @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }*/
/*
    void setToolbar () {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }*/

/*    void setupDrawerToggle () {

        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, toolbar,R.string.app_name,
                R.string.app_name);
        //TODO: This is necessary to change the icon of the drawer toggle upon state change

        mDrawerToggle.syncState();

    }*/
