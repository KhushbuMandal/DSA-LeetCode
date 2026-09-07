class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        int n = nums.length;
        HashMap <Integer , Integer> mp = new HashMap<>();

        int cnt = 0;
        int sum = 0;

        mp.put(0 , 1);

        for (int i = 0 ; i < n ; i++) {

            sum += nums[i];
            
            int rem = sum % k;

            if (rem < 0) {
                rem += k;
            }

            cnt += mp.getOrDefault(rem , 0);
            

            mp.put(rem , mp.getOrDefault(rem , 0) + 1);

        }

        return cnt;
    }
}