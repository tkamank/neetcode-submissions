class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        //HashMap Solution
        char[] sequence = s.toCharArray();
        char[] eval = t.toCharArray();
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
        for (char c : sequence) {
            if (hash.containsKey(c)) {
                hash.put(c, hash.get(c) + 1);
            } else {
                hash.put(c, 1);
            }
        }

        for (char d : eval) {
            if (!hash.containsKey(d)) {
                return false;
            } else {
                hash.put(d, hash.get(d) - 1);
                if (hash.get(d) < 0) {
                    return false;
                }
            }

        }
        return true;
    }
}