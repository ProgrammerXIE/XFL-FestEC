package com.example.xfl.xfl_core.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.WeakHashMap;

public class Configurator {
    //weakHashMap 可以最大限度的避免内存爆满
    private static final WeakHashMap<String, Object> XFL_CONFIGS = new WeakHashMap<>();

    private Configurator(){
        XFL_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    public static Configurator getInsdance() {
        return Holder.INSTANCE;
    }

    final WeakHashMap<String, Object> getXflConfigs() {
        return XFL_CONFIGS;
    }

    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();

    /**
     * 静态内部类，单例模式初始化
     */
    private static class Holder{
        private static final Configurator INSTANCE = new Configurator();
    }

    public final void configure(){
        XFL_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    public final Configurator withApiHost(String host) {
        XFL_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return  this;
    }

    private void initIcons() {
        if(ICONS.size()>0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i  = 1 ; i < ICONS.size() ; i++) {
                initializer.with(ICONS.get(i));//21
            }
        }
    }

    public final Configurator withIcon (IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
        return this;
    }
    private void checkConfiguration() {
        final boolean isReady = (boolean) XFL_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("configuration is not ready, call configure");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key) {
        checkConfiguration();
        return (T) XFL_CONFIGS.get(key.name());
    }
}
