package com.example.test.MeFragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.test.R;
import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class FucSetFragment extends Fragment implements View.OnClickListener {


    private Button bt_exit;

    public FucSetFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fuc_set, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        bt_exit = view.findViewById(R.id.bt_exit);
        bt_exit.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_exit:
                SharedPreferences.Editor editor = getActivity().getSharedPreferences("nongjiyun", MODE_PRIVATE).edit();
                editor.clear();
                editor.apply();
                getActivity().finish();
            break;
        }
    }
}
