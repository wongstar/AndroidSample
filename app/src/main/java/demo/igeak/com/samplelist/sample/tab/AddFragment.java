package demo.igeak.com.samplelist.sample.tab;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import demo.igeak.com.samplelist.R;

/**
 * Created by igeak on 2017/11/9.
 */

public class AddFragment extends Fragment{



    public static AddFragment getInstance(){
        AddFragment fragment = new AddFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_add,null);


        return view;
    }
}
