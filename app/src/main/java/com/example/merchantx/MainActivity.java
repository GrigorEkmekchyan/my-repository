package com.example.merchantx;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.merchantx.base.BaseActivity;
import com.example.merchantx.base.Constants;
import com.example.merchantx.base.MyLocale;
import com.example.merchantx.fragments.PaidHistoryFragment;
import com.example.merchantx.fragments.LoginFragment;
import com.example.merchantx.fragments.MainFragment;
import com.example.merchantx.fragments.ReversedHistoryFragment;
import com.example.merchantx.fragments.UnpaidHistoryFragment;
import com.example.merchantx.retrofit.bady.LoginBody;
import com.example.merchantx.retrofit.response.LoginResponse;
import com.example.merchantx.view_models.LoginViewModel;
import com.google.android.material.navigation.NavigationView;

import io.paperdb.Paper;

import static com.example.merchantx.base.Constants.LOGIN;
import static com.example.merchantx.base.Constants.LOGIN_KEY;
import static com.example.merchantx.base.Constants.PASSWORD;
import static com.example.merchantx.base.Constants.PASSWORD_KEY;
import static com.example.merchantx.base.Constants.SHARED_PREFERENCES;
import static com.example.merchantx.base.Constants.SHARED_TOKEN_KEY;
import static com.example.merchantx.base.Constants.USER_ID;
import static com.example.merchantx.base.Constants.USER_ID_KEY;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private SharedPreferences sharedPreferences;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(MyLocale.onAttach(newBase, "en"));
    }

    @SuppressLint("UseSupportActionBar")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = this.getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        Constants.LOGIN = sharedPreferences.getString(LOGIN_KEY, "");
        Constants.PASSWORD = sharedPreferences.getString(PASSWORD_KEY, "");
        USER_ID = sharedPreferences.getString(USER_ID_KEY, "");
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        if (!USER_ID.equals("")) {
            innerLoginCall();
        } else {
            addFragment(new LoginFragment(), R.id.fl_fragment_container, getSupportFragmentManager());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void innerLoginCall() {
        getLoader();
        LoginViewModel loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        LoginBody loginBody = new LoginBody();
        loginBody.setUsername(LOGIN);
        loginBody.setPassword(PASSWORD);
        loginViewModel.searchLogin(loginBody);
        loginViewModel.getLoginResponseMutableLiveData().observe(this, new Observer<LoginResponse>() {
            @Override
            public void onChanged(LoginResponse loginResponse) {
                clearFragmentBackStack();
                Constants.MERCHANT_ID = loginResponse.getMerchants().get(0).getId();
                USER_ID = loginResponse.getMerchantUserId();
                addFragment(new MainFragment(), R.id.fl_fragment_container, getSupportFragmentManager());
                closeLoader();
            }
        });

        loginViewModel.getFailLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                closeLoader();
                Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
            }
        });
        loginViewModel.getErrorLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                closeLoader();
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.nav_merchant:
                if (isLogin()) {
                    clearFragmentBackStack();
                    innerLoginCall();
                }
                break;

            case R.id.nav_paid:
                if (isLogin())
                    changeFragment(R.id.fl_fragment_container, new PaidHistoryFragment());
                break;

            case R.id.nav_unpaid:
                if (isLogin())
                    changeFragment(R.id.fl_fragment_container, new UnpaidHistoryFragment());

                break;

            case R.id.nav_reversed:
                if (isLogin())
                    changeFragment(R.id.fl_fragment_container, new ReversedHistoryFragment());

                break;
            case R.id.nav_armenia:
                getLanguage("am");
                Toast.makeText(this, "Armenia", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_russia:
                getLanguage("ru");
                Toast.makeText(this, "Russia", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_usa:
                getLanguage("en");
                Toast.makeText(this, "Usa", Toast.LENGTH_SHORT).show();
                break;


            case R.id.nav_logout:
                SharedPreferences mySharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
                SharedPreferences.Editor editor = mySharedPreferences.edit();
                editor.remove(SHARED_TOKEN_KEY);
                editor.remove(PASSWORD_KEY);
                editor.remove(LOGIN_KEY);
                editor.remove(SHARED_PREFERENCES);
                editor.remove(USER_ID_KEY);
                editor.apply();
                clearFragmentBackStack();
                changeFragmentNotAddBackStack(R.id.fl_fragment_container, new LoginFragment());
                break;
        }
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private boolean isLogin() {
        if (!USER_ID.equals("")) {
            return true;
        } else {
            Toast.makeText(this, R.string.pleas_login, Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}