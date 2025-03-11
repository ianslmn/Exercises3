import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class People {
    private List<Person> persons = new ArrayList<>();

    public void addPerson(Person person) {
        persons.add(person);
    }

    public Person getYoungestPerson() {
        return persons.stream().min(Comparator.comparingLong(Person::getAge)).orElse(null);
    }

    public long getSumAges() {
        return persons.stream().mapToLong(Person::getAge).sum();
    }

    public long getMinimumAge() {
        return persons.stream().mapToLong(Person::getAge).min().orElse(0);
    }

    public double getAverageAge() {
        return persons.stream().mapToLong(Person::getAge).average().orElse(0);
    }
}
