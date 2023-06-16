import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

abstract interface Parent {
//    public void parentMethod();
}

@FunctionalInterface
interface Child extends Parent {
    public abstract int childMethod();
}

abstract class A {
    A() {
        System.out.println("A call");
    }

    int a;

    public abstract void print();
}

class B extends A {

    B() {
        super();
        System.out.println("B call");
    }

    @Override
    public void print() {
        System.out.println("print() call in B\n");
    }
}

class C extends A {
    C() {
        System.out.println("C call");
    }

    @Override
    public void print() {
        System.out.println("print() call in C\n");
    }
}

public class Demo {

    public static void main1(String args[]) {
        System.out.println("in main method 1");
        //A obj = new A(); throw an error, because we can't create of object of abstract class
        B obj1 = new B();
        obj1.print();
        C obj2 = new C();
        obj2.print();

//        String s1 = "1234567";
//        Integer


    }

    public static void main2(int args[]) {
        System.out.println("in main method 2");
    }

    static {
        B b = new B();
        b.print();
    }
}