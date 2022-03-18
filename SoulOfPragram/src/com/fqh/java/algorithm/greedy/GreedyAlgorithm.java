package com.fqh.java.algorithm.greedy;

import org.junit.jupiter.api.Test;

import java.util.*;
/**
 * @author 海盗狗
 * @version 1.0
 */
public class GreedyAlgorithm {

    public static void main(String[] args) {
        //创建广播电台, 放入map
        Map<String, Set<String>> broadcasts = new HashMap<>();
        //将各个电台放入到map
        Set<String> set1 = new HashSet<>();
        set1.add("北京");
        set1.add("上海");
        set1.add("天津");
        Set<String> set2 = new HashSet<>();
        set2.add("广州");
        set2.add("北京");
        set2.add("深圳");
        Set<String> set3 = new HashSet<>();
        set3.add("成都");
        set3.add("上海");
        set3.add("杭州");
        Set<String> set4 = new HashSet<>();
        set4.add("上海");
        set4.add("天津");
        Set<String> set5 = new HashSet<>();
        set5.add("杭州");
        set5.add("大连");

        //加入map
        broadcasts.put("K1", set1);
        broadcasts.put("K2", set2);
        broadcasts.put("K3", set3);
        broadcasts.put("K4", set4);
        broadcasts.put("K5", set5);

        //存放所有得地区
        Set<String> allArea = new HashSet<>();
        for (Map.Entry<String, Set<String>> entry : broadcasts.entrySet()) {
            for (String s : entry.getValue()) {
                allArea.add(s);
            }
        }

        //创建ArrayList存放选择的电台集合
        List<String> selects = new ArrayList<>();

        //保存在遍历过程中存放遍历过程中的电台覆盖的地区和当前还没有覆盖的地区的交集
        // k 和 allArea 的交集
        Set<String> tempSet = new HashSet<>();

        //定义maxKey, 保存在一次遍历过程中能够覆盖最多未覆盖地区对应的电台K
        //maxKey 不为 null 就加入到selects
        String maxKey = null;

        System.out.println(greedy(broadcasts, allArea));
//        while (allArea.size() != 0) { //allArea.size() != 0 表示还没有覆盖到所有地区
//            //每进行一次while
//            maxKey = null;
//
//            //遍历map, 取出对应的K
//            for (String key : broadcasts.keySet()) {
//                //每进行一个for需要把tempSet清空
//                tempSet.clear();
//                //当前这个K能够覆盖的地区
//                Set<String> areas = broadcasts.get(key);
//                tempSet.addAll(areas);
//                //求出tempSet 和 allAreas的交集, 赋给tempSet
//                tempSet.retainAll(allArea);
//                //如果当前这个集合包含的未覆盖地区的数量比maxKey指向的集合未覆盖的地区还多
//                //重置maxKey
//                if (tempSet.size() > 0 &&
//                        maxKey == null || tempSet.size() > broadcasts.get(maxKey).size()) {
//                    maxKey = key;
//                }
//            }
//            if(maxKey != null) {//将maxKey加入到selects
//                selects.add(maxKey);
//                //将maxKey指向的电台覆盖的地区从allAreas清除
//                allArea.removeAll(broadcasts.get(maxKey));
//            }
//        }
//        System.out.println("得到的结果= " + selects);
//    }
    }

    public static ArrayList<String> greedy(Map<String,Set<String>> broadcasts, Set<String> allAreas){
        ArrayList<String> selects = new ArrayList<>();
        String maxKey;
        int maxTemp;
        HashSet<String> tempSet = new HashSet<>();
        while(allAreas.size() != 0){
            maxKey = null;
            maxTemp = 0;
            for(String key : broadcasts.keySet()){
                tempSet.clear();
                Set<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                if(tempSet.size() > 0 && (maxKey == null || tempSet.size() > maxTemp)){
                    maxKey = key;
                    maxTemp = tempSet.size();
                }
            }
            if(maxKey != null){
                selects.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));
                broadcasts.remove(maxKey);
            }
        }
        return selects;
    }
}
