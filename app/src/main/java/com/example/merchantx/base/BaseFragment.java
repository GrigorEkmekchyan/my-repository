package com.example.merchantx.base;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class BaseFragment extends Fragment {

    public FragmentTransaction addFragment(Fragment fragment, int frameId, FragmentManager myFragmentManager) {
        FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
        fragmentTransaction.add(frameId, fragment).commit();
        return fragmentTransaction;
    }

    public void changeFragment(int id, Fragment fragment) {
        requireActivity().getSupportFragmentManager().beginTransaction().replace(id, fragment).addToBackStack(fragment.getClass().getSimpleName()).commit();
    }

    public void changeFragmentNotAddBackStack(int id, Fragment fragment) {
        requireActivity().getSupportFragmentManager().beginTransaction().replace(id, fragment).commit();
    }


    public void clearFragmentBackStack() {
        FragmentManager fm = requireActivity().getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.getFragments().clear();
            fm.popBackStack();

            FragmentManager manager = getActivity().getSupportFragmentManager();
            FragmentTransaction trans = manager.beginTransaction();
            trans.commit();
            manager.popBackStack();
        }
    }
}
