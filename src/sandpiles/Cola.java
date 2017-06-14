
package sandpiles;

import java.util.LinkedList;

public class Cola {
    private LinkedList cola = new LinkedList();
    
    public boolean esVacia(){
        return cola.isEmpty();
    }
    
    public void encolar(Object x){
        cola.addFirst(x);
    }
    
    public Object desencolar(){
        return cola.removeLast();
    }
}
