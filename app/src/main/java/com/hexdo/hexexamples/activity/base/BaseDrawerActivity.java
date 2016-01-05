package com.hexdo.hexexamples.activity.base;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.widget.ImageView;
import android.widget.TextView;
import app.newbee.lib.base.BaseCompatActivity;
import butterknife.Bind;
import butterknife.BindDimen;
import butterknife.BindString;
import com.hexdo.hexexamples.R;
import com.hexdo.hexexamples.activity.UserProfileActivity;
import com.hexdo.hexexamples.utils.CircleTransformation;
import com.squareup.picasso.Picasso;

/**
 * Created by Miroslaw Stanek on 15.07.15.
 */
public abstract class BaseDrawerActivity extends BaseCompatActivity {

    @Bind(R.id.drawerLayout) DrawerLayout drawerLayout;
    @Bind(R.id.vNavigation) NavigationView vNavigation;
    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.ivLogo) TextView ivLogo;
    @BindDimen(R.dimen.global_menu_avatar_size) int avatarSize;
    @BindString(R.string.user_profile_photo) String profilePhoto;
    private MenuItem inboxMenuItem;
    //Cannot be bound via Butterknife, hosting view is initialized later (see setupHeader() method)
    private ImageView ivMenuUserProfilePhoto;

    @Override protected int getContentViewLayoutID() {
        return R.layout.activity_drawer;
    }

    @Override protected void injectView() {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.flContentRoot);
        LayoutInflater.from(this).inflate(getLayoutId(), viewGroup, true);
    }

    @Override protected void processLogic(Bundle savedInstanceState) {
        setupToolbar();
        setupHeader();
    }

    protected void setupToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.mipmap.ic_menu_white);
        }
        if (getToolbar() != null) {
            getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawerLayout.openDrawer(Gravity.LEFT);
                }
            });
        }
    }

    private void setupHeader() {
        View headerView = vNavigation.getHeaderView(0);
        ivMenuUserProfilePhoto = (ImageView) headerView.findViewById(R.id.ivMenuUserProfilePhoto);
        headerView.findViewById(R.id.vGlobalMenuHeader).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onGlobalMenuHeaderClick(v);
            }
        });

        Picasso.with(this)
                .load(profilePhoto)
                .placeholder(R.drawable.img_circle_placeholder)
                .resize(avatarSize, avatarSize)
                .centerCrop()
                .transform(new CircleTransformation())
                .into(ivMenuUserProfilePhoto);
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public void onGlobalMenuHeaderClick(final View v) {
        drawerLayout.closeDrawer(Gravity.LEFT);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                int[] startingLocation = new int[2];
                v.getLocationOnScreen(startingLocation);
                startingLocation[0] += v.getWidth() / 2;
                //TODO
                UserProfileActivity.startUserProfileFromLocation(startingLocation, BaseDrawerActivity.this);
                overridePendingTransition(0, 0);
            }
        }, 200);
    }

    protected abstract int getLayoutId();

    public MenuItem getInboxMenuItem() {
        return inboxMenuItem;
    }

    public TextView getIvLogo() {
        return ivLogo;
    }


}
