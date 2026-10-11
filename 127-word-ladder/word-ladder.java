
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) return 0;

        Queue<String> q = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();

        q.offer(beginWord);
        visited.add(beginWord);

        int count = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {

                String str = q.poll();

                if (str.equals(endWord)) return count;

                char[] arr = str.toCharArray();

                for (int j = 0; j < arr.length; j++) {

                    char original = arr[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        if (ch == original) continue;

                        arr[j] = ch;

                        String sub = new String(arr);

                        if (set.contains(sub) && !visited.contains(sub)) {
                            q.offer(sub);
                            visited.add(sub);
                        }
                    }

                    arr[j] = original;
                }
            }

            count++;
        }

        return 0;
    }
}
