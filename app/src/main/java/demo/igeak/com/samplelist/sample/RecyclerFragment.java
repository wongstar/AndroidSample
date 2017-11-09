package demo.igeak.com.samplelist.sample;


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

public class RecyclerFragment extends Fragment {

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
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, null);

        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));

        recyclerView.setAdapter(new MyRecyclerViewAdapter(items));
        recyclerView.addItemDecoration(new RecyclerViewDivider(getActivity()));
        return recyclerView;
    }
}
