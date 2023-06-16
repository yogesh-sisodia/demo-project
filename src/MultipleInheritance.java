import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

interface AA {
    default void demoAA() {
        System.out.println("demoAA() called...");
    }

    public void print();
}

interface BB {
    public void print();
}

public class MultipleInheritance implements AA, BB {

    @Override
    public void demoAA() {
        System.out.println("demoAA() main class");
        AA.super.demoAA();

        List list = new ArrayList<>();
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");
        list.add("DDD");
        list.add("EEE");

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println("Element is : " + iterator.next());
            iterator.remove();
        }

    }

    void demoMain() {
        AA.super.demoAA();
    }

    @Override
    public void print() {
        System.out.println("print() main class");
        Integer array[] = {4,3,67,23,78};

        List<Integer> convertedArray = Arrays.stream(array).collect(Collectors.toList());
        var result = Arrays.stream(array).sorted().filter(val -> {
            if(val.equals(7));
            return false;
        });
        System.out.println("result : " + result.toString());
    }

    public static void main(String args[]) {
        MultipleInheritance obj = new MultipleInheritance();
        obj.print();
        //obj.demoAA();
        //AA.super.demoAA(); // compile time error
        //obj.demoMain();

        List<Integer> empList = new ArrayList<>();

        empList.add(111);
        empList.add(222);
        empList.add(333);

        var result = empList.stream().filter( val -> val >= 222).collect(Collectors.toList());
        System.out.println("result ------------- " + result);

        String s1 = "1234567";


    }
}
