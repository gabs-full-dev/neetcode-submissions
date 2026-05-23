class Solution {
    public boolean isAnagram(String s, String t) {
        String[] sChars = s.split("");
        String[] tChars = t.split("");

        if (sChars.length != tChars.length) return false;

        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String sChar : sChars) {
            if (!map.containsKey(sChar)) {
                map.put(sChar, 1);
            } else {
                map.put(sChar, map.get(sChar) + 1);
            }
        }

        for (String tChar : tChars) {
            if (!map.containsKey(tChar)) {
                return false;
            } else {
                map.put(tChar, map.get(tChar) - 1);
            }
        }

        String[] mergedArray = Stream.concat(
            Arrays.stream(sChars), 
            Arrays.stream(tChars)
        ).toArray(String[]::new);

        String[] distinctValues = Arrays.stream(mergedArray).distinct().toArray(String[]::new);

        for (String value : distinctValues) {
            Integer mapValue = map.get(value);

            if (mapValue != 0) return false;
        }

        return true;
    }
}