import java.util.HashMap;
public class StringProblems {
    public static Character findFirstNonRepeated(String str) {
        HashMap carHash = new HashMap();
        Character c; // using Character class to pass to hashmap
        Integer intgr;
        int value = 0;

        // Scan str, build hashmap
        for(int i = 0; i < str.length(); i++) {
            c = new Character(str.charAt(i));
            intgr = (Integer) carHash.get(c);
            if(intgr == null) {
                carHash.put(c, new Integer(1));
            } else {
                carHash.put(c, new Integer(intgr.intValue() + 1));
            }
        }

        // Search hashmap in order of str
        for(int i = 0; i < str.length(); i++) {
            c = new Character(str.charAt(i));
            // *** HAVE TO CAST BECAUSE THE GET() METHOD RETURNS AN OBJECT
            if(((Integer) carHash.get(c)).intValue() == 1) {
                return c;
            }
        }
        return null;
    }

    public static String removeSpecifiedCharacters(String str, String remove) {
        HashMap<Character, Integer> carHash = new HashMap<Character, Integer>();
        StringBuffer strbuf = new StringBuffer(str);
        Character c;
        char scanRef;
        char printRef = strbuf.charAt(0);

        // scan remove, build hashmap
        for(int i = 0; i < remove.length(); i++) {
            c = new Character(remove.charAt(i));
            carHash.put(c, new Integer(1));
        }

        // scan str, remove characters
        int i = 0;
        while(i < strbuf.lenght()) {
            scanRef = strbuf.charAt(i);
            c = new Character(scanRef);
            if(carHash.get(c) == new Integer(1)) {
                int j = i;
                while(carHash.get(strbuf.charAt(j)) != null) {
                    printRef = strbuf.charAt(j+1);
                    j++;
                }
                strbuf.setCharAt(i, printRef);
            } else if(carHash.get(c) == null) {
                printRef = scanRef;
            }
            i++;
        }
        return strbuf.toString();
    }
}