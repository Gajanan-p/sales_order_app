package com.ssinfomate.salesorder;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ssinfomate.salesorder.scaner.barcodereader.BarcodeCaptureActivity;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.gms.vision.barcode.Barcode;
import com.ssinfomate.salesorder.ui.filters.DesignWiseFilterFragment;
import com.ssinfomate.salesorder.utils.AppPreference;
import com.ssinfomate.salesorder.weservices.userloginmodel.UserModel;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    UserModel userModel;
    NavController navController;
    NavigationView navigationView;
    EditText barcodeImageViewFromFragment;
    DrawerLayout drawer;
    private BottomNavigationView bottomNavView;
    private static final int RC_BARCODE_CAPTURE = 9001;
    private static final String TAG = "BarcodeMain";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        bottomNavView = findViewById(R.id.bottom_nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,
                R.id.nav_login,
                R.id.bottom_nav_pendingOrder,
                R.id.nav_dynamicServerUrl,
                R.id.bottom_nav_groupOrder,
                R.id.bottom_nav_catalog,
                R.id.nav_logOut)
                .setOpenableLayout(drawer)
                .build();

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        NavigationUI.setupWithNavController(bottomNavView, navController);

    }

    @Override
    protected void onResume() {
        super.onResume();
        //checkForLogin();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_menu_filter) {
            // Create or show the fragment when the menu item is clicked
            Fragment myFragment = new DesignWiseFilterFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container_view_tag, myFragment);
            transaction.addToBackStack(null); // Optional, adds to the back stack
            transaction.commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    void checkForLogin(){
        userModel= AppPreference.getLoginDataPreferences(getApplicationContext());
        if(userModel!=null){
            if (userModel.getIsLogin()!=null) {
                showMenuItem();
            }
            else {
                navController.navigate(R.id.nav_login);
                hideMenuItem();
            }
        }else{
            navController.navigate(R.id.nav_login);
            hideMenuItem();
        }
    }


    private void hideMenuItem() {
        Menu nav_Menu = bottomNavView.getMenu();
        nav_Menu.findItem(R.id.bottom_nav_catalog).setVisible(false);
        nav_Menu.findItem(R.id.bottom_nav_groupOrder).setVisible(false);
        nav_Menu.findItem(R.id.bottom_nav_pendingOrder).setVisible(false);
        nav_Menu.findItem(R.id.nav_home).setVisible(false);

    }

    void showMenuItem(){
        Menu nav_Menu = bottomNavView.getMenu();
        nav_Menu.findItem(R.id.bottom_nav_catalog).setVisible(true);
        nav_Menu.findItem(R.id.bottom_nav_groupOrder).setVisible(true);
        nav_Menu.findItem(R.id.bottom_nav_pendingOrder).setVisible(true);
        nav_Menu.findItem(R.id.nav_home).setVisible(true);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }


//-----TODO Barcode Reader Part----------------------------------------------------------------------
    public  void startScanActivity(EditText editText){
        barcodeImageViewFromFragment=editText;
        Log.i("Message123","Message123");
       // editText.setText("Message123");
//        startActivity(new Intent(this,CameraScannerActivity.class));
        Intent intent = new Intent(this, BarcodeCaptureActivity.class);
        intent.putExtra(BarcodeCaptureActivity.AutoFocus, true);
        intent.putExtra(BarcodeCaptureActivity.UseFlash,true);

        startActivityForResult(intent, RC_BARCODE_CAPTURE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RC_BARCODE_CAPTURE) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    Barcode barcode = data.getParcelableExtra(BarcodeCaptureActivity.BarcodeObject);
//                    statusMessage.setText(R.string.barcode_success);
                    if(barcodeImageViewFromFragment!=null){
                        barcodeImageViewFromFragment.setText(barcode.displayValue);}
                    Log.d(TAG, "Barcode read: " + barcode.displayValue);
                } else {
//                    statusMessage.setText(R.string.barcode_failure);
                    Log.d(TAG, "No barcode captured, intent data is null");
                }
            } else {
//                statusMessage.setText(String.format(getString(R.string.barcode_error),
//                        CommonStatusCodes.getStatusCodeString(resultCode)));
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
//---------------------------------------------------------------------------------------------------


}