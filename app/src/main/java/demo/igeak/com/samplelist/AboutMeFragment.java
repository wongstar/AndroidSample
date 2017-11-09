package demo.igeak.com.samplelist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by igeak on 2017/11/9.
 */

public class AboutMeFragment extends Fragment{

    public static AboutMeFragment getInstance(){
        AboutMeFragment fragment = new AboutMeFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_main,null);
        return view;
    }


}
