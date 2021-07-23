package com.example.merchantx.fragments;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.merchantx.R;
import com.example.merchantx.base.BaseFragment;
import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

import static android.content.Context.WINDOW_SERVICE;

public class QRGenerateFragment extends BaseFragment {
    private String qrCode;
    private ImageView ivQr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_q_r_generate, container, false);
        ivQr = view.findViewById(R.id.iv_qr);
        qrGenerator(qrCode);
        return view;
    }

    private void qrGenerator(String qrCode) {

        WindowManager windowManager = (WindowManager) getActivity().getSystemService(WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int weight = point.x;
        int height = point.y;
        int smallerDimension = Math.min(weight, height);
        smallerDimension = smallerDimension * 3 / 4;
        QRGEncoder qrgEncoder = new QRGEncoder(qrCode, null, QRGContents.Type.TEXT, smallerDimension);

        try {
            Bitmap bitmap = qrgEncoder.encodeAsBitmap();
            ivQr.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    public QRGenerateFragment(String qrCode) {
        this.qrCode = qrCode;
    }
}