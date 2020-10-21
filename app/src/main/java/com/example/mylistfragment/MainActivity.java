package com.example.mylistfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox mChkMarried;
    private BottomFragment fragment1;
    TextView texResult;

    private String greeting = "Hello";

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1 = new BottomFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment1).commit();

        mChkMarried = (CheckBox) findViewById(R.id.chk_married);

        mChkMarried.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            //getSupportFragmentManager().findFragmentById(R.id.fragment_bottom);
            //在Activity中获取所属的fragment，使用XML标签来获取得
            //BottomFragment fragment = (BottomFragment)getSupportFragmentManager().findFragmentByTag("fragment_bottom_tag");
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String personName = "";
                personName = fragment1.getPersonName();
                if (isChecked) {
                    texResult = (TextView) fragment1.getView().findViewById(R.id.txt_result);

                    if (fragment1 != null) {
                        //获取UI控件
                        texResult.setText(personName + "已婚");
                    }
                }else {
                    texResult.setText(personName + "未婚");
                }
            }
        });
    }
}