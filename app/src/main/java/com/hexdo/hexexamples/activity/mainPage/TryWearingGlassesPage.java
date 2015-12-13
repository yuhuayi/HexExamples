package com.hexdo.hexexamples.activity.mainPage;

import android.view.View;
import com.hexdo.hexexamples.R;
import com.hexdo.hexexamples.activity.base.BaseMainFragment;

/**
 * 试戴
 */
public class TryWearingGlassesPage extends BaseMainFragment {

    @Override protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected void processLogic() {
    }

    @Override protected int getContentViewLayoutID() {
        return R.layout.page_main_try_wearing_glasses;
    }

}
