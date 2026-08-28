class Solution {
    public String minWindow(String s, String t) {

        int[] need = new int[128];
        int[] window = new int[128];

        // Frequency of characters required from t
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int required = t.length();
        int formed = 0;

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            // Add current character to window
            window[c]++;

            // This occurrence satisfies a required character
            if (window[c] <= need[c]) {
                formed++;
            }

            // Window is valid
            while (formed == required) {

                // Update minimum window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // Remove left character
                char leftChar = s.charAt(left);
                window[leftChar]--;

                // Removing this character made window invalid
                if (window[leftChar] < need[leftChar]) {
                    formed--;
                }

                left++;
            }
        }

        // No valid window found
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLen);
    }
}
