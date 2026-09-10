class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int cnt = 0; // store the count of majority element
        int element = nums[0];

        for (int i = 0; i < n ; i++){

            if (element == nums[i]) cnt++;
            else cnt--;

            if (cnt == 0){
                cnt = 1;
                element = nums[i];
            }
        }

        return element;
        
    }
}