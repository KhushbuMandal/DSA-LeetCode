class Solution {
    public String largestPalindromic(String num) {
        
        int n = num.length();

        int freq[] = new int[10];
        
        //Freq Count
        for (char ch : num.toCharArray()) {
            freq[ch - '0']++;
        }


        //left side banayege
        StringBuilder left = new StringBuilder();

        for (int digit = 9 ; digit >= 0 ; digit--) {

            // Don't put zero in left if there is no non-zero digit
            if (digit == 0 && left.length() == 0) {
                break;
            }

            // int pairs = freq[digit]/2;
            int pairs = freq[digit] / 2;

            for (int i = 0 ; i < pairs ; i++) {
                left.append((char) ('0' + digit));
            }

            freq[digit] %= 2;

        }

        // middle 
        int middle = -1;
        for (int digit = 9 ; digit >= 0 ; digit--) {
            if (freq[digit] > 0) {
                middle = digit;
                break;
            }
        }

        //left me koin value nhi hai
        if (left.length() == 0) {

            if (middle != -1) {
                return String.valueOf(middle);
            }

            return "0";

        }

        //Build ans
        StringBuilder ans = new StringBuilder();

        ans.append(left);

        if (middle != -1) {
            ans.append((char)('0'+ middle));
        }
        

        ans.append(new StringBuilder(left).reverse());

        return ans.toString();

        
    }
}