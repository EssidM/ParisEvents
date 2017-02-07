package com.frichti.parisevents.data.component;

import com.frichti.parisevents.data.module.MainScreenModule;
import com.frichti.parisevents.mainscreen.MainActivity;
import com.frichti.parisevents.util.MainScope;

import dagger.Component;

/**
 * @author Mohamed Essid on 03/02/2017.
 */

@MainScope
@Component(dependencies = NetworkComponent.class, modules = MainScreenModule.class)
public interface MainScreenComponent {

    void inject(MainActivity activity);
}
