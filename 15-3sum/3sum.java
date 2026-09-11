class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;

        HashSet <List<Integer>> ans = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);


        for (int i = 0 ; i < n ; i++) {

            int left = i + 1;
            int right = n - 1;

           // int sum = 0;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i] , nums[left] , nums[right]));
                    left++;
                    right--;
                }

                else if (sum < 0) {
                    left++;
                }
                else {
                    right--;
                }

            }
        }

        for (List<Integer> x : ans){
            res.add(x);
        }

        return res;
    }
}