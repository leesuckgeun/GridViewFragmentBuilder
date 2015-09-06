package r2d2.lee2345.com.fragmenttest.ExampleFlow;

import r2d2.lee2345.com.fragmenttest.GridView.GridViewModel;

/**
 * Created by leesuckgeun on 15/09/05.
 */
public enum SecondModel implements GridViewModel {

    SECOND_1 {
        @Override
        public String toString() {
            return "SECOND 1";
        }
    },
    SECOND_2 {
        @Override
        public String toString() {
            return "SECOND 2";
        }
    },
    SECOND_3 {
        @Override
        public String toString() {
            return "SECOND 3";
        }
    }

}
