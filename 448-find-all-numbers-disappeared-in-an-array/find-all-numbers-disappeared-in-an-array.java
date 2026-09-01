class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;

        List <Integer> ans = new ArrayList<>();

        for (int i = 0 ; i < n ; i++) {

            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                int idx = nums[i] - 1;

                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
            }

        }

        for (int i = 0 ; i < n ; i++) {
            if (nums[i] != i + 1) {
                ans.add(i+1);
            }
        }


        return ans;
        
    }
}