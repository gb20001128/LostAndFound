package com.clj.dataSources;

import com.clj.domain.Item;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @Description
 * @Author gb
 * @Data 2022/8/17 23:37
 */


public class DataItem {


    public static ArrayList<Item> list=new ArrayList<>();
    

    static {
        Item item1 = new Item();
        item1.setPlace("教二302");
        item1.setNumber("18373848273");
        item1.setContent("今天中午在教二302拾到一个棕色钱包，里面若干张纸币和一串钥匙");
        item1.setPhotoName("1.png");
        SimpleDateFormat formatter1= new SimpleDateFormat("yyyy年MM月dd日-HH时mm分");
        Date date1 = new Date();
        String time1 = formatter1.format(date1);
        item1.setTime(time1);


        Item item2 = new Item();
        item2.setPlace("一食堂二楼鸡公煲");
        item2.setNumber("1386378641");
        item2.setContent("晚上在食堂捡到一张水卡，刘**同学看到尽快联系我");
        item2.setPhotoName("2.png");
        SimpleDateFormat formatter2= new SimpleDateFormat("yyyy年MM月dd日-HH时mm分");
        Date date2 = new Date();
        String time2 = formatter2.format(date2);
        item2.setTime(time2);


        Item item3 = new Item();
        item3.setPlace("行政中心");
        item3.setNumber("15184728493");
        item3.setContent("快认领，这是谁的手机，小灵通牌的");
        item3.setPhotoName("3.png");
        SimpleDateFormat formatter3= new SimpleDateFormat("yyyy年MM月dd日-HH时mm分");
        Date date3 = new Date();
        String time3 = formatter3.format(date3);
        item3.setTime(time3);





        Item item = new Item();
        item.setPlace("南二门");
        item.setNumber("19183483824");
        item.setContent("南二门无意发现一万块钱，谁的？");
        item.setPhotoName("money.png");

        item.setTime("2022年08月18日-19时10分");

        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item);

    }




}
