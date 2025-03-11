import java.time.LocalDate;

public class Person {
    private String name;
    private LocalDate birthDate;

    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public long getAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }
}
