package demo.igeak.com.samplelist.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import demo.igeak.com.samplelist.R;

/**
 * Created by igeak on 2017/11/8.
 */

public class RecyclerViewDivider extends RecyclerView.ItemDecoration{

   private  Context context;
   private int dividerHeight;
   private Paint dividerPaint;



   public RecyclerViewDivider(Context context){
       this.context = context;
       dividerHeight = context.getResources().getDimensionPixelSize(R.dimen.divider_height);
       dividerPaint = new Paint();
       dividerPaint.setColor(context.getResources().getColor(R.color.colorDivider));
   }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int childCount = parent.getChildCount();
        int left = parent.getPaddingLeft();
        int right = parent.getWidth()-parent.getPaddingRight();

        for(int i=0;i<childCount;i++){
            View  view = parent.getChildAt(i);
            float top = view.getBottom();
            float bottom = view.getBottom()+dividerHeight;
            c.drawRect(left,top,right,bottom,dividerPaint);
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = dividerHeight;
    }
}
