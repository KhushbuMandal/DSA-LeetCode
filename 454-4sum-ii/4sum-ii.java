class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int n = nums1.length;

        HashMap <Integer , Integer> mp = new HashMap<>();

        for (int k = 0 ; k < n ; k++) {

            for (int l = 0 ; l < n ; l++) {
                int sum = nums1[k] + nums2[l];
                mp.put(sum , mp.getOrDefault(sum , 0) + 1);
            }

        }

        int cnt = 0;

        for (int i = 0 ; i < n ; i++) {

            for (int j = 0 ; j < n ; j++) {

                cnt += mp.getOrDefault((-(nums3[i] + nums4[j])) , 0);
            }
        }

        return cnt;
        
    }
}