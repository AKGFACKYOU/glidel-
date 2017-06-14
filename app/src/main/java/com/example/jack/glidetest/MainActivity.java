package com.example.jack.glidetest;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.jack.glidetest.adapter.PlayDetailsAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.BlurTransformation;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.iv_bg)
    ImageView ivBg;
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.vp)
    ViewPager vp;
    ArrayList<RoundFragment> mRoundFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        iv.setColorFilter(R.color.colorAccent);
        mRoundFragments = new ArrayList<>();
        mRoundFragments.add(new RoundFragment());
        mRoundFragments.add(new RoundFragment());
        mRoundFragments.add(new RoundFragment());
        mRoundFragments.add(new RoundFragment());
        mRoundFragments.add(new RoundFragment());
        mRoundFragments.add(new RoundFragment());
        mRoundFragments.add(new RoundFragment());
        PlayDetailsAdapter pd = new PlayDetailsAdapter(getSupportFragmentManager(), mRoundFragments);
        vp.setAdapter(pd);


        Glide.with(this)
                .load("http://img1.gtimg.com/ninja/1/2017/05/ninja149585467818314.jpg")
                //模糊图片, this   10 模糊度   5 将图片缩放到5倍后进行模糊
                .bitmapTransform(new BlurTransformation(this, 10, 3) {
                })
                .into(ivBg);

    }

}
