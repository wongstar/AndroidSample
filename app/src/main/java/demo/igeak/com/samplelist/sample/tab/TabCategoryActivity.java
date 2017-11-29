package demo.igeak.com.samplelist.sample.tab;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import demo.igeak.com.samplelist.R;

/**
 * Created by igeak on 2017/11/10.
 */

public class TabCategoryActivity extends AppCompatActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_category);
        ButterKnife.bind(this);
        findViewById(R.id.btnTabHost).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("click....");
                Intent intent = new Intent(TabCategoryActivity.this,TabMainActivity.class);
                startActivity(intent);
            }
        });
    }

    @OnClick({R.id.btnTabHost,R.id.btnThird})
    public void click(View view){

        switch (view.getId()){
            case R.id.btnTabHost:
                System.out.println("click....");
                Intent intent = new Intent(TabCategoryActivity.this,TabMainActivity.class);
                startActivity(intent);
                break;
            case R.id.btnThird:
                break;
        }

    }

}
