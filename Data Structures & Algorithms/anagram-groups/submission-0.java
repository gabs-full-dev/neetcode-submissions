class Solution {
    public boolean isAnagram(String[] values, String[] targets) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String value : values) {
            if (!map.containsKey(value)) {
                map.put(value, 1);
            } else {
                map.put(value, map.get(value) + 1);
            }
        }

        for (String target : targets) {
            if (!map.containsKey(target)) {
                map.put(target, -1);
            } else {
                map.put(target, map.get(target) - 1);
            }
        }

        String[] mergedArray = Stream.concat(
            Arrays.stream(values), 
            Arrays.stream(targets)
        ).toArray(String[]::new);

        String[] distinctValues = Arrays.stream(mergedArray).distinct().toArray(String[]::new);

        for (String value : distinctValues) {
            Integer mapValue = map.get(value);

            if (mapValue != 0) return false;
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
                String[] value = strs[i].split("");
                String[] target = strs[j].split("");

                if (isAnagram(value, target)) {
                    actualGroup.add(strs[j]);
                    visited[j] = true;
                }
            }
            output.add(actualGroup);
        }
        
        return output;
    }
}