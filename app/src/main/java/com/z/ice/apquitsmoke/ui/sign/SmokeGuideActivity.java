package com.z.ice.apquitsmoke.ui.sign;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.z.ice.apquitsmoke.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.bgabanner.BGABanner;

public class SmokeGuideActivity extends AppCompatActivity {

    @BindView(R.id.smoke_guide_bb)
    BGABanner mSmokeGuideBb;
    @BindView(R.id.card1)
    CardView mCard1;
    @BindView(R.id.card2)
    CardView mCard2;
    @BindView(R.id.card3)
    CardView mCard3;
    private CardView[] mCardViews;
    private int[] mGuideImgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smoke_guide);
        ButterKnife.bind(this);
        mCardViews = new CardView[]{mCard1, mCard2, mCard3};
//        mSmokeGuideBb.setAdapter(this);
        mSmokeGuideBb.setData(R.color.colorGuidePage, R.color.colorGuidePage2, R.color.colorGuidePage3);
        mSmokeGuideBb.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                for (CardView cardView : mCardViews) {
                    cardView.setVisibility(View.GONE);
                }
                mCardViews[position].setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
