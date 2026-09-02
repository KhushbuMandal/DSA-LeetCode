class Solution {
    public boolean containsDuplicate(int[] nums) {

        int n = nums.length;

        HashMap <Integer , Integer> mp = new HashMap<>();

        for (Integer x : nums) {
            mp.put(x , mp.getOrDefault(x , 0) + 1);
        }

        for (Map.Entry<Integer , Integer> x : mp.entrySet()) {
            if (x.getValue() > 1) return true;
        }

        return false;
        
    }
}