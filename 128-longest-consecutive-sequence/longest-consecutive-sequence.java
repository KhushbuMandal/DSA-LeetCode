class Solution {
    public int longestConsecutive(int[] nums) {
        
        int n = nums.length;

        HashMap <Integer , Boolean> visited = new HashMap<>();
        HashMap <Integer , Boolean> present = new HashMap<>();

        for (Integer y : nums) {
            present.put(y , true);
        }

        int longestConsecutive = 0;

        for (Integer y : nums) {

            while (!visited.getOrDefault(y , false) && !present.getOrDefault(y-1 , false)) {

                int sequence = 0;
                int start = y;

                while (present.containsKey(start)) {

                    sequence++;
                    visited.put(start, true);
                    start++;

                }

                longestConsecutive = Math.max(longestConsecutive , sequence);

            }

        }

        return longestConsecutive;

    }
}