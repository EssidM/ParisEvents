package com.frichti.parisevents.network;

import com.frichti.parisevents.entity.EventResponse;

import retrofit2.http.GET;

/**
 * Event response API
 * <p>
 * returns all event response
 *
 * @author Mohamed Essid on 07/02/2017.
 */

public interface EventService {

    public static final String GET_EVENTS_SERVICE = "api/records/1.0/search/?dataset=evenements-a-paris";

    @GET(GET_EVENTS_SERVICE)
    rx.Observable<EventResponse> getEvents();
}
