public class house_robber {
    public static void main(String[] args) {

        int nums[] = { 2, 7, 9, 3, 1 };
        if (nums.length == 1) {
            System.out.println(nums[0]);
            return;
        }
        if (nums.length == 2) {
            System.out.println(Math.max(nums[0], nums[1]));
            return;
        }
        if (nums.length == 0) {
            System.out.println(0);
            return;

        }
        int dp[] = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);

        }

        System.out.println(dp[nums.length - 1]);

    }
}