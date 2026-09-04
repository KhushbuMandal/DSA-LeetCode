class Solution {
    public int longestPalindrome(String[] words) {
        
        HashMap<String, Integer> mp = new HashMap<>();

        for (String word : words) {
            mp.put(word, mp.getOrDefault(word, 0) + 1);
        }

        int len = 0;
        boolean flag = false;

        for (int i = 0; i < words.length; i++) {

            if (!mp.containsKey(words[i])) continue;

            if (words[i].charAt(0) != words[i].charAt(1)) {

                String s = "" + words[i].charAt(1) + words[i].charAt(0);

                if (mp.containsKey(s)) {

                    int pairs = Math.min(mp.get(s), mp.get(words[i]));
                    len += pairs * 4;

                    mp.remove(s);
                    mp.remove(words[i]);
                }

            } 
            else {

                int c = mp.get(words[i]);

                if (c % 2 == 0) {
                    len += c * 2;
                } 
                else {

                    if (!flag) {
                        len += c * 2;
                        flag = true;
                    } 
                    else {
                        len += (c - 1) * 2;
                    }
                }

                mp.remove(words[i]);
            }
        }

        return len;
    }
}