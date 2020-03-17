package stackAndQueue;

import org.junit.Test;

import java.util.Stack;

public class TwoStacksImplementsQueue {

    @Test
    public void test(){
        push(1);
        System.out.println(pop());
        push(1);
        push(2);
        System.out.println(pop());
        push(3);
        push(4);
        System.out.println(pop());
        System.out.println(pop());
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
       stack1.push(node);
    }

    public int pop() {
        if (stack1.empty())
            return 0;
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int res = stack2.pop();
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return res;
    }
}
