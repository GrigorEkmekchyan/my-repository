package com.example.merchantx.base;

import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.leo.simplearcloader.ArcConfiguration;
import com.leo.simplearcloader.SimpleArcDialog;
import com.leo.simplearcloader.SimpleArcLoader;

import io.paperdb.Paper;

public class BaseActivity extends AppCompatActivity {
    private SimpleArcDialog mDialog;
    public FragmentTransaction addFragment(Fragment fragment, int frameId, FragmentManager myFragmentManager) {
        FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
        fragmentTransaction.add(frameId, fragment).commit();
        return fragmentTransaction;
    }

    public void getLanguage(String lang) {
        Paper.init(this);
        String language = Paper.book().read("language");
        if (language == null) {
            Paper.book().write("language", lang);
            updateView(Paper.book().read("language"));
        }
    }
    protected void updateView(String language) {
        MyLocale.setLocale(this, language);
    }



    public void changeFragment(int id, Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(id, fragment).addToBackStack(fragment.getClass().getSimpleName()).commit();
    }

    public void changeFragmentNotAddBackStack(int id, Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(id, fragment).commit();
    }
    public void clearFragmentBackStack() {
        FragmentManager fm = getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.getFragments().clear();
            fm.popBackStack();

            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction trans = manager.beginTransaction();
            trans.commit();
            manager.popBackStack();
        }
    }
    public SimpleArcDialog getLoader() {

        mDialog = new SimpleArcDialog(this);
        ArcConfiguration arcConfiguration = new ArcConfiguration(this);
        arcConfiguration.setText("wait");
        mDialog.setCancelable(false);
        arcConfiguration.setLoaderStyle(SimpleArcLoader.STYLE.SIMPLE_ARC);
        mDialog.setConfiguration(arcConfiguration);
        mDialog.show();
        return mDialog;
    }

    public void closeLoader(Button btn) {
        btn.setEnabled(true);
        if (mDialog != null)
            mDialog.cancel();
    }

    public void closeLoader() {
        if (mDialog != null)
            mDialog.cancel();
    }
}
