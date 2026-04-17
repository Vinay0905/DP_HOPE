package java_solutions.Stack;
import java.util.Stack;

public class DailyTemperateure {
    
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && temperatures[i]>=temperatures[stack.peek()]){
            stack.pop();


            }
            if(!stack.isEmpty()){
                result[i]=stack.peek()-i;

            }
            stack.push(i);

        }
        return result;
        
    }
    public static void main(String[] args){
        DailyTemperateure solution = new DailyTemperateure();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solution.dailyTemperatures(temperatures);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }
}
