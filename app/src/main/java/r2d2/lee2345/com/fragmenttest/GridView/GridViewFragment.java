package r2d2.lee2345.com.fragmenttest.GridView;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;

import java.util.List;

import r2d2.lee2345.com.fragmenttest.R;


public abstract class GridViewFragment extends Fragment {

    private GridItemClickListener mListener;
    private int col_num = 2;
    protected List<GridViewModel> modelList;

    public GridViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grid_view, container, false);
        initGridView(view);
        return view;
    }

    private void initGridView(View view) {
        GridView gridView = (GridView) view.findViewById(R.id.gridView);
        gridView.setNumColumns(col_num);
        MyAdapter adapter = new MyAdapter();
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListener.itemClicked(modelList.get(position));
            }
        });
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (GridItemClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeaderFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    protected abstract View initItemView(final int position, View convertView, ViewGroup parent);

    public void setCol_num(int col_num) {
        this.col_num = col_num;
    }

    public void setModelList(List<GridViewModel> modelList) {
        this.modelList = modelList;
    }

    public interface GridItemClickListener {
        void itemClicked(GridViewModel model);
    }




    private class MyAdapter extends BaseAdapter {

        public int getCount() {
            return modelList.size();
        }

        public Object getItem(int position) {
            return modelList.get(position);
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(final int position, View convertView, ViewGroup parent) {
            return initItemView(position, convertView, parent);
        }

    }

}
