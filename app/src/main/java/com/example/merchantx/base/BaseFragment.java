package com.example.merchantx.base;

import android.view.Menu;
import android.widget.Button;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.leo.simplearcloader.ArcConfiguration;
import com.leo.simplearcloader.SimpleArcDialog;
import com.leo.simplearcloader.SimpleArcLoader;

public abstract class BaseFragment extends Fragment {
    private SimpleArcDialog mDialog;

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


    public SimpleArcDialog getLoader() {

        mDialog = new SimpleArcDialog(getContext());
        ArcConfiguration arcConfiguration = new ArcConfiguration(requireActivity());
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

    public void closeLoader(CardView cardView) {
        cardView.setEnabled(true);
        if (mDialog != null)
            mDialog.cancel();
    }

    public void closeLoader() {
        if (mDialog != null)
            mDialog.cancel();
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
