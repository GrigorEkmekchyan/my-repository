package com.example.merchantx.base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class BaseActivity extends AppCompatActivity {
    public FragmentTransaction addFragment(Fragment fragment, int frameId, FragmentManager myFragmentManager) {
        FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
        fragmentTransaction.add(frameId, fragment).commit();
        return fragmentTransaction;
    }
}
