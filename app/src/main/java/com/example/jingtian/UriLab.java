package com.example.jingtian;



import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

public class UriLab {
    private static UriLab instance= null;
    private List<Uri> uris;

    /**
     * 让构造方法称为私有，避免外部调用
     */
    public UriLab(){
        init();
    }

    private void init() {
        uris = new ArrayList<>();
        uris.add(Uri.parse("http://devimages.apple.com/iphone/samples/bipbop/bipbopall.m3u8\n"));
        uris.add(Uri.parse("http://223.110.245.159/ott.js.chinamobile.com/PLTV/3/224/3221225530/index.m3u8\n"));//1
        uris.add(Uri.parse("http://223.110.245.170/ott.js.chinamobile.com/PLTV/3/224/3221227412/index.m3u8\n"));//2
        uris.add(Uri.parse("http://223.110.245.165/ott.js.chinamobile.com/PLTV/3/224/3221225588/index.m3u8\n"));//3
        uris.add(Uri.parse("http://223.110.245.159/ott.js.chinamobile.com/PLTV/3/224/3221225781/index.m3u8\n"));//4
        uris.add(Uri.parse("http://223.110.245.165/ott.js.chinamobile.com/PLTV/3/224/3221227381/index.m3u8\n"));//5
        uris.add(Uri.parse("http://223.110.245.170/ott.js.chinamobile.com/PLTV/3/224/3221226322/index.m3u8\n"));//5+
        uris.add(Uri.parse("http://223.110.245.159/ott.js.chinamobile.com/PLTV/3/224/3221225548/index.m3u8\n"));//6
        uris.add(Uri.parse("http://223.110.245.170/ott.js.chinamobile.com/PLTV/3/224/3221225546/index.m3u8\n"));//7
        uris.add(Uri.parse("http://223.110.245.155/ott.js.chinamobile.com/PLTV/3/224/3221227304/index.m3u8\n"));//8
        uris.add(Uri.parse("http://223.110.245.170/ott.js.chinamobile.com/PLTV/3/224/3221227471/index.m3u8\n"));//9
        uris.add(Uri.parse("http://223.110.245.170/ott.js.chinamobile.com/PLTV/3/224/3221227403/index.m3u8\n"));//10
        uris.add(Uri.parse("http://223.110.245.170/ott.js.chinamobile.com/PLTV/3/224/3221225552/index.m3u8\n"));//11
        uris.add(Uri.parse("http://223.110.245.170/ott.js.chinamobile.com/PLTV/3/224/3221225556/index.m3u8\n"));//12
        uris.add(Uri.parse("http://223.110.245.155/ott.js.chinamobile.com/PLTV/3/224/3221226021/index.m3u8\n"));//13
        uris.add(Uri.parse("http://223.110.245.143/ott.js.chinamobile.com/PLTV/3/224/3221226025/index.m3u8\n"));//15
    }


    /**
     * 此方法指挥返回同一个实例，不会创建新的实例。
     * @retuen 单例，表示频道仓库
     */
    public static UriLab getU(){
        if (null == instance){
            instance = new UriLab();
        }
        return instance;
    }

    /**
     * 返回此仓库中有几个频道
     * @return 频道数量，整数
     */
//    private   int getSize(){
//        return uris.size();
//    }

    /**
     * 返回指定的频道信息
     * @param n 频道的编号
     * @return 频道信息
     */
    public Uri getUris(int n) {
        return uris.get(n);
        /**
         * 初始化一些频道信息用于测试。
         */


    }}