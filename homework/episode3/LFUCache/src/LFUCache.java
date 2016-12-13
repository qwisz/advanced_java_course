import java.util.*;


/**
 * Created by Anton on 13.12.2016.
 */
public class LFUCache {

    private final int CAPACITY = 10;

    class Value {
        private long answer;
        private int frequency;

        Value(long answer) {
            this.answer = answer;
            this.frequency = 0;
        }

        Value(long answer, int frequency) {
            this.answer = answer;
            this.frequency = frequency;
        }

        public long getAnswer() {
            return answer;
        }

        public int getFrequency() {
            return frequency;
        }
    }

    private Map<Integer, Value> cache = new HashMap<>();

    public long calculate(int key) {
        return calculateWithCache(key);
    }

    private long calculateWithCache(int key){
        if (cache.containsKey(key)) {
            int f = cache.get(key).frequency++;
            long ans = cache.get(key).answer;
            cache.put(key, new Value(ans, f));
            return ans;
        }
        long ans = fib(key);
        if (CAPACITY < cache.size() + 1) {
            cache.remove(getMinFreq());
            cache.put(key, new Value(ans));
            return ans;
        }
        cache.put(key, new Value(ans));
        return ans;
    }

    private int getMinFreq(){
        int min = Integer.MAX_VALUE;
        int key = -1;
        for (Map.Entry<Integer, Value> item : cache.entrySet()) {
            if (item.getValue().getFrequency() < min) {
                min = item.getValue().getFrequency();
                key = item.getKey();
            }
        }
        return key;
    }

    private long fib(int n) {
        if (n == 1 || n == 2)
            return 1;
        return fib(n - 1) + fib(n - 2);
    }
}
