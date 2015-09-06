package r2d2.lee2345.com.fragmenttest.ExampleFlow;

import r2d2.lee2345.com.fragmenttest.GridView.GridViewModel;
import r2d2.lee2345.com.fragmenttest.GridView.GridViewSimplePresenter;
import r2d2.lee2345.com.fragmenttest.R;
import r2d2.lee2345.com.fragmenttest.util.DisplayMode;

/**
 * Created by leesuckgeun on 15/09/05.
 */
public class ExamplePresenter extends GridViewSimplePresenter {


    public ExamplePresenter() {
        super();
    }

    @Override
    public void onItemClicked(GridViewModel model) {
        if(model.equals(FirstModel.FIRST_1))
            this.displayGridViewFragment(R.id.body_layout, SecondFragment.class, DisplayMode.REPLACE, 1);
    }

}
