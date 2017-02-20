package me.kashifminhaj.starwars;

import android.app.Application;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/*
 * Created by kashif on 20/2/17.
 */

public class Common extends Application {

    private Context mContext;
    private RequestQueue mRequestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        mRequestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mContext);
        }
        return mRequestQueue;
    }


    /*
     * The RequestQueue manages worker threads for running the network operations,
     * reading from and writing to the cache, and parsing responses.
     */
    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }


}
