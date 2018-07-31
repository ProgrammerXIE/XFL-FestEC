package com.example.xfl.festec;

import android.app.Application;

import com.example.xfl.xfl_core.app.Ec;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

public class ExampleApp extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        Ec.init(this).withIcon(new FontAwesomeModule()).withApiHost("http://127.0.0.1/").configure();
    }
}
