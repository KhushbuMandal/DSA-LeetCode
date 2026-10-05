class Solution {

    // First index j such that nums[j] > target
    private int upperBound(int[] nums, long target) {

        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {

            int mid = lo + (hi - lo) / 2;

            if (nums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }


    public int[] kthRemainingInteger(int[] nums, int[][] queries) {

        int n = nums.length;
        int q = queries.length;

        int[] ans = new int[q];

        // prefixEven[i] = number of even numbers
        // in nums[0 ... i-1]
        int[] prefixEven = new int[n + 1];

        for (int i = 0; i < n; i++) {

            prefixEven[i + 1] = prefixEven[i];

            if (nums[i] % 2 == 0) {
                prefixEven[i + 1]++;
            }
        }


        for (int i = 0; i < q; i++) {

            int li = queries[i][0];
            int ri = queries[i][1];
            long k = queries[i][2];


            // Binary search for answer
            long lo = 2;

            // First k + n even numbers are enough.
            // At most n numbers can be removed.
            long hi = 2L * (k + n);


            while (lo < hi) {

                long mid = lo + (hi - lo) / 2;


                // Total even numbers <= mid
                long totalEven = mid / 2;


                // Find how many nums elements are <= mid
                int pos = upperBound(nums, mid) - 1;


                // Count removed even numbers
                // inside nums[li ... ri]
                long removedEven = 0;

                if (pos >= li) {

                    int right = Math.min(pos, ri);

                    removedEven =
                        prefixEven[right + 1] - prefixEven[li];
                }


                // How many even numbers <= mid
                // are still remaining?
                long remaining = totalEven - removedEven;


                if (remaining >= k) {
                    // mid can be the answer
                    hi = mid;
                } else {
                    // Need a bigger number
                    lo = mid + 1;
                }
            }

            ans[i] = (int) lo;
        }

        return ans;
    }
}