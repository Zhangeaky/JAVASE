package test.collecttion.priorityqueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Person{

    Person(int age){
        this.age = age;
    }
    int age;
}
class intComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
}
public class demo {

    public static void main(String[] args) {

        PriorityQueue<Person> priorityQueue = new PriorityQueue<>(new personComparator());
        PriorityQueue<Person> priorityQueue1 = new PriorityQueue<>(10, new personComparator());
        PriorityQueue<Integer> nums  = new PriorityQueue<>(10);
        //add 方法 就是将offer方法进行了封装 本质 same
        priorityQueue.add(new Person(10));
        priorityQueue.offer(new Person(2));
        priorityQueue.add(new Person(8));
        priorityQueue.add(new Person(4));

        //poll 方法
        System.out.println("-----poll-----");
        nums.add(5);
        nums.add(6);
        nums.add(3);
        nums.add(11);
        System.out.println("peek "+nums.peek());
        nums.poll();
        nums.forEach(System.out::println);

        System.out.println("-----poll-----");



        System.out.println("size: "+priorityQueue.size());

        System.out.println("top: "+priorityQueue.peek());

        priorityQueue.forEach(System.out::println);

        PriorityQueue<Integer> bigrootQuere = new PriorityQueue<>(new intComparator());

        bigrootQuere.add(3);
        bigrootQuere.add(7);
        bigrootQuere.add(5);
        bigrootQuere.add(1);
        bigrootQuere.add(12);
        bigrootQuere.add(20);


        System.out.println(" 大根堆 ");
        bigrootQuere.forEach(System.out::println);






    }



}


class personComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.age-o2.age;
    }
}

class test{

    public static void main(String[] args) {
        //比较器的使用
        Person[] persons = {new Person(1),new Person(23),new Person(10)};
        Arrays.sort(persons,new personComparator());

        for(int i = 0; i < persons.length; i++){

            System.out.print(persons[i].age+" ");

        }




    }

}
