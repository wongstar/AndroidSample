package demo.igeak.com.samplelist.sample.tab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by igeak on 2017/11/9.
 */

public class TabFragmentPageAdapter extends FragmentPagerAdapter{

    public List<Fragment> fragments;

    public TabFragmentPageAdapter(FragmentManager fm,List<Fragment> fragments){
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        if (fragments==null|| fragments.size() ==0){
            return  null;
        }
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        if(fragments==null) {
            return 0;
        }
        return fragments.size();
    }



}
