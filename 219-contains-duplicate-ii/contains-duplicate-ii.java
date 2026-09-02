class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;

        HashMap <Integer, Integer> mp = new HashMap<>();

        mp.put(nums[0] , 0);

        for (int i = 1 ; i < n; i++) {
            if (mp.containsKey(nums[i]) && Math.abs(i - mp.get(nums[i])) <= k) {
                return true;
            }

            mp.put(nums[i] , i);
        }

        return false;
        
    }
}