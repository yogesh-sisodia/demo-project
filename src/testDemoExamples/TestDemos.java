package testDemoExamples;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.stream.Collectors;


class Employee {
    int empId;
    String name;
    String designation;

    Employee(int empId, String name, String designation) {
        this.empId = empId;
        this.name = name;
        this.designation = designation;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return empId == employee.empId &&
                Objects.equals(name, employee.name) &&
                Objects.equals(designation, employee.designation);
    }
}

public class TestDemos {

    public void checkStringEquality() {

        String s1 = "ABC";
        String s2 = new String("ABC");

        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);
    }

    public static void main(String args[]) {
        TestDemos obj = new TestDemos();
        //obj.checkStringEquality();
        //obj.egOnOptional();
        //obj.demosOnStream();
        //obj.checkPrimeNumber();
        //obj.copyOnWriteArrayList();
        obj.checkObjectsEqualityUsingEqualsMethod();
        obj.checkObjectsEqualityUsingComparator();
    }

    private void checkObjectsEqualityUsingComparator() {

        Employee emp1 = new Employee(101, "one", "employee");
        Employee emp2 = new Employee(102, "one", "employee");

        int result = Comparator.comparing(Employee::getEmpId)
                .thenComparing(Employee::getName)
                .thenComparing(Employee::getDesignation)
                .compare(emp1, emp2);

        if (result == 0) {
            System.out.println("Both are equals");
        } else {
            System.out.println("Both are not equals");
        }
    }

    private void checkObjectsEqualityUsingEqualsMethod() {

        Employee emp1 = new Employee(101, "one", "employee");
        Employee emp2 = new Employee(102, "one", "employee");

        if (emp1.equals(emp2))
            System.out.println("both are equals");
        else
            System.out.println("both are not equals");
    }

    private void copyOnWriteArrayList() {

        CopyOnWriteArrayList<String> list
                = new CopyOnWriteArrayList<>();

        // Initial Iterator
        Iterator itr = list.iterator();
        list.add("GfG1");
        list.add("GfG2");
        list.add("GfG3");

        System.out.println("List contains: ");
        while (itr.hasNext())
            System.out.println(itr.next());

        // iterator after adding an element
        itr = list.iterator();
        System.out.println("List contains:");
        while (itr.hasNext()) {
            list.remove(itr.hasNext());
            System.out.println(itr.next());
        }
        itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

    }

    private void checkPrimeNumber() {

        int num = 13;
        int count = 0;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        if (count > 0)
            System.out.println("\nNumber is not Prime");
        else
            System.out.println("\nNumber is Prime");

    }

    /*Consumer<String> removeElement = s -> {
        System.out.println(s + " " + lst.size());
        if (s != null && s.equals("A")) {
            lst.remove("D");
        }
    };*/

    private void egOnOptional() {

        String[] words = new String[10];
        //String word = words[5].toLowerCase(); // got nullpointerexception here
        Optional<String> optionalStr = Optional.ofNullable(words[5]);
        System.out.print(optionalStr);

    }

    private void demosOnStream() {

        List<String> lst = new ArrayList<>();
        lst.add("1");
        lst.add("abc");
        lst.add("3");

        var resultList = lst.stream()
                .filter(this::checkGivenValue)
                .collect(Collectors.toList());

        resultList.stream().forEach(System.out::println);

        resultList.stream().forEach(val -> System.out.println(val));

        resultList.stream().forEach(val -> {
            if (val.equalsIgnoreCase("abc"))
                System.out.println("matched with abc");
            else
                System.out.println("not matched with abc");
        });
    }

    private boolean checkGivenValue(String val) {
        if (val.equalsIgnoreCase("abc"))
            return true;
        else
            return false;
    }

}
