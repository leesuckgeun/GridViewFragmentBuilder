package r2d2.lee2345.com.fragmenttest.ExampleFlow;

import r2d2.lee2345.com.fragmenttest.GridView.GridViewModel;

/**
 * Created by leesuckgeun on 15/09/06.
 */
public enum FirstModel implements GridViewModel {

    FIRST_1 {
        @Override
        public String toString() {
            return "FIRST 1";
        }
    },
    FIRST_2 {
        @Override
        public String toString() {
            return "FIRST 2";
        }
    },
    FIRST_3 {
        @Override
        public String toString() {
            return "FIRST 3";
        }
    }
}
