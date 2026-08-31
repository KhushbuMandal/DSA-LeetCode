class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();

        int start = 0;
        
        int longest = 0;
        Set <Character> st = new HashSet<>();

        for (int end = 0 ; end < n ; end++) {

            while (st.contains(s.charAt(end))){
                st.remove(s.charAt(start));
                start++;
            }

            st.add(s.charAt(end));
            longest = Math.max(longest , end - start + 1);

        }

        return longest;
        
    }
}