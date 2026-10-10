class Solution {
    public int[] sortedSquares(int[] nums) {

        int n = nums.length;
        int i = 0;
        int j = n-1;

        int k = j;

        int[] newL = new int[n];
        
        while (i <= j) {

            int i2 = nums[i]*nums[i];
            int j2 = nums[j]*nums[j];

            if (i2 > j2) {
                newL[k--] = i2;
                i++;
            }
            else  {
                newL[k--] = j2;
                j--;
            }
        }

        return newL;
        
    }
}