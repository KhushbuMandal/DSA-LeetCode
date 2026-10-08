class Solution {
    static class Pair {

        int idx;
        int val;

        public Pair (int idx , int val) {

            this.idx = idx;
            this.val = val;

        }

        

    }
    public int[] twoSum(int[] nums, int target) {

        int n = nums.length;

        Pair[] pair = new Pair[n];
        for (int i = 0 ; i < n ; i++) {
            pair[i] = new Pair(i , nums[i]);
        }

        Arrays.sort(pair , (a,b) -> a.val - b.val);

        int i = 0;
        int j = n-1;

        while (i < j) {
            int sum = pair[i].val + pair[j].val;

            if (sum == target) {
                return new int[] {
                    pair[i].idx,
                    pair[j].idx
                };
            }else if (sum < target) {
                i++;
            }else {
                j--;
            }
        }
        
        return new int[]{-1 , -1};
    }
}