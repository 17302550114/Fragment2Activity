package com.example.mylistfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BottomFragment extends Fragment {

    private String personName = "Jack";
    private Button mBtnJudge;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public static BottomFragment getInstance(String title) {
        BottomFragment bottomFragment = null;
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bottomFragment.setArguments(bundle);
        return bottomFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.act_fragment_bottom, container, false);
        mBtnJudge = (Button) view.findViewById(R.id.btn_judgement);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //在Fragment中获得他所属的Activity的控件
        final CheckBox chkMarried = (CheckBox) getActivity().findViewById(R.id.chk_married);
        //在Fragment中获得他所属的Activity的成员变量
        final String greeting = ((MainActivity) getActivity()).getGreeting();

        mBtnJudge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chkMarried != null) {
                    if (chkMarried.isChecked())
                        Toast.makeText(getActivity(), greeting + "选中状态", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getActivity(), greeting+"未选中状态", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
