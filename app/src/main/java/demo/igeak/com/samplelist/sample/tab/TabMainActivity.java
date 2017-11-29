package demo.igeak.com.samplelist.sample.tab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.RandomAccessFile;

import demo.igeak.com.samplelist.R;

/**
 * Created by igeak on 2017/11/13.
 */

public class TabMainActivity extends FragmentActivity{
    private FragmentTabHost fragmentTabHost;

    private Class fragments[] = {AboutMeFragment.class,AddFragment.class};
    private int images[] = {R.drawable.tab_menu_setting,R.drawable.tab_menu_message};
    private int mTexts[] = {R.string.tab_add,R.string.tab_me};
    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabhost_main);
        layoutInflater = LayoutInflater.from(this);
        fragmentTabHost = findViewById(android.R.id.tabhost);
        fragmentTabHost.setup(this,getSupportFragmentManager(),R.id.container);
        int count = fragments.length;
        for (int i =0; i<count; i++) {
            TabHost.TabSpec tabSpec = fragmentTabHost.newTabSpec(getString(mTexts[i])).setIndicator(getTabItemView(i));
            fragmentTabHost.addTab(tabSpec,fragments[i],null);
            fragmentTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.tab_menu_bg);
        }

    }

    /**
     * 给Tab按钮设置图标和文字
     */
    private View getTabItemView(int index){
        View view = layoutInflater.inflate(R.layout.tab_item, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(images[index]);

        TextView textView = (TextView) view.findViewById(R.id.textview);
        String text=getString(mTexts[index]);
        System.out.printf("the text is :\t"+text);
        textView.setText(text);

        return view;
    }
}
