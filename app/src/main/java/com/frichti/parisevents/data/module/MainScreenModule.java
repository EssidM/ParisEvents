package com.frichti.parisevents.data.module;

import com.frichti.parisevents.mainscreen.MainScreenContract;
import com.frichti.parisevents.util.MainScope;

import dagger.Module;
import dagger.Provides;

/**
 * @author Mohamed Essid on 03/02/2017.
 */

@Module
public class MainScreenModule {
    MainScreenContract.View mView;

    public MainScreenModule(MainScreenContract.View view) {
        this.mView = view;
    }

    @Provides
    @MainScope
    MainScreenContract.View provideMainScreenView() {
        return mView;
    }
}
