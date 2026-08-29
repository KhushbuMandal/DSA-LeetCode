class Solution {
    public int longestSubstring(String s, int k) {

        int n = s.length();

        // prefix[i][j] =
        // frequency of character j in first i characters
        int[][] prefix = new int[n + 1][26];

        // Build prefix frequency
        for (int i = 0; i < n; i++) {

            // Copy previous frequencies
            for (int j = 0; j < 26; j++) {
                prefix[i + 1][j] = prefix[i][j];
            }

            // Add current character
            int index = s.charAt(i) - 'a';
            prefix[i + 1][index]++;
        }

        int maxLen = 0;

        // Try every substring
        for (int left = 0; left < n; left++) {

            for (int right = left; right < n; right++) {

                boolean valid = true;

                // Check all 26 characters
                for (int c = 0; c < 26; c++) {

                    int freq = prefix[right + 1][c]
                             - prefix[left][c];

                    if (freq > 0 && freq < k) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    maxLen = Math.max(
                        maxLen,
                        right - left + 1
                    );
                }
            }
        }

        return maxLen;
    }
}