package com.hexdo.hexexamples.activity.mainPage;

import android.view.View;
import com.hexdo.hexexamples.R;
import com.hexdo.hexexamples.activity.base.BaseMainFragment;

/**
 * 购物车
 */
public class ShoppingCartPage extends BaseMainFragment {
    @Override protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected void processLogic() {
    }

    @Override protected int getContentViewLayoutID() {
        return R.layout.page_main_shopping_cart;
    }


}
