class Solution {
    public int strStr(String haystack, String needle) {

        int n1 = haystack.length();
        int n2 = needle.length();

        int start = 0;

        if (n2 > n1) return -1;

        int j = 0;
        int i = 0;

        while (i < n1 && j < n2) {

            if (haystack.charAt(i) == needle.charAt(j)) {

                if (i - start + 1 == n2)
                    return start;

                j++;
                i++;

            } else {

                j = 0;
                start++;
                i = start;
            }
        }

        return -1;
    }
}