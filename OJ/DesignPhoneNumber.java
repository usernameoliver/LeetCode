import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
public class DesignPhoneNumber {
    private Set<Integer> set = new HashSet<>();
    private Iterator iter;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public DesignPhoneNumber(int maxNumbers) {
        for (int i = 0; i <= maxNumbers; i++) {
            set.add(i);
        }
        iter = set.iterator();
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (iter.hasNext()) {
        	System.out.println(iter.next());
            int nextNum = (int)iter.next();
            set.remove(nextNum);
            return nextNum;
        } 
        else    return -1;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return iter.hasNext();
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        set.add(number);
    }

    public static void main(String[] args) {
    	DesignPhoneNumber designer = new DesignPhoneNumber(5);
    	System.out.println(designer.get());

    }
}
