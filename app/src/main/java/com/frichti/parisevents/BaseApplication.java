package com.frichti.parisevents;

import android.app.Application;

import com.frichti.parisevents.data.component.DaggerNetworkComponent;
import com.frichti.parisevents.data.component.NetworkComponent;
import com.frichti.parisevents.data.module.AppModule;
import com.frichti.parisevents.data.module.NetworkModule;
import com.frichti.parisevents.util.Constant;

/**
 * base application class
 *
 * @author Mohamed Essid on 07/02/2017.
 */

public class BaseApplication extends Application {

    /**
     * network component
     */
    private NetworkComponent mNetworkComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetworkComponent = DaggerNetworkComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule(Constant.BASE_URL))
                .build();
    }

    /**
     * returns network component
     *
     * @return
     */
    public NetworkComponent getNetworkComponent() {
        return mNetworkComponent;
    }
}
