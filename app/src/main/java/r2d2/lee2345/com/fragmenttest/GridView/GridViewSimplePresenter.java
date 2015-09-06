package r2d2.lee2345.com.fragmenttest.GridView;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import r2d2.lee2345.com.fragmenttest.util.DisplayMode;

/**
 * Created by leesuckgeun on 15/09/06.
 */
public abstract class GridViewSimplePresenter {

    protected FragmentManager fragmentManager;
    protected HashMap<Class<GridViewFragment>, List<GridViewModel>> models;

    public GridViewSimplePresenter() {
        models = new HashMap<>();
    }


    @SuppressWarnings("unchecked")
    public void addModel(Class fragmentClass, Class modelClass) {

        if (!isGridViewFragment(fragmentClass)) {
            throw wrongClassException(fragmentClass, "not GridViewFragment");
        }
        if (!isGridViewModel(modelClass)) {
            throw wrongClassException(modelClass, "not GridViewModel");
        }
        models.put(fragmentClass, getModelEnums(modelClass));
    }

    private IllegalArgumentException wrongClassException(Class myClass, String message) {
        IllegalArgumentException e
                = new IllegalArgumentException(myClass.getName() + ": " + myClass);
        e.printStackTrace();
        return e;
    }


    private boolean isGridViewFragment(Class fragmentClass) {
        return fragmentClass.getSuperclass().equals(GridViewFragment.class);
    }

    private boolean isGridViewModel(Class modelClass) {
        return modelClass.getInterfaces()[0].equals(GridViewModel.class);
    }

    private List<GridViewModel> getModelEnums(Class model) {

        List<GridViewModel> modelList = new ArrayList<>();
        Object[] values = model.getEnumConstants();
        for (Object value : values) {
            modelList.add((GridViewModel) value);
        }
        return modelList;
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void displayGridViewFragment(int container_layout_id, Class fragmentClass, DisplayMode displayMode, int col_num) {
        checkFragmentManagerNotNull();

        try {
            GridViewFragment fragment =
                    (GridViewFragment) Class.forName(fragmentClass.getName()).getConstructor().newInstance();
            fragment.setCol_num(col_num);
            fragment.setModelList(models.get(fragmentClass));
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            if (displayMode == DisplayMode.INITIAL) {
                transaction.add(container_layout_id, fragment);
            } else {
                transaction.replace(container_layout_id, fragment);
                transaction.addToBackStack(null);
            }
            transaction.commit();
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void displayFragment(int container_layout_id, Class fragmentClass, DisplayMode displayMode) {
        checkFragmentManagerNotNull();
        try {
            Fragment fragment =
                    (Fragment) Class.forName(fragmentClass.getName()).getConstructor().newInstance();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            if (displayMode == DisplayMode.INITIAL) {
                transaction.add(container_layout_id, fragment);
            } else {
                transaction.replace(container_layout_id, fragment);
                transaction.addToBackStack(null);
            }
            transaction.commit();
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private void checkFragmentManagerNotNull() {
        if (fragmentManager == null) {
            NullPointerException e =
                    new NullPointerException("fragmentManager is NULL. You have to set FragmentManager first");
            e.printStackTrace();
            throw e;
        }
    }


    public abstract void onItemClicked(GridViewModel model);


}
