package com.example.xfl.xfl_core.app;

public enum ConfigType {
    //线程安全的懒汉模式
    //通过枚举类保证多线程安全
    API_HOST,//存储网络请求域名
    APPLICATION_CONTEXT,//全局上下文
    CONFIG_READY,//控制初始化或者配置，查看是否已完成
    ICON //字体的初始化项目
}
