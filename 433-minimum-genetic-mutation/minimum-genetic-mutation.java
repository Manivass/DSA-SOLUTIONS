class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (bank.length == 0)
            return -1;

        boolean isEV = false;

        for (String str : bank) {
            if (str.equals(endGene)) {
                isEV = true;
                break;
            }
        }

        if (!isEV)
            return -1;

        Queue<String> q = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();
        q.offer(startGene);
        visited.add(startGene);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String str = q.poll();
                if (str.equals(endGene))
                    return count;
                for (int j = 0; j < bank.length; j++) {
                    if (visited.contains(bank[j]))
                        continue;
                    
                int diff = 0;
                    for (int k = 0; k < bank[j].length(); k++) {
                        if (str.charAt(k) != bank[j].charAt(k))
                            diff++;
                        if (diff > 1) {
                            break;
                        }
                    }
                    if (diff == 1) {
                        q.offer(bank[j]);
                        visited.add(bank[j]);
                    }
                }
            }
            count++ ;
        }
        return -1 ;
    }
}