package com.mabo.test;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Test {


    public static void main(String[] args) {
        List list=new LinkedList();
        Date date = new Date();
        list.add(date);
        list.add(123);
        System.out.println(list);
        list.remove(date);
        System.out.println(list);
    }
}
