package com.squareup.otto;

/**
 * NCR
 * Created by Habib on 2/17/15.
 */
public interface EventCallBack {

    void onEventFired(String originClass, String originMethod, Object eventFired);

    void onEventReceived(String receiverClass, String receiverMethod, Object eventFired);

}