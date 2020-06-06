import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class HelloOtus {
    public static void main(String... args) {
        Multimap<String, String> birthdayDates = ArrayListMultimap.create();

        birthdayDates.put("Alex", "24 april");
        birthdayDates.put("Nastya", "1 january");
        birthdayDates.put("Jacob", "31 may");

        System.out.println(birthdayDates);
    }
}
