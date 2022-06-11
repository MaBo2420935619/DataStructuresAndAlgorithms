package com.mabo.queue;

import java.util.Date;

/**
 * @Author mabo
 * @Description   环形
 * 数组队列
 */

public class ArrayQueue<T> implements Queue<T>{
    int size=10;
    int front=0;
    int rear=0;
    T queue[] =(T[]) new Object[size];
    @Override
    public boolean full(){
        boolean b = (rear + 1) % size == front;
        if (b){
            System.out.println("队列已满");
        }
        return  b ;
    }
    @Override
    public boolean empty(){
        boolean b = front == rear;
        if (b){
            System.out.println("队列为空");
        }
        return b;
    }




    @Override
    public boolean add(T num) throws Exception {
        if (!full()){
            queue[rear]=num;
            System.out.println(num+"加入队列成功");
            rear=(rear+1)%size;
            show();
            return true;
        }
        else {
            throw new Exception(num+"加入队列失败");
        }
    }

    @Override
    public T remove() throws Exception {
        if (!empty()){
            T result=queue[front];
            front=(front+1)%size;
            System.out.println("获取数据成功"+result);
            show();
            return result;
        }
        else {
            throw new Exception("获取数据失败");
        }

    }
    @Override
    public void show(){
        for (T a : queue) {
            System.out.print(a+" ");
        }
        System.out.println();
    }
    @Override
    public int getSize(){
        int i = (rear + size - front) % size;
        System.out.println("队列大小为"+i);
        return i;
    }

    public static void main(String[] args) {
        try {
            Date date = new Date();
            ArrayQueue<Object> arrayQueue=new ArrayQueue();
            arrayQueue.add(1);
            arrayQueue.add("1231");
            arrayQueue.add('c');
            arrayQueue.add(false);
            arrayQueue.add(date);
            int i = (int) arrayQueue.remove();
            String s = (String) arrayQueue.remove();
            char c = (char) arrayQueue.remove();
            boolean bool = (boolean) arrayQueue.remove();
            Date date1 = (Date) arrayQueue.remove();
            System.out.println(i);
            System.out.println(s);
            System.out.println(c);
            System.out.println(bool);
            System.out.println(date1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
