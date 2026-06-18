class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> r = new HashMap<>();
        HashMap<Character, Integer> m = new HashMap<>();

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            r.put(ch, r.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            m.put(ch, m.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : r.entrySet()) {
            char ch = entry.getKey();
            int freq = entry.getValue();

            if (m.getOrDefault(ch, 0) < freq) {
                return false;
            }
        }

        return true;
    }
}