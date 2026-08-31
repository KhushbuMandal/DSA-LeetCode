class Solution {
    public List<String> commonChars(String[] words) {

        HashMap<Character, Integer> minFreq = new HashMap<>();

        // Initially every character ki frequency 1000
        for (char ch = 'a'; ch <= 'z'; ch++) {
            minFreq.put(ch, 1000);
        }

        // Har word ke liye
        for (int i = 0; i < words.length; i++) {

            HashMap<Character, Integer> freq = new HashMap<>();

            // Current word ki frequency count karo
            for (int j = 0; j < words[i].length(); j++) {

                char ch = words[i].charAt(j);

                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            }

            // Minimum frequency update karo
            for (char ch = 'a'; ch <= 'z'; ch++) {

                minFreq.put(
                    ch,
                    Math.min(
                        minFreq.get(ch),
                        freq.getOrDefault(ch, 0)
                    )
                );
            }
        }

        List<String> str = new ArrayList<>();

        // Answer create karo
        for (char ch = 'a'; ch <= 'z'; ch++) {

            while (minFreq.get(ch) > 0) {

                str.add(String.valueOf(ch));

                minFreq.put(ch, minFreq.get(ch) - 1);
            }
        }

        return str;
    }
}