package hopoz;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class serialization_test {
    public static class Person implements Serializable {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Person person = new Person("John",21);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Person.ser"))){
            oos.writeObject(person);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
