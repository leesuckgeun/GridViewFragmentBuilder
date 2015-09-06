package r2d2.lee2345.com.fragmenttest.ExampleFlow;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import r2d2.lee2345.com.fragmenttest.FooterFragment;
import r2d2.lee2345.com.fragmenttest.GridView.GridViewFragment;
import r2d2.lee2345.com.fragmenttest.GridView.GridViewModel;
import r2d2.lee2345.com.fragmenttest.HeaderFragment;
import r2d2.lee2345.com.fragmenttest.R;
import r2d2.lee2345.com.fragmenttest.util.DisplayMode;


public class ExampleActivity extends Activity
        implements GridViewFragment.GridItemClickListener,
        HeaderFragment.OnHeaderFragmentListener,
        FooterFragment.OnFooterFragmentListener {

    private ExamplePresenter examplePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initPresenter();

        examplePresenter.displayFragment
                (R.id.header_layout, HeaderFragment.class, DisplayMode.INITIAL);
        examplePresenter.displayGridViewFragment
                (R.id.body_layout, FirstFragment.class, DisplayMode.INITIAL, 2);
        examplePresenter.displayFragment
                (R.id.footer_layout, FooterFragment.class, DisplayMode.INITIAL);

        
    }

    private void initPresenter() {
        examplePresenter = new ExamplePresenter();
        examplePresenter.setFragmentManager(getFragmentManager());
        examplePresenter.addModel(FirstFragment.class, FirstModel.class);
        examplePresenter.addModel(SecondFragment.class, SecondModel.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void itemClicked(GridViewModel model) {
        examplePresenter.onItemClicked(model);
    }

    @Override
    public void onHeaderClicked() {

    }

    @Override
    public void onFooterClicked() {

    }
}
