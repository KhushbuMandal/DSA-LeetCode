class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List <Integer> ans = new ArrayList<>();

        int wordLen = words[0].length();
        int wordCount = words.length;

        int totalCount = wordLen * wordCount;
        
        HashMap <String , Integer> required = new HashMap<>();

        for (int i = 0 ; i < words.length ; i++) {

            required.put(words[i] , required.getOrDefault(words[i] , 0) + 1);

        }

        for (int start = 0 ; start <= s.length() - totalCount ; start++) {

            HashMap <String , Integer> current = new HashMap<>();
 
            for (int j = 0 ; j < wordCount ; j++) {

                int index = start + j * wordLen;

                String word = s.substring(index, index + wordLen);

                current.put(word , current.getOrDefault(word , 0) + 1);
            }

            if (current.equals(required)){
                ans.add(start);
            }
        }

        return ans;
        
    }
}