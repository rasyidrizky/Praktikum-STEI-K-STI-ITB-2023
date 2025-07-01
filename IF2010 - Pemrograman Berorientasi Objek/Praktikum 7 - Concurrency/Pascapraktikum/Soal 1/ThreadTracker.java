import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadTracker {
    public static final Set<Long> threadIds = ConcurrentHashMap.newKeySet();

    public static void mark() {
        threadIds.add(Thread.currentThread().getId());
    }
}