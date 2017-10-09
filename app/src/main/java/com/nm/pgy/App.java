package com.nm.pgy;

import com.libra.BaseApp;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by admin on 2017/9/20.
 */

public class App extends BaseApp {
    public String hostUrl;
    protected static App app;

    public static App getInstance() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if(app == null) {
            app = this;
        }

        initJPush();
    }


    private void initJPush() {
        //初始化sdk
        JPushInterface.setDebugMode(true);//正式版的时候设置false，关闭调试
        JPushInterface.init(this);
        //建议添加tag标签，发送消息的之后就可以指定tag标签来发送了
        Set<String> set = new HashSet<>();
        set.add("pgydemo");//名字任意，可多添加几个
        JPushInterface.setTags(this, set, null);//设置标签
    }

    public File getTempDir() {
        return createFloder("/pgy/temp/", true);
    }

    private void initServerIp() {
        if (BuildConfig.DEBUG) {
            hostUrl = App.getInstance().getString(R.string.default_server);
        } else {
            hostUrl = App.getInstance().getString(R.string.default_server);
        }
    }

    public String getBaseUrl() {
        return hostUrl;
    }

}
