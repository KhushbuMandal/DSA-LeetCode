class Solution {
    public int longestPalindrome(String s) {

        int n = s.length();

        HashMap <Character , Integer> mp = new HashMap<>();

        for (int i = 0 ; i < n ; i++) {
            char ch = s.charAt(i);
            mp.put (ch , mp.getOrDefault(ch , 0) + 1);
        }

        int len = 0;
        boolean flag = true;

        // for (int i = 0 ; i < n ; i++) {

        //     if (mp.get(s.charAt(i)) % 2 == 0) {
        //         len += mp.get(s.charAt(i));

        //         mp.remove(s.charAt(i));
        //     }else {
        //         int cnt = mp.get(s.charAt(i));

        //         if (flag == true) {
        //             len += cnt;
        //             flag = false;
        //         }else {
        //             len += (cnt - 1);
        //         }

        //         mp.remove(s.charAt(i));
        //     }
           
        // }

        for (char ch : mp.keySet()) {

            int cnt = mp.get(ch);

            if (cnt % 2 == 0) {
                len += cnt;
            }else {
                if (flag) {
                    len += cnt;
                    flag = false;
                }else {
                    len += (cnt - 1);
                }
            }

        }


        return len;
        
        
    }
}