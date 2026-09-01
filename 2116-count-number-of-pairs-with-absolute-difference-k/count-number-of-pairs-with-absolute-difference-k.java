class Solution {
    public int countKDifference(int[] nums, int k) {

        int n = nums.length;

        int count = 0;

      //  (a-b) = k  a=k+b    -(a-b) = k   -a+b = k  -a = k-b
        HashMap <Integer , Integer> mp = new HashMap<>();

        for (int i = 0 ; i < n ; i++) {

            int r1 = k + nums[i];

            if (mp.containsKey(r1)) {
                count += mp.get(r1);
            }

            int r2 = -(k - nums[i]);

            if (mp.containsKey(r2)) {
                count += mp.get(r2);
            }

            mp.put(nums[i] , mp.getOrDefault(nums[i] , 0) + 1);

        }

        return count;
        
    }
}