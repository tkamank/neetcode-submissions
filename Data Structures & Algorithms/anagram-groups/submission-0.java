class Solution {
    //HashMap where key is characterCount
    //Input: String[] 
    //Output: ArrayList<ArrayLists>
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hash = new HashMap<>();
        for (String s : strs) {
            int[] alpha = new int[26];
            for (char ch : s.toCharArray()) {
                alpha[ch - 'a']++;
            }
            String key = Arrays.toString(alpha);
            hash.putIfAbsent(key, new ArrayList<>());
            hash.get(key).add(s);
        }
        return new ArrayList<>(hash.values());

    }
}
