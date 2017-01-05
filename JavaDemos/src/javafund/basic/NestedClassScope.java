package javafund.basic;

public class NestedClassScope {
	    public int x = 1;      // outer class X

	    class InnerNested {
	        public int x = 5; // inner class X

	        void methodInFirstLevel(int x) {  // local args X
	            System.out.println("NestedClassScope.this.x = " + NestedClassScope.this.x);
	            System.out.println("this.x = " + this.x);
	            System.out.println("x = " + x);
	        }
	    }

	    public static void main(String... args) {
	    	NestedClassScope st = new NestedClassScope();
	    	NestedClassScope.InnerNested fl = st.new InnerNested();
	        fl.methodInFirstLevel(10);
	    }
	    
	    NestedClassScope instantiate() {
	    	NestedClassScope outObj = new NestedClassScope();
	    	NestedClassScope.InnerNested inObj = outObj.new InnerNested();
	    	return outObj;
	    }
}
