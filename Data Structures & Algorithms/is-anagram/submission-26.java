class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> sMap = new HashMap<Character, Integer>();
        Map<Character, Integer> tMap = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), 1 + sMap.getOrDefault(s.charAt(i), 0));
            tMap.put(t.charAt(i), 1 + tMap.getOrDefault(t.charAt(i), 0));
        }
        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            if (!entry.getValue().equals(tMap.get(entry.getKey()))) return false;
        }

        return true;
    }
}