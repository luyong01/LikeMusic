package com.ranze.maincomponent.detailist;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ranze.basiclib.util.schedulers.SchedulerProvider;
import com.ranze.componentservice.app.BaseCommonActivity;
import com.ranze.maincomponent.MainConstants;
import com.ranze.maincomponent.R;
import com.ranze.maincomponent.data.MainRepository;
import com.ranze.maincomponent.router.path.PathConstants;

/**
 * Created by ranze on 2018/2/25.
 */
@Route(path = PathConstants.VIEW_DETAILLIST)
public class DetailListActivity extends BaseCommonActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maincomponent_activity_detaillist);

        DetailListFragment fragment = (DetailListFragment) getSupportFragmentManager().findFragmentById(R.id.frag_container);
        if (fragment == null) {
            int id = getIntent().getIntExtra(MainConstants.PLAY_LIST_ID, -1);
            Bundle bundle = new Bundle();
            bundle.putInt(MainConstants.PLAY_LIST_ID, id);
            fragment = DetailListFragment.newInstance(bundle);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frag_container, fragment).commit();
        }

        new DetailListPresenter(fragment, MainRepository.getInstance(), SchedulerProvider.getInstance());

    }
}
