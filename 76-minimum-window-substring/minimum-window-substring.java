class Solution {
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int st = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        int formed = 0;
        int required = map.size();

        HashMap<Character, Integer> window = new HashMap<>();
        for (right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            if (map.containsKey(ch) && map.get(ch).equals(window.get(ch)))
                formed++;
            while (formed == required) {
                if (min > right - left + 1) {
                    min = right - left + 1;
                    st = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (map.containsKey(leftChar) && window.get(leftChar) < map.get(leftChar))
                    formed--;
                left++ ;

            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(st , st + min) ;
    }
}