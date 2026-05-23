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

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            if (visited[i]) continue;
            List<String> actualGroup = new ArrayList<>();
            actualGroup.add(strs[i]);
            visited[i] = true;

            for (int j = i + 1; j < strs.length; j++) {
                if (visited[j]) continue;

                if (isAnagram(strs[i], strs[j])) {
                    actualGroup.add(strs[j]);
                    visited[j] = true;
                }
            }
            output.add(actualGroup);
        }
        
        return output;
    }
}