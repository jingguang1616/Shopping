package com.example.liangxq.shopping;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.liangxq.shopping.adapter.MyViewPagerAdapter;
import com.example.liangxq.shopping.adapter.Rcyadapter;
import com.example.liangxq.shopping.hualang.GallyPageTransformer;
import com.example.liangxq.shopping.hualang.ImageUtil;
import com.example.mvplibrary.base.BaseFragment;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends BaseFragment {


    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.tvTao)
    ImageView tvTao;
    @BindView(R.id.viewFen)
    View viewFen;
    @BindView(R.id.filpper)
    ViewFlipper filpper;
    @BindView(R.id.rcy)
    RecyclerView rcy;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.activity_main)
    LinearLayout ll_main;
    @BindView(R.id.iv)
    ImageView iv;
    private View view;
    /*
     * 首页Banner
     */
    String HOME_BANNER_ONE = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1502876108368&di=cd9725c81901f6d7499edd76cf2e68e5&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F17%2F37%2F20%2F80Q58PICe3W_1024.jpg";
    String HOME_BANNER_TWO = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1502882008108&di=d0cf4a8536aefa5df791716c1053ca66&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01e9495812c7f9a84a0d304fbc135b.jpg";
    String HOME_BANNER_THREE = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1502876281925&di=f33e7ef8be268e90ffbffd315f5fb0a3&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F013e1b57d2731c0000018c1beeca11.jpg%40900w_1l_2o_100sh.jpg";
    String HOME_BANNER_FOUR = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503471047&di=679d7a6c499f59d1b0dcd56b62a9aa6c&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.90sheji.com%2Fdianpu_cover%2F11%2F14%2F64%2F55%2F94ibannercsn_1200.jpg";

    /*
       首页折扣图片
     */
    String HOME_DISCOUNT_ONE = "https://img14.360buyimg.com/n0/jfs/t3157/231/5756125504/98807/97ab361d/588084a1N06efb01d.jpg";
    String HOME_DISCOUNT_TWO = "https://img10.360buyimg.com/n7/jfs/t5905/106/1120548052/61075/6eafa3a5/592f8f7bN763e3d30.jpg";
    String HOME_DISCOUNT_THREE = "https://img10.360buyimg.com/n7/jfs/t5584/99/6135095454/371625/423b9ba5/59681d91N915995a7.jpg";
    String HOME_DISCOUNT_FOUR = "https://img11.360buyimg.com/n7/jfs/t4447/301/1238553109/193354/13c7e995/58db19a7N25101fe4.jpg";
    String HOME_DISCOUNT_FIVE = "https://img14.360buyimg.com/n1/s190x190_jfs/t7525/189/155179632/395056/e200017f/598fb8a4N7800dee6.jpg";

    /*
        首页话题图片
     */
    String HOME_TOPIC_ONE = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1502881866380&di=d252e1e8dd3a5a836fe360b02531f917&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01f5ce56e112ef6ac72531cb37bec4.png%40900w_1l_2o_100sh.jpg";
    String HOME_TOPIC_TWO = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1502881904494&di=7a16834200a70469e1d3b6a4ab04c514&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F010d11554baebf000001bf721352ac.jpg";
    String HOME_TOPIC_THREE = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1502876222250&di=aa3290c84822ba5570f19cb76e1012af&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0146d25768b5a10000018c1b00cf27.jpg%40900w_1l_2o_100sh.jpg";
    String HOME_TOPIC_FOUR = "http://img.zcool.cn/community/01796c58772f66a801219c77e4fc04.png@1280w_1l_2o_100sh.png";
    String HOME_TOPIC_FIVE = "http://img.zcool.cn/community/0154805791ffeb0000012e7edba495.jpg@900w_1l_2o_100sh.jpg";
    private ArrayList<String> titles;
    private ArrayList<String> listrcy;
    private Rcyadapter rcyadapter;
    private int pagerWidth;
    private ArrayList<ImageView> imageViews;


    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    protected void initData() {
        initsousuo();
        initbanner();
        initgonggao();
        initrcy();
        inithualang();
    }

    private void initsousuo() {
    
    }

    private void inithualang() {
        initdata();
        mViewPager.setOffscreenPageLimit(3);
        pagerWidth = (int) (getResources().getDisplayMetrics().widthPixels * 3.0f / 5.0f);
        ViewGroup.LayoutParams lp = mViewPager.getLayoutParams();
        if (lp == null) {
            lp = new ViewGroup.LayoutParams(pagerWidth, ViewGroup.LayoutParams.MATCH_PARENT);
        } else {
            lp.width = pagerWidth;
        }
        mViewPager.setLayoutParams(lp);
        mViewPager.setPageMargin(-50);
        ll_main.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return mViewPager.dispatchTouchEvent(motionEvent);
            }
        });
        mViewPager.setPageTransformer(true, new GallyPageTransformer());
        mViewPager.setAdapter(new MyViewPagerAdapter(imageViews));
    }

    private void initdata() {
        imageViews = new ArrayList<>();
        ImageView first = new ImageView(getActivity());
        first.setImageBitmap(ImageUtil.getReverseBitmapById(R.drawable.hua1, getActivity()));
//        first.setImageResource(R.mipmap.first);
        ImageView second = new ImageView(getActivity());
        second.setImageBitmap(ImageUtil.getReverseBitmapById(R.drawable.hua2, getActivity()));
//        second.setImageResource(R.mipmap.second);
        ImageView third = new ImageView(getActivity());
        third.setImageBitmap(ImageUtil.getReverseBitmapById(R.drawable.hua1, getActivity()));
//        third.setImageResource(R.mipmap.third);
        ImageView fourth = new ImageView(getActivity());
//        fourth.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.fourth,MainActivity.this));
        fourth.setImageResource(R.drawable.hua2);
        ImageView fifth = new ImageView(getActivity());
        fifth.setImageBitmap(ImageUtil.getReverseBitmapById(R.drawable.hua1, getActivity()));
//        fifth.setImageResource(R.mipmap.fifth);
        imageViews.add(first);
        imageViews.add(second);
        imageViews.add(third);
        imageViews.add(fourth);
        imageViews.add(fifth);

    }


    private void initbanner() {
        ArrayList<String> list = new ArrayList<>();
        list.add(HOME_BANNER_ONE);
        list.add(HOME_BANNER_TWO);
        list.add(HOME_BANNER_THREE);
        list.add(HOME_BANNER_FOUR);
        //图片
        banner.setImages(list);
        //加载图片
        banner.setImageLoader(new ImageLoadBanner());
        //时间
        banner.setDelayTime(1000);
        //
        banner.isAutoPlay(true);
        //指示位置
        banner.setIndicatorGravity(BannerConfig.CENTER);
//        banner.setBannerAnimation(Transformer.Accordion);
//        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        banner.start();
    }

    private void initgonggao() {
        titles = new ArrayList<>();
        titles.add("没有什么退路，只有咬牙坚持走下去的路！");
        titles.add("今天的你依旧帅气如初 ");
        titles.add("愿十年之后的自己会感谢当初努力奋斗的你");
        titles.add("日子再甜,也没有你甜");
        titles.add("喜欢阿羡也喜欢李现但更喜欢你现（出现）");
        for (int i = 0; i < titles.size(); i++) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.viewtext, null);
            TextView tvTitle = view.findViewById(R.id.tvItem);
            //赋值
            tvTitle.setText(titles.get(i));
            //动态添加视图
            filpper.addView(view);
        }

        //设置的时间间隔来开始切换所有的View,切换会循环进行
        filpper.startFlipping();
        //视图进入动画
        filpper.setInAnimation(context, R.anim.new_in);
        //视图退出动画
        filpper.setOutAnimation(context, R.anim.new_out);
        //自动开始滚动
        filpper.setAutoStart(true);
        //视图的切换间隔
        filpper.setFlipInterval(3000);
    }


    class ImageLoadBanner extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
//            imageView.setImageResource(Integer.parseInt(path.toString()));
            Glide.with(getActivity()).load(path).into(imageView);
        }
    }

    private void initrcy() {
        LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        rcy.setLayoutManager(manager);
        listrcy = new ArrayList<>();
        listrcy.add(HOME_DISCOUNT_ONE);
        listrcy.add(HOME_DISCOUNT_TWO);
        listrcy.add(HOME_DISCOUNT_THREE);
        listrcy.add(HOME_DISCOUNT_FOUR);
        listrcy.add(HOME_DISCOUNT_FIVE);
        rcyadapter = new Rcyadapter(listrcy, getActivity());
        rcy.setAdapter(rcyadapter);
    }


    @Override
    protected int initLayoutId() {
        return R.layout.fragment_fragment1;
    }


//    private class GallyPageTransformer implements ViewPager.PageTransformer {
//        @Override
//        public void transformPage(@NonNull View page, float position) {
//
//        }
//    }
}
