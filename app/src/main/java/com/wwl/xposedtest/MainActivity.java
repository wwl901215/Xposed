package com.wwl.xposedtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.bt_test) Button btTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_test)
    public void onViewClicked() {
        Toast.makeText(MainActivity.this,toastMessage(),Toast.LENGTH_SHORT).show();
    }
    public String toastMessage() {
        return "我未被劫持";
    }
}
