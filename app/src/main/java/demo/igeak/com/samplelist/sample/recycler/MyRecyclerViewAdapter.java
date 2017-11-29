package demo.igeak.com.samplelist.sample.recycler;

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

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {


    private final List<ClassItem> mValues;
    private IListener mListener;

    public MyRecyclerViewAdapter(List mValues,IListener mListener) {
        this.mValues = mValues;
        this.mListener = mListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        myViewHolder.setiListener(mListener);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ClassItem item = mValues.get(position);
        System.out.println("the itemName is:" + item.itemName);
        holder.textView.setText(item.itemName);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView imageView;
        public TextView textView;
        private IListener iListener;

        public MyViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.imageView);
            textView = (TextView) view.findViewById(R.id.textView);
            view.setOnClickListener(this);
        }

        public IListener getiListener() {
            return iListener;
        }

        public void setiListener(IListener iListener) {
            this.iListener = iListener;
        }

        @Override
        public void onClick(View v) {
            if (iListener !=null) {
                iListener.OnItemClick(v, getPosition());
            }
        }
    }

    public interface IListener{
        public void OnItemClick(View view,int position);
    }


}
