package demo.igeak.com.samplelist.lifecycle;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.igeak.com.http.model.User;
import demo.igeak.com.samplelist.R;

/**
 * Created by igeak on 2017/11/28.
 */

public class UserListFragment extends Fragment {

    @BindView(R.id.user_list)
    RecyclerView recyclerView;

    @BindView(R.id.isLoadingUser)
    TextView loadingMessage;

    private List<User> users = new ArrayList<>();

    private  UserAdapter userAdapter;

    private ShareViewModel sharedViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        View view= inflater.inflate(R.layout.fragment_user_list,container,false);

        ButterKnife.bind(getActivity());

        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);


        userAdapter = new UserAdapter(users,callBack);

        recyclerView.setAdapter(userAdapter);

        return view;
    }

    private  UserClickCallBack callBack = new UserClickCallBack() {
        @Override
        public void onItemClick(User user) {
            sharedViewModel.selected(user);
        }
    };


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        UsersViewModel usersViewModel = ViewModelProviders.of(this).get(UsersViewModel.class);
        sharedViewModel = ViewModelProviders.of(this).get(ShareViewModel.class);
        usersViewModel.init();
        suscribeUi(usersViewModel);

    }

    private  void suscribeUi(UsersViewModel model) {
        model.getUsrs().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                userAdapter.setUsers(users);
                recyclerView.setVisibility(View.VISIBLE);
                loadingMessage.setVisibility(View.INVISIBLE);
            }
        });
    }
}
