package com.example.xfl.xfl_core.app;

import android.content.Context;

import java.util.WeakHashMap;

public final class Ec {

    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInsdance();
    }

    private static WeakHashMap<String, Object> getConfigurations() {
        return Configurator.getInsdance().getXflConfigs();
    }
}
