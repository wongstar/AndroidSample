package demo.igeak.com.samplelist.lifecycle;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.igeak.com.http.model.User;
import demo.igeak.com.samplelist.R;


/**
 * Created by igeak on 2017/11/29.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{

    private List<User> users;
    private UserClickCallBack userClickCallBack;
    private Context context;

    public UserAdapter(List<User> users, UserClickCallBack userClickCallBack) {
        this.users = users;
        this.userClickCallBack = userClickCallBack;
    }

    public void setUsers(List<User> u) {
        int count = getItemCount();
        users.addAll(u);
        notifyItemRangeInserted(count, u.size());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        context = parent.getContext();

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final User user = users.get(position);
        holder.userName.setText(user.getName());
        holder.userId.setText(String.valueOf(user.getUserId()));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userClickCallBack.onItemClick(user);
            }
        });
        if (!TextUtils.isEmpty(user.getProfileImage())) {
            Glide.with(context).load(user.getProfileImage()).into(holder.avatarImage);
        }
    }

    @Override
    public int getItemCount() {
        return users == null ? 0 : users.size();
    }

    static class  ViewHolder extends RecyclerView.ViewHolder{


        @BindView(R.id.avatar_image)
        ImageView avatarImage;

        @BindView(R.id.user_name)
        TextView userName;

        @BindView(R.id.user_id)
        TextView userId;

        @BindView(R.id.user_item_container)
        CardView cardView;

        public ViewHolder(View view){
            super(view);
            ButterKnife.bind(view);

        }
    }
}
