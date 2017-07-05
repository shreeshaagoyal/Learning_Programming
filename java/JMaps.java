public class JMaps {
    List<Entry> entryList = new ArrayList<Entry>();
    public void set(String name, int num) {
        boolean match = false;
        for(int i = 0; i < this.entryList.size(); i++) {
            if(name == this.entryList.get(i).name) {
                // Replacing Entry
                this.entryList.get(i).keyValue = num;
                match = true;
                break;
            }
        }
        if(!match) {
            // Adding new Entry to back
            Entry newEntry = new Entry(name, num);
            this.entryList.add(newEntry);
        }
    }
    public int get(String name) {
        for(int i = 0; i < this.entryList.size(); i++) {
            if(name == this.entryList.get(i).name) {
                return entryList.get(i).keyValue;
                break;
            } else {
                throw new Exception("Key doesn't exist.");
            }
        }
    }
}