package com.hexdo.hexexamples.activity.subPage.test.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import app.newbee.lib.adapter.AdapterItem;
import app.newbee.lib.adapter.recycler.CommonRcvAdapter;
import butterknife.Bind;
import com.hexdo.hexexamples.Images;
import com.hexdo.hexexamples.R;
import com.hexdo.hexexamples.activity.base.BaseSubFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的
 */
public class RefreshViewPage extends BaseSubFragment {

    @Bind(R.id.rv_test) RecyclerView rvTest;

    @Override protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected void processLogic() {
        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvTest.setLayoutManager(layoutManager);
        rvTest.setLayoutManager(layoutManager);
        List<DemoModel> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            DemoModel model = new DemoModel(Images.imageUrls[i], "");
            data.add(model);
        }
        rvTest.setAdapter(new CommonRcvAdapter<DemoModel>(data) {

            @Override
            public Object getItemViewType(DemoModel item) {
                return item.getType();
            }

            @NonNull
            @Override
            public AdapterItem<DemoModel> getItemView(Object type) {
                return new ImageItem(mActivity);
            }
        });
    }

    @Override protected int getContentViewLayoutID() {
        return R.layout.page_sub_test_refesh_view;
    }
}
