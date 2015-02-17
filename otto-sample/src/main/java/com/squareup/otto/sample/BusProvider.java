/*
 * Copyright (C) 2012 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.squareup.otto.sample;

import android.util.Log;

import com.squareup.otto.Bus;
import com.squareup.otto.EventCallBack;

/**
 * Maintains a singleton instance for obtaining the bus. Ideally this would be replaced with a more efficient means
 * such as through injection directly into interested classes.
 */
public final class BusProvider {
  private static final Bus BUS;
  private static final String OTTO_LOG_TAG = "Otto";

    static {
        BUS = new Bus();
        Bus.setEventCallbacks(new EventCallBack() {
            @Override
            public void onEventFired(String originClass, String originMethod, Object eventFired) {
                Log.v(OTTO_LOG_TAG, "Event" + eventFired.getClass().getCanonicalName() + " Fired From: " +
                        originClass + " By" + originMethod);
            }

            @Override
            public void onEventReceived(String receiverClass, String receiverMethod, Object eventFired) {
                Log.v(OTTO_LOG_TAG, "Event" + eventFired.getClass().getCanonicalName() + " Received In: " +
                        receiverClass + " By" + receiverMethod);
            }
        });
    }


    public static Bus getInstance() {
    return BUS;
  }

  private BusProvider() {
    // No instances.
  }
}
