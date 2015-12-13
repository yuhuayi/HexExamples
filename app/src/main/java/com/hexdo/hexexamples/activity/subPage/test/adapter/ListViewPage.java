package com.hexdo.hexexamples.activity.subPage.test.adapter;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ListView;
import app.newbee.lib.adapter.AdapterItem;
import app.newbee.lib.adapter.abs.CommonAdapter;
import butterknife.Bind;
import com.hexdo.hexexamples.Images;
import com.hexdo.hexexamples.R;
import com.hexdo.hexexamples.activity.base.BaseSubFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的
 */
public class ListViewPage extends BaseSubFragment {
    @Bind(R.id.lv_test) ListView lvTest;

    @Override protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected void processLogic() {
        List<DemoModel> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            DemoModel model = new DemoModel(Images.imageUrls[i], "");
            data.add(model);
        }

        lvTest.setAdapter(new CommonAdapter<DemoModel>(data, 1) {

            @Override
            public Object getItemViewType(DemoModel demoModel) {
                // Log.d(TAG, "getItemViewType = " + demoModel.getDataType());
                return demoModel.getType();
            }

            @NonNull
            @Override
            public AdapterItem<DemoModel> getItemView(Object type) {
                return new ImageItem(mActivity);
            }
        });
    }

    @Override protected int getContentViewLayoutID() {
        return R.layout.page_sub_test_listview;
    }
}

