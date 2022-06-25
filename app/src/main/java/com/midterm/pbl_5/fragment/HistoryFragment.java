package com.midterm.pbl_5.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.midterm.pbl_5.R;

public class HistoryFragment extends Fragment {
    private Button on1,off1,on2,off2,on3,off3,on4,off4,onall,offall;
    private ImageView img1,img2,img3,img4;
    private View mView;
    DatabaseReference mdata;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_history,container,false);
        initUI();
        mdata = FirebaseDatabase.getInstance().getReference();
        mdata.child("Den1").setValue(0);
        mdata.child("Den2").setValue(0);
        mdata.child("Den3").setValue(0);
        mdata.child("Den4").setValue(0);


        initListener();
        return mView;
    }
    private void initUI() {

        on1 = mView.findViewById(R.id.bt11);
        on2 = mView.findViewById(R.id.bt21);
        on3 = mView.findViewById(R.id.bt31);
        on4 = mView.findViewById(R.id.bt41);
        off1 = mView.findViewById(R.id.bt12);
        off2 = mView.findViewById(R.id.bt22);
        off3 = mView.findViewById(R.id.bt32);
        off4 = mView.findViewById(R.id.bt42);
        onall = mView.findViewById(R.id.btall);
        offall = mView.findViewById(R.id.btoff);
        img1 = mView.findViewById(R.id.img1);
        img2 = mView.findViewById(R.id.img2);
        img3 = mView.findViewById(R.id.img3);
        img4 = mView.findViewById(R.id.img4);


    }
    private void initListener() {
        on1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdata.child("Den1").setValue(1);
                img1.setImageResource(R.drawable.densang);
            }
        });
        off1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdata.child("Den1").setValue(0);
                img1.setImageResource(R.drawable.dentat);
            }
        });
        on2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdata.child("Den2").setValue(1);
                img2.setImageResource(R.drawable.densang);

            }
        });
        off2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdata.child("Den2").setValue(0);
                img2.setImageResource(R.drawable.dentat);

            }
        });
        on3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdata.child("Den3").setValue(1);
                img3.setImageResource(R.drawable.densang);

            }
        });
        off3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdata.child("Den3").setValue(0);
                img3.setImageResource(R.drawable.dentat);

            }
        });
        on4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdata.child("Den4").setValue(1);
                img4.setImageResource(R.drawable.densang);

            }
        });
        off4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdata.child("Den4").setValue(0);
                img4.setImageResource(R.drawable.dentat);

            }
        });
        onall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdata.child("Den1").setValue(1);
                mdata.child("Den2").setValue(1);
                mdata.child("Den3").setValue(1);
                mdata.child("Den4").setValue(1);
                img1.setImageResource(R.drawable.densang);
                img2.setImageResource(R.drawable.densang);
                img3.setImageResource(R.drawable.densang);
                img4.setImageResource(R.drawable.densang);
            }
        });
        offall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdata.child("Den1").setValue(0);
                mdata.child("Den2").setValue(0);
                mdata.child("Den3").setValue(0);
                mdata.child("Den4").setValue(0);
                img1.setImageResource(R.drawable.dentat);
                img2.setImageResource(R.drawable.dentat);
                img3.setImageResource(R.drawable.dentat);
                img4.setImageResource(R.drawable.dentat);

            }
        });
    }

}
