class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean isEWA = false ;
        for( String str : wordList ) {
            if( str.equals(endWord) ) {
                isEWA = true ;
                break ;
            }
        }
        if( !isEWA ) return 0 ;
        Queue<String> q = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();
        q.offer(beginWord);
        visited.add(beginWord);
        int count = 1 ;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String str = q.poll();
                if( str.equals(endWord) ) return count ;
                for (String sub : wordList) {
                    if( visited.contains(sub) ) continue ;
                    int diff = 0;
                    for (int j = 0; j < sub.length(); j++) {
                        if (sub.charAt(j) != str.charAt(j))
                            diff++;
                        if (diff > 1)
                            break;
                    }
                    if (diff == 1) {
                        q.offer(sub);
                        visited.add(sub);
                    }
                }
            }
            count++ ;
        }
        return 0 ;
    }
}