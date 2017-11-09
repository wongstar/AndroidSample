package demo.igeak.com.samplelist.sample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import demo.igeak.com.samplelist.R;


/**
 * Created by igeak on 2017/11/8.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>{


    private final List<ClassItem> mValues;

    public MyRecyclerViewAdapter(List mValues) {
        this.mValues = mValues;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ClassItem item = mValues.get(position);
        System.out.println("the itemName is:"+item.itemName);
        holder.textView.setText(item.itemName);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView;
        public TextView textView;

        public MyViewHolder(View view){
            super(view);
            imageView = (ImageView)view.findViewById(R.id.imageView);
            textView =(TextView)view.findViewById(R.id.textView);
        }
    }
}
