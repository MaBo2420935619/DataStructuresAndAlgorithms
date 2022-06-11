package com.mabo.queue;

public class QueueTest<T>{
    private T[] arr=(T[]) new Object[10];
    private int head;
    private int end;
    public void push(T val) {
        if((end-head)==arr.length) {
            T[] brr=(T[]) new Object[arr.length*2];
            for(int i=head;i<end;i++) {
                brr[i%brr.length]=arr[i%arr.length];
            }
            arr=brr;
        }
        arr[end % arr.length]=val;
        end++;
    }
    public void pop() {
        if(head==end) {
            return;
        }
        System.out.println(arr[head%arr.length]);
        head++;
    }
    public static void main(String[] args) {
        QueueTest queue=new QueueTest();
        queue.push("1");
        queue.push("1");
        queue.push("1");
        queue.push("1");
        queue.push(1123);
        queue.push('c');
        queue.push("1");
        queue.push("1");
        queue.push("3");
        queue.pop();
        queue.pop();
        queue.pop();
        queue.push("2");
        queue.push("2");
        queue.push("2");
        queue.pop();

    }
}
