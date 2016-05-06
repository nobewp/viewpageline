package nobe.viewpageline;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.tab1)
    TextView tab1;
    @Bind(R.id.tab2)
    TextView tab2;
    @Bind(R.id.ll_item_container)
    LinearLayout llItemContainer;
    @Bind(R.id.scroll_view)
    ScrollerTabView scrollView;
    @Bind(R.id.container)
    ViewPager container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tab1.setOnClickListener(this);
        tab2.setOnClickListener(this);
        tab1.setTextColor(getResources().getColor(R.color.app_base_color));
        scrollView.setTabNum(2);
//        scrollView.setSelectedColor(getResources().getColor(R.color.app_base_color), getResources().getColor(R
//                .color.app_base_color));


        container.setAdapter(new MyAccountViewPagerAdapter(getSupportFragmentManager()));
        container.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int i, final float v, final int i1) {
                scrollView.setOffset(i, v);

            }

            @Override
            public void onPageSelected(final int i) {
                if (i == 0)
                {
                    tab1.setTextColor(getResources().getColor(R.color.app_base_color));
                    tab2.setTextColor(getResources().getColor(R.color.c_333));
                } else if (i == 1)
                {
                    tab1.setTextColor(getResources().getColor(R.color.app_base_color));
                    tab2.setTextColor(getResources().getColor(R.color.c_333));
                } else if (i == 2)
                {

                }
            }

            @Override
            public void onPageScrollStateChanged(final int i) {

            }
        });
    }

    @Override
    public void onClick(final View v) {
        switch (v.getId())
        {

            case R.id.tab1:

                container.setCurrentItem(0);
                scrollView.setCurrentNum(0);
                break;
            case R.id.tab2:
                container.setCurrentItem(1);
                scrollView.setCurrentNum(1);
                break;
        }
    }

    class MyAccountViewPagerAdapter extends FragmentPagerAdapter {

        private final List<String> catalogs = new ArrayList<String>();

        public MyAccountViewPagerAdapter(FragmentManager fm) {
            super(fm);
            catalogs.add("1");
            catalogs.add("2");
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return catalogs.get(position);
        }

        @Override
        public int getCount() {
            return catalogs.size();
        }

        @Override
        public Fragment getItem(int position) {
            return TestFragment.newInstance(position);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}
