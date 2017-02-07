package com.frichti.parisevents.mainscreen;

import com.frichti.parisevents.entity.EventResponse;
import com.frichti.parisevents.network.EventService;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observer;
import rx.schedulers.Schedulers;

/**
 * @author Mohamed Essid on 07/02/2017.
 */

public class MainScreenPresenter implements MainScreenContract.Presenter {


    MainScreenContract.View mView;
    Retrofit mRetrofit;

    @Inject
    public MainScreenPresenter(MainScreenContract.View mView, Retrofit retrofit) {
        this.mView = mView;
        this.mRetrofit = retrofit;
    }

    @Override
    public void loadEvents() {
        mRetrofit.create(EventService.class)
                .getEvents()
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<EventResponse>() {

                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(EventResponse eventResponse) {
                        mView.showEvents(eventResponse);
                    }
                });
    }
}
