import org.junit.*;

/**
 * Created by Anton on 23.12.2016.
 */
public class LFUCacheTest {

    private LFUCache<Integer> cache = new LFUCache<>();

    @Before
    public void clear() {
        cache.clear();
    }

    @Test
    public void addOneElement() {
        cache.add(5, 100);
        int i = cache.get(5);
        Assert.assertEquals("It will be true", 100, i);
    }

    @Test
    public void getLFUKey() {
        cache.add(0, 5);
        cache.add(1, 55);
        cache.add(2, 555);

        for (int i = 0; i < 33; i++) {
            if (i < 11)
                cache.get(0);
            if (i < 22)
                cache.get(1);
            if (i < 33)
                cache.get(2);
        }
        int k = cache.getLFUKey();
        Assert.assertEquals("k will be 0", 0, k);
    }
}
