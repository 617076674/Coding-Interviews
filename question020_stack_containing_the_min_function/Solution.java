package question020_stack_containing_the_min_function;

import java.util.Stack;

/**
 * https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O(1)）。
 *
 * 运行时间：14ms。占用内存：9400k。
 */
public class Solution {
    private Stack<Integer> stack1 = new Stack<>();

    private Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
        if (stack2.isEmpty()) {
            stack2.push(node);
        } else {
            stack2.push(Math.min(node, stack2.peek()));
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}