package context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum RunContext {
    RUN_CONTEXT;

    private final Map<String, Object> context = new ConcurrentHashMap<>();

    RunContext() {
    }

    public void deleteKey(String key) {
        key = wrapKey(key);
        context.remove(key);
    }

    public <T> void put(String key, T object) {
        key = wrapKey(key);
        context.put(key, object);
    }

    public Object get(String key) {
        key = wrapKey(key);
        Object object;
        try {
            object = context.get(key);
        } catch (NullPointerException e) {
            throw new RuntimeException("Key not found in context");
        }
        return object;
    }

    private String wrapKey(String key) {
        return Thread.currentThread().getId() + "_" + key;
    }
}
