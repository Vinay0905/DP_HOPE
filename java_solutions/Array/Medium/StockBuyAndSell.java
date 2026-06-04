package java_solutions.Array.Medium;
//121. Best Time to Buy and Sell Stock
public class StockBuyAndSell {
    // Tries every pair of buy and sell days where the sell day comes later.
    // The highest profit from all possible pairs is returned.
    public static int bruteForce(int[] prices){
        int maxProfit = 0;

        // Loop through each day as a potential buy day
        for (int i = 0; i < prices.length; i++) {
            // Loop through each future day as a potential sell day
            for (int j = i + 1; j < prices.length; j++) {
                // Calculate profit
                int profit = prices[j] - prices[i];

                // Update max profit if higher
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        // Return the maximum profit
        return maxProfit;
        
    }
    // Tracks the minimum price seen so far and computes profit for each selling day.
    // The best profit found during one left-to-right scan is returned.
    public static int optimalSolution(int[] arr){
        int profit=0,cost=0;
        int minimum=arr[0];
        int n=arr.length;
        for(int i=1;i<n;i++){
            cost=arr[i]-minimum;
            profit=Math.max(profit,cost);
            minimum=Math.min(minimum, arr[i]);
        }
        return profit;
    }
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(bruteForce(prices));
        System.out.println(optimalSolution(prices));
    }
}
