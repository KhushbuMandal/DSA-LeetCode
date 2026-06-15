class Solution {
    public int[] twoSum(int[] nums, int target) {
         HashMap <Integer , Integer> hp =  new HashMap<>();

        for (int i = 0 ; i < nums.length ; i++) {
            int remaining = target - nums[i];

            if (hp.containsKey(remaining)){
                return new int[]{i , hp.get(remaining)};
            }

            hp.put(nums[i] , i);
        } 

        return new int[]{-1 , -1};
        
    }
}