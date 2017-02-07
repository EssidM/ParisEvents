package com.frichti.parisevents.mainscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.frichti.parisevents.BaseApplication;
import com.frichti.parisevents.R;
import com.frichti.parisevents.data.component.DaggerMainScreenComponent;
import com.frichti.parisevents.data.module.MainScreenModule;
import com.frichti.parisevents.entity.EventResponse;
import com.frichti.parisevents.entity.Record;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainScreenContract.View {


    /**
     * main screen presenter
     */
    @Inject
    MainScreenPresenter mPresenter;

    /**
     * event list recycler view
     */
    private RecyclerView mEventRecycler;
    /**
     * list adapter
     */
    private EventListAdapter mAdapter;
    /**
     * events list
     */
    private List<Record> mEvents = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recycler set up
        mEventRecycler = (RecyclerView) findViewById(R.id.main_list_events);
        mEventRecycler.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this) ;
        mEventRecycler.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mEventRecycler.getContext(),
                layoutManager.getOrientation());
        mEventRecycler.addItemDecoration(dividerItemDecoration);

        //injection
        DaggerMainScreenComponent.builder()
                .mainScreenModule(new MainScreenModule(this))
                .networkComponent(((BaseApplication) getApplication()).getNetworkComponent())
                .build().inject(this);

        mPresenter.loadEvents();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                mPresenter.loadEvents();
                return true;
        }

        return false;
    }

    @Override
    public void showEvents(EventResponse response) {

        if (response != null && response.getRecords() != null) {
            //filling list with event and recyler set up
            for (int i = 0; i < response.getRecords().size(); i++) {
                mEvents.add(response.getRecords().get(i));
            }
            //Create the array adapter and set it to list view
            mAdapter = new EventListAdapter(this, mEvents);
            mEventRecycler.post(new Runnable() {
                @Override
                public void run() {
                    mEventRecycler.setAdapter(mAdapter);
                }
            });
        } else {
            showError(getString(R.string.no_results));
        }
    }

    @Override
    public void showError(final String err) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, err, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showComplete() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, getString(R.string.complete), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
