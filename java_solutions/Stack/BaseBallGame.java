package java_solutions.Stack;
import java.util.Stack;

public class BaseBallGame {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < operations.length; i++) {
            String op = operations[i];

            if (op.equals("C")) {
                
                stack.pop();
            } else if (op.equals("D")) {
                
                int last = stack.peek();
                stack.push(last * 2);
            } else if (op.equals("+")) {
                
                int last = stack.pop();
                int secondLast = stack.peek();
                int newScore = last + secondLast;
                
                stack.push(last);
                stack.push(newScore);
            } else {
                
                int val = Integer.parseInt(op);
                stack.push(val);
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

}


    
