package com.example.jingtian;

import java.util.ArrayList;
import java.util.List;

/**
 * 存储电视频道信息，它在整个应用程序中应该只有一个实例，所以应该采用单例设计模式来完成
 */
public class PlayLab {
    private static PlayLab instance= null;
    private List<String>plays;
    /**
     * 让构造方法称为私有，避免外部调用
     */
    private PlayLab(){
        init();
    }
    /**
     * 此方法指挥返回同一个实例，不会创建新的实例。
     * @retuen 单例，表示频道仓库
     */
    public static PlayLab get(){
        if (null == instance){
            instance = new PlayLab();
        }
        return instance;
    }

    /**
     * 返回此仓库中有几个频道
     * @return 频道数量，整数
     */
    public  int getSize(){
        return plays.size();
    }

    /**
     * 返回指定的频道信息
     * @param n 频道的编号
     * @return 频道信息
     */
    public String getPlay(int n){
        return plays.get(n);
    }

    /**
     * 初始化一些频道信息用于测试。
     */
    private void init(){
        plays = new ArrayList<>();
        plays.add("美丽心灵");
        plays.add("sss");
        plays.add("aaa");
        plays.add("xxx");
        plays.add("vvv");
    }
}
