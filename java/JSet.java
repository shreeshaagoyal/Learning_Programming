public class JSet {
    JMap map = new JMap();
    public void add(String key) {
        map.set(key, 0);
    }
    public boolean contains(String key) {
        if(map.get(key) == 0) {
            return true;
        } else {
            return false;
        }
    }
}