package demo.igeak.com.samplelist.sample.recycler;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import demo.igeak.com.samplelist.R;

/**
 * Created by igeak on 2017/11/8.
 */

public class RecyclerFragment extends Fragment implements MyRecyclerViewAdapter.IListener{

    public List<ClassItem> items;


    public static RecyclerFragment newInstance(Bundle bundle) {
        System.out.println("newInstance");
        RecyclerFragment fragment = new RecyclerFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("onCreate call in Fragment..1    ");
        if (getArguments() != null) {
            System.out.println("bundle not null..");
            items = getArguments().getParcelableArrayList("list");
            System.out.println("the count is:" + items.size());
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, container,false);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new MyRecyclerViewAdapter(items,this));
        recyclerView.addItemDecoration(new RecyclerViewDivider(getActivity()));
        return recyclerView;
    }

    @Override
    public void OnItemClick(View view, int position) {
        System.out.println("view click..position is:"+position);
        ClassItem item = items.get(position);
        //item.className
        try {

           if (item != null && item.getIntent()!=null){
                startActivity(item.getIntent());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
