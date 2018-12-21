package test;

public class Upper_Cast {
    public static void main(String[] args) {
        Wine a = new JNC();
        a.fun1();
        System.out.println(a.name);
    }
}
class Wine {
    public void fun1(){
        System.out.println("Wine Fun1.....");
        fun2();
        fun3();
    }
    
    public void fun2(){
        System.out.println("Wine Fun2...");
    }
    
    public static void fun3(){
        System.out.println("Wine Fun3...");
    }
    
    public String name = "Wine";
}


 class JNC extends Wine{
    /**
     * @desc Subclass reloads superclass
     *       After upcasting, superclass cannot access this method
     * @param str
     * @return void
     */
    public void fun1(String str){
        System.out.println("JNC Fun1...");
        fun2();
        fun3();
    }
    
    /**
     * Subclass override superclass
     */
    @Override
    public void fun2(){
        System.out.println("JNC Fun2...");
    }
    
    /**
     * Subclass cannot override static method in superclass
     * Before object instantiating period at runtime, memory used to
     * store static field has already been allocated while compiling java file
     * such memory cannot be overlapped, which is known as override
     */
    public static void fun3(){
        System.out.println("JNC Fun3...");
    }
    
    // String is a static class, cannot be overrding
    public String name = "JNC";
}
