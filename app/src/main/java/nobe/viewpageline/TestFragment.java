package nobe.viewpageline;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by wangpeng on 16/5/6.
 * describ：
 * revise：
 */
public class TestFragment extends Fragment {


    View view;
    TextView textView;
    int position;
    public static TestFragment newInstance(int position) {
        TestFragment f = new TestFragment();
        Bundle b = new Bundle();
        b.putInt("test", position);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("test");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null)
        {

            view = inflater.inflate(R.layout.testfragment, null);
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null)
        {

            parent.removeView(view);
        }

        textView = (TextView) view.findViewById(R.id.name);
        initView();
        return view;
    }
    public  void initView(){
        textView.setText("页面"+position);
    }
}
