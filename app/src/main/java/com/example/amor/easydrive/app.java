package com.example.amor.easydrive;

import com.parse.Parse;
import android.app.Application;

public class app extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "XYKm55v5tV3BfgPPoGtIgSi52muFTRf0kqvnrw66", "oeTlB9ftDYyQ5NdNsYdpkh2E7YVDv03u4qsvDxx2");
    }
}