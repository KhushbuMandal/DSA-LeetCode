class Solution {
    public long maxSubarraySum(int[] nums, int k) {

        int n = nums.length;

        int maxLen = 0;
        HashMap <Integer , Long> mp = new HashMap<>();

        long sum = 0;
        long ans = Long.MIN_VALUE;

       // mp.put (0 , 1);
        mp.put(0 , 0L);

        for (int i = 1 ; i <= n ; i++) {

            sum += nums[i-1];

            int rem = i % k;

            if (mp.containsKey(rem)) {

                long candidate = sum - mp.get(rem);

                ans = Math.max (candidate , ans);

                mp.put (rem , Math.min(mp.get(rem) , sum));

            }else {
                mp.put (rem , sum);
            }
        }

        return ans;
        
    }
}