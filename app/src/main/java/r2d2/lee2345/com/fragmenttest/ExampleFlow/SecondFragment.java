package r2d2.lee2345.com.fragmenttest.ExampleFlow;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import r2d2.lee2345.com.fragmenttest.GridView.GridViewFragment;

/**
 * Created by leesuckgeun on 15/09/06.
 */
public class SecondFragment extends GridViewFragment {

    @Override
    protected View initItemView(int position, View convertView, ViewGroup parent) {
        Button button;
        if (convertView == null) {
            button = new Button(getActivity());
            button.setFocusable(false);
            button.setClickable(false);
        } else {
            button = (Button) convertView;
        }

        button.setText(modelList.get(position).toString());
        return button;
    }
}
