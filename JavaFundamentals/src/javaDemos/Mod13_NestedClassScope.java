package javaDemos;

public class Mod13_NestedClassScope {
	    public int x = 1;      // outer class X

	    class InnerNested {
	        public int x = 5; // inner class X

	        void methodInFirstLevel(int x) {  // local args X
	            System.out.println("NestedClassScope.this.x = " + Mod13_NestedClassScope.this.x);
	            System.out.println("this.x = " + this.x);
	            System.out.println("x = " + x);
	        }
	    }

	    public static void main(String... args) {
	    	Mod13_NestedClassScope st = new Mod13_NestedClassScope();
	    	Mod13_NestedClassScope.InnerNested fl = st.new InnerNested();
	        fl.methodInFirstLevel(10);
	    }
	    
	    Mod13_NestedClassScope instantiate() {
	    	Mod13_NestedClassScope outObj = new Mod13_NestedClassScope();
	    	Mod13_NestedClassScope.InnerNested inObj = outObj.new InnerNested();
	    	return outObj;
	    }
}
