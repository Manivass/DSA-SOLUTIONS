class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord))
            return 0;
        int count = 1;
        Queue<String> q = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();
        q.offer(beginWord);
        visited.add(beginWord) ;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String str = q.poll();
                if (str.equals(endWord))
                    return count;
                char[] arr = str.toCharArray() ;
                for( int j = 0 ; j < arr.length ; j++ ) {
                    char original = arr[j] ;
                    for( char ch = 'a' ; ch <= 'z' ; ch++ ) {
                        if( ch == original ) continue ;
                        arr[j] = ch ;
                        String newStr = new String(arr) ;
                        if( !visited.contains(newStr) && set.contains(newStr) ) {
                            q.offer(newStr) ;
                            visited.add(newStr) ;
                        }
                    }
                    arr[j] = original ;
                }
            }
            count++ ;
        }
        return 0 ;
    }
}