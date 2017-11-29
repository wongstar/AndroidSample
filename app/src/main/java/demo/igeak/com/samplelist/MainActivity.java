package demo.igeak.com.samplelist;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import demo.igeak.com.samplelist.sample.recycler.ClassItem;
import demo.igeak.com.samplelist.sample.recycler.RecyclerFragment;
import demo.igeak.com.samplelist.sample.tab.AboutMeFragment;
import demo.igeak.com.samplelist.sample.tab.AddFragment;
import demo.igeak.com.samplelist.sample.tab.TabCategoryActivity;
import demo.igeak.com.samplelist.sample.tab.TabFragmentPageAdapter;


public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,ViewPager.OnPageChangeListener{


    private ViewPager vpView;
    private RadioGroup radioGroup;
    private RadioButton radioButtonMe;
    private RadioButton radioButtonSample;
    private RadioButton radioButtonAdd;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vpView = findViewById(R.id.vpView);
        radioGroup = findViewById(R.id.rg_tab_bar);
        radioButtonSample = findViewById(R.id.rbSample);
        radioButtonAdd = findViewById(R.id.rbAdd);
        radioButtonMe = findViewById(R.id.rbMe);
        radioButtonSample.setChecked(true);
        vpView.setAdapter(new TabFragmentPageAdapter(getSupportFragmentManager(),getFragments()));
        vpView.setCurrentItem(0);

        vpView.setOnPageChangeListener(this);

        radioGroup.setOnCheckedChangeListener(this);

    }



    public List getFragments() {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(MainActivity.this, TabCategoryActivity.class);
        ClassItem itemA = new ClassItem(getString(R.string.tab_sample),intent);
        ClassItem itemB = new ClassItem(getString(R.string.tab_sample),intent);
        ArrayList<ClassItem> items = new ArrayList<>();
        items.add(itemA);
        items.add(itemB);
        bundle.putParcelableArrayList("list",items);
        RecyclerFragment fragment =  RecyclerFragment.newInstance(bundle);
        List list = new ArrayList();
        list.add(fragment);
        list.add(AddFragment.getInstance());
        list.add(AboutMeFragment.getInstance());


        return list;
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.rbSample:
                vpView.setCurrentItem(PAGE_ONE);
                break;
            case R.id.rbAdd:
                vpView.setCurrentItem(PAGE_TWO);
                break;
            case R.id.rbMe:
                vpView.setCurrentItem(PAGE_FOUR);
                break;
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (state ==2) {
            switch (vpView.getCurrentItem()){
                case PAGE_ONE:
                    radioButtonSample.setChecked(true);
                    break;
                case PAGE_TWO:
                    radioButtonAdd.setChecked(true);
                    break;
                case PAGE_THREE:
                    radioButtonMe.setChecked(true);
                    break;
            }
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }
}
