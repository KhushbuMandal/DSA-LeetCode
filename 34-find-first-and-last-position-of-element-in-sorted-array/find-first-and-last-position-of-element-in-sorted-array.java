class Solution {
    public static int firstOccurence (int[] nums, int target) {

        int n = nums.length;

        int first = -1;

        int start = 0;
        int end = n-1;

        while (start <= end) {

            int mid = (start + end)/2;

            if (nums[mid] > target) {
                end = mid - 1;
            }else if (nums[mid] < target) {
                start = mid + 1;
            }else {
                first = mid;
                end = mid - 1;
            }

        }

        return first;

    }

    public static int lastOccurence (int[] nums, int target) {

        int n = nums.length;

        int last = -1;

        int start = 0;
        int end = n-1;

        while (start <= end) {

            int mid = (start + end)/2;

            if (nums[mid] > target) {
                end = mid - 1;
            }else if (nums[mid] < target) {
                start = mid + 1;
            }else {
                last = mid;
                start = mid + 1;
            }

        }

        return last;



    }

    public int[] searchRange(int[] nums, int target) {

        int fo = firstOccurence(nums , target);
        int lo = lastOccurence(nums , target);

        return new int[]{fo , lo};
        
    }
}