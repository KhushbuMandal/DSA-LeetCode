class Solution {
    public int longestSubstring(String s, int k) {

        int n = s.length();

        int maxLen = 0;

        for (int i = 0 ; i < n ; i++) {

            int freq[] = new int[26];

            for (int j = i ; j < n ; j++) {

                char c = s.charAt(j);
                freq[c - 'a']++;

                boolean valid = true;
                for (int v = 0 ; v <= 25 ; v++) {
                    if (freq[v] > 0 && freq[v] < k) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    maxLen = Math.max(maxLen , j - i + 1);
                }

            }

        }

        return maxLen;
        
    }
}