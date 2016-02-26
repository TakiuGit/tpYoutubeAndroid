package fr.takiu.tpyoutube;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by paulu_000 on 26/02/2016.
 */
public class MyApplication extends Application {

    private static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        requestQueue = Volley.newRequestQueue(this);
    }

    public static RequestQueue getRequestQueue(){
        return requestQueue;
    }
}