class Solution {
    public boolean validWindow(HashMap<Character, Integer> map, int k) {
        int tot = 0;
        int max = 0;
        for (int val : map.values()) {
            if (val > max)
                max = val;
            tot += val;
        }
        return tot - max <= k ;
    }

    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (validWindow(map, k)) {
                max = Math.max( max , j - i + 1 ) ;
                // System.out.println(ch+" --  " + max) ;
            }
            else {
                ch = s.charAt(i) ;
                map.put( ch , map.get(ch) - 1 ) ;
                i++ ;
            }
            j++ ;
        }
        return max ; 
    }
}