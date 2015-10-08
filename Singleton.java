
public class Singleton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static Singleton instance = null;
    public static Singleton getInstance() {
        // write your code here
    	if(instance == null){
    		synchronized(Singleton.class){
    			if(instance == null)
    				instance = new Singleton();
    		}
    	}
		return instance;

    }
}
