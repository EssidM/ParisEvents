package com.frichti.parisevents.data.component;


import com.frichti.parisevents.data.module.AppModule;
import com.frichti.parisevents.data.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * @author Mohamed Essid on 03/02/2017.
 */
@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface NetworkComponent {
    Retrofit retrofit();

}
