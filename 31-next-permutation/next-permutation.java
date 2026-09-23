class Solution {
    public void nextPermutation(int[] nums) {

        if (nums.length == 1)
            return;

        int index1 = -1;
        int index2 = -1;

        // Step 1: Find first decreasing element from right
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index1 = i;
                break;
            }
        }

        // If no decreasing element, array is in descending order
        if (index1 == -1) {
            reverse(nums, 0, nums.length - 1);
        } 
        else {

            // Step 2: Find element just greater than nums[index1]
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[index1]) {
                    index2 = i;
                    break;
                }
            }

            // Step 3: Swap
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;

            // Step 4: Reverse the part after index1
            reverse(nums, index1 + 1, nums.length - 1);
        }
    }

    // Reverse array from left to right
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}