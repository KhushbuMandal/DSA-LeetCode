class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        int n = s.length();

        int wordsLen = words[0].length();
        int wordsCount = words.length;

        int totalLength = wordsLen * wordsCount;

        HashMap <String , Integer> required = new HashMap<>();

        List <Integer> ans = new ArrayList<>();

        for (String word : words) {
            required.put(word , required.getOrDefault(word , 0) + 1);
        }

        for (int start = 0 ; start <= n - totalLength ; start++) {

            HashMap <String , Integer> current = new HashMap<>();

            for (int j = 0 ; j < wordsCount ; j++) {

                int idx = start + j * wordsLen;

                String curr = s.substring(idx , idx + wordsLen);

                current.put (curr , current.getOrDefault(curr , 0) + 1);
            }

            if (current.equals(required)) {
                ans.add (start);
            }

        }
        

        return ans;
    }
}