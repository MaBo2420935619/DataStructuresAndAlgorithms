package com.mabo.queue;
/**
 * @Author mabo
 * @Description   环形
 * 数组队列
 */

public class ArrayQueueTest {
    int size=5;
    int front=0;
    int rear=0;
    int queue[] = new int[size];

    boolean full(){
        boolean b = (rear + 1) % size == front;
        if (b){
            System.out.println("队列已满");
        }
        return  b ;
    }

    boolean empty(){
        boolean b = front == rear;
        if (b){
            System.out.println("队列为空");
        }
        return b;
    }

    boolean add(int num) throws Exception {
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

    int get() throws Exception {
        if (!empty()){
            int result=queue[front];
            front=(front+1)%size;
            System.out.println("获取数据成功"+result);
            show();
            return result;
        }
        else {
            throw new Exception("获取数据失败");
        }

    }

    void show(){
        for (int a : queue) {
            System.out.print(a+" ");
        }
        System.out.println();
    }

    int getSize(){
        int i = (rear + size - front) % size;
        System.out.println("队列大小为"+i);
        return i;
    }

    public static void main(String[] args) {
        try {
            ArrayQueueTest arrayQueue=new ArrayQueueTest();
            arrayQueue.add(1);
            arrayQueue.add(2);
            arrayQueue.get();
            arrayQueue.get();
            arrayQueue.add(1);
            arrayQueue.add(2);
            arrayQueue.getSize();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
