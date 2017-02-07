package com.frichti.parisevents.mainscreen;

import com.frichti.parisevents.entity.EventResponse;

/**
 * Main screen contract - defines MVP
 *
 * @author Mohamed Essid on 03/02/2017.
 */

public class MainScreenContract {

    /**
     * defines required view operations available to presenter
     */
    public interface View {
        /**
         * shows event in list
         *
         * @param response
         */
        void showEvents(EventResponse response);

        /**
         * shows error message
         *
         * @param err
         */
        void showError(String err);

        /**
         * shows success message
         */
        void showComplete();

    }

    /**
     * presenter operations
     */
    public interface Presenter {
        /**
         * loads events
         */
        void loadEvents();
    }
}
