package com.mabo.stack;
/**
 * @Author mabo
 * @Description   数组栈
 */
public class ArrayStack {

    private static final int SIZE=10;

    private int stack[]=new int[SIZE];

    private int top=-1;

    public int getSize(){
        return top+1;
    }
    public void push(int num) throws Exception {
        if (!full()){
            top++;
            stack[top]=num;
        }
        else {
            throw new Exception("栈已经满了");
        }
        show();
    }

    public int pop() throws Exception {
        if (!empty()){
            int a=stack[top];
            top--;
            show();
            return a;
        }
        else {
            throw new Exception("栈为空");
        }
    }

    public void show(){
        for (int i = 0; i <=top; i++) {
            System.out.print(stack[i]);
        }
        System.out.println();
    }
    public boolean full(){
        boolean b = (top == SIZE - 1);
        return b;
    }
    public boolean empty(){
       return top==-1;
    }
    public static void main(String[] args) {
        try {
            ArrayStack arrayStack = new ArrayStack();
            arrayStack.push(1);
            arrayStack.push(2);
            arrayStack.push(3);
            arrayStack.push(4);
            arrayStack.push(5);
            arrayStack.pop();
            arrayStack.pop();
            arrayStack.pop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
