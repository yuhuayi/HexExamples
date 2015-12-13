package com.hexdo.hexexamples.activity.subPage.test.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import app.newbee.lib.adapter.AdapterItem;
import com.hexdo.hexexamples.R;
import com.squareup.picasso.Picasso;


/**
 * @author Jack Tony
 */
public class ImageItem implements AdapterItem<DemoModel> {

    private String mOldImageUrl;
    private ImageView imageView;
    private Activity mActivity;

    public ImageItem(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.demo_item_image;
    }


    @Override
    public void onBindViews(View root) {
        imageView = (ImageView) root.findViewById(R.id.imageView);
    }

    /**
     * @tips
     * 优化小技巧：在这里直接设置按钮的监听器。
     * 因为这个方法仅仅在item建立时才调用，所以不会重复建立监听器。
     */
    @Override
    public void onSetViews() {
        Log.d(ImageItem.class.getSimpleName(), "onSetViews--------->");
    }

    /**
     * @tips 优化小技巧：对于图片这样的对象，我们先判断要加载的图片是不是之前的图片，如果是就不重复加载了
     * 这里为了演示方便没从网络加图，所以url是用int标识的，一般情况下都是用string标识
     *
     * 这里仅仅是用图片做个说明，你完全可以在textview显示文字前判断一下要显示的文字和已经显示的文字是否不同
     */
    @Override
    public void onUpdateViews(DemoModel model, int position) {
        if (imageView.getTag() != null) {
            mOldImageUrl = (String) imageView.getTag();
        }
        String imageUrl = model.getUrl();

        if (mOldImageUrl == null) {
            imageView.setTag(imageUrl);
            Picasso.with(mActivity).load(model.getUrl()).fit().into(imageView);
        } else {
            if (!mOldImageUrl.equals(imageUrl)) {
                imageView.setTag(imageUrl);
                Picasso.with(mActivity).load(model.getUrl()).fit().into(imageView);
            }
        }
    }
}
