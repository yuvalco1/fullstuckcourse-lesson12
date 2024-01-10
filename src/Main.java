import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {



public static void main(String[] args) {

    final String MALE = "male";
    final String FEMALE = "female";

// old way to implment the interface
//        Cat kitty = new Cat();
//        kitty.print();

// new way to implement the interface with Lambda
            printThing(() -> System.out.println("Meow!2"));


// or in better way:
            Printable catprint = () -> System.out.println("Meow!");
            Printable dogprint = () -> System.out.println("Woof!");

            printThing(catprint);
            printThing(dogprint);

            ArrayList<Integer> numbers = new ArrayList<Integer>();
            numbers.add(5);
            numbers.add(9);
            numbers.add(8);
            numbers.add(1);

            numbers.forEach(num -> System.out.println(num));
            numbers.replaceAll(n -> n + 5);
            numbers.forEach(num -> System.out.println(num));

            //Streams stuff - using the Person class above

            List<Person> personList = new ArrayList<Person>();
            personList.add(new Person("Arja", 10, FEMALE));
            personList.add(new Person("John", 15, MALE));
            personList.add(new Person("Ned", 30, MALE));
            personList.add(new Person("Sansa", 12, FEMALE));
            personList.add(new Person("Rob", 18, MALE));
            personList.add(new Person("Caitlyn", 29, FEMALE));


            //old way of filtering and printing
            List<Person> femalePersons = new ArrayList<>();
            for (Person person : personList) {
                if (person.gender.equals(FEMALE)) {
                    femalePersons.add(person);
                }
            }
            for (Person person : femalePersons) {
                System.out.println(person.name);
            }
    // new way using streams _added also sorting by name also using peek which does action and not ends the stream
    personList.stream()
            .filter(person -> person.gender.equals(FEMALE)).peek(person -> System.out.println(person.name))
            .sorted(Comparator.comparing(o -> o.name))
            .collect(Collectors.toList())
            .forEach(person -> System.out.println(person.name));

        }

        public static void printThing(Printable thing) {
            thing.print();
        }



    }
