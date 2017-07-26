import java.util.HashSet;

public class CTCIProblems {
    public static boolean checkPermutation(String str1, String str2) {
        HashSet<Character> charSet = new HashSet<Character>();
        if(str1.length() != str2.length()) {
            return false;
        }
        for(int i = 0; i < str1.length(); i++) {
            charSet.add(str1.charAt(i));
        }
        for(int i = 0; i < str2.length(); i++) {
            if(!charSet.contains(str2.charAt(i))) {
                return false;
            }
        }
        return true;
    }

/** Not space efficient */
    public static StringBuffer reverseString(StringBuffer strbuf) {
        StringBuffer newstr = new StringBuffer();
        for(int k = 0; k < strbuf.length(); k++) {
            newstr.append(' ');
        }
        int i = 0, j = strbuf.length()-1;
        while(i < strbuf.length()) {
            newstr.setCharAt(j, strbuf.charAt(i));
            i++; j--;
        }
        return newstr;
    }

    public static void urlify(StringBuffer strbuf, int length) {
        int scanCursor = length-1;
        int printCursor = strbuf.length()-1;
        for(int i = scanCursor; i >= 0; i--) {
            if(strbuf.charAt(scanCursor) != ' ') {
                strbuf.setCharAt(printCursor, strbuf.charAt(scanCursor));
                printCursor--;
            } else if(strbuf.charAt(scanCursor) == ' ') {
                strbuf.setCharAt(printCursor, '0');
                printCursor--;
                strbuf.setCharAt(printCursor, '2');
                printCursor--;
                strbuf.setCharAt(printCursor, '%');
                printCursor--;
            }
            scanCursor--;
        }
    }

    public static int returnKthToLast(Node head, int k) {
        Node startRef = head;
        Node endRef = head;
        for(int i = 0; i < k; i++) {
            endRef = endRef.next;
        }
        while(endRef != null) {
            endRef = endRef.next;
            startRef = startRef.next;
        }
        return startRef.value;
    }

    public static boolean validateBST(TreeNode n) {
        boolean leftValidation = false, rightValidation = false;
        /** Base case */
        if(n.left.left == null) {
            if(n.left.value < n.value) {
                return true;
            } else {
                return false;
            }
        }
        if(n.right.right == null) {
            if(n.right.value > n.value) {
                return true;
            } else {
                return false;
            }
        }

        /** Check if left subtree is a BST */
        leftValidation = validateBST(n.left);
        if(!leftValidation) {
            return false;
        }

        /** Check if right subtree is a BST */
        rightValidation = validateBST(n.right);
        if(!rightValidation) {
            return false;
        }

        /** Check if current tree is a BST */
        return leftValidation && rightValidation;
    }
    
    public static void main(String[] args) {
        System.out.println(checkPermutation("configuration", "guracntionfi"));
        StringBuffer strbuf = new StringBuffer("Mr John Smith    ");
        urlify(strbuf, 13);
        System.out.println(strbuf);
        LList sampleLinkedList = new LList(20);
        sampleLinkedList.addToBack(32);
        sampleLinkedList.addToBack(79);
        System.out.println(returnKthToLast(sampleLinkedList.head, 3));

        /** Testing JStack.java */
        System.out.println("Testing min::JStack.java");
        JStack sampleStack = new JStack(3);
        sampleStack.push(4);
        sampleStack.push(2);
        sampleStack.push(5);
        sampleStack.push(1);
        sampleStack.push(90);
        System.out.println(sampleStack.min());
        System.out.println(sampleStack.pop());
        System.out.println(sampleStack.pop());
        System.out.println(sampleStack.min());

        /** Testing validateBST */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(11);
        root.right.right = new TreeNode(13);
        System.out.println(validateBST(root));
    }

}