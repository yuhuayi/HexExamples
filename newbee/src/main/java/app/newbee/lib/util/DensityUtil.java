package app.newbee.lib.util;

import android.content.res.Resources;

public class DensityUtil {
    public static int dpToPx(float dpValue) {
        return (int) (dpValue * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int px2Dp(float pxValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
