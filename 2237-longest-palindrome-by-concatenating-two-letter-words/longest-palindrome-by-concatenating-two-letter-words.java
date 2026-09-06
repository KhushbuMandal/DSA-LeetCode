class Solution {
    public int longestPalindrome(String[] words) {

        int n = words.length;

        HashMap <String , Integer> mp = new HashMap<>();

        for (int i = 0 ; i < n ; i++) {
            mp.put (words[i] , mp.getOrDefault(words[i] , 0) + 1);
        }

        int len = 0;
        boolean flag = true;

        // similar
        for (int i = 0 ; i < n ; i++) {

            if (!mp.containsKey(words[i])) continue;

            if (words[i].charAt(1) != words[i].charAt(0)) {

                String s = "";
                s += words[i].charAt(1);
                s += words[i].charAt(0);

                if (mp.containsKey(s)) {
                    int pairs = Math.min(mp.get(s), mp.get(words[i]));
                    len += pairs * 4;

                }
                mp.remove(words[i]);
                mp.remove(s);

            }else {

                int cnt = mp.get(words[i]);

                if (cnt % 2 == 0) {
                    len += cnt * 2;
                }
                else {
                    if (flag == true){
                        len += cnt * 2;
                        flag = false;
                    }else {
                        len += (cnt - 1) * 2;
                    }
                }

                mp.remove(words[i]);
            }

        }


        return len;

        
    }
}