package ss.week4;

import java.util.*;

public class MapUtil {
    public static <K, V> boolean isOneOnOne(Map<K, V> map) {

        Set<K> domain = new HashSet<>(map.keySet());
        Set<V> range = new HashSet<>(map.values());
        ArrayList<K> domainDup = new ArrayList<>(map.keySet());
        ArrayList<V> rangeDup = new ArrayList<>(map.values());

        return domain.size() == domainDup.size() && range.size() == rangeDup.size();
    }

    public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
        Set<V> mapRange = new HashSet<>(map.values());
        return range.equals(mapRange);
    }

    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
        Map<V, Set<K>> mapInverse = new HashMap<>();
        Set<K> domain = map.keySet();
        for (K key : domain) {
            V value = map.get(key);
            Set<K> returned = mapInverse.computeIfAbsent(value, k -> new HashSet<>());
            returned.add(key);
        }
        return mapInverse;
    }

    public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
        Map<V, K> mapInverse = new HashMap<>();
        Set<K> domain = map.keySet();
        mapInverse = (Map<V, K>) inverse(map);
        if (!isOneOnOne(mapInverse) && !isSurjectiveOnRange(mapInverse, domain)) {
            return null;
        }
        return mapInverse;
    }

    public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
        return g.keySet().containsAll(f.values());
    }

    public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        Map<K, W> composedMap = new HashMap<>();

         if (compatible(f, g)) {
             return composedMap;
         }
         return null;
    }
}
