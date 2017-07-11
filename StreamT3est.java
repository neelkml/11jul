import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
public class StreamT3est {
public static void main(String args[]) {
	Person person=new Person("Ramu",21,Gender.MALE);
	Person person0=new Person("Samu",23,Gender.FEMALE);
	Person person1=new Person("Jamu",25,Gender.FEMALE);
	Person person2=new Person("Namu",27,Gender.FEMALE);
	List<Person> people=Arrays.asList(person,person0,person1,person2);
	/*Map<Integer,Person>map=
			people.stream()
			      .collect(Collectors.toMap((Person p)->p.getAge(),(Person p)->p));
	map.entrySet().forEach(System.out::println);*/ //it wil show error when duplicacy in name,age,gender will come.
	Map<Gender,List<Person>> mapWithNameKey=
			people.stream()
			.collect(Collectors.groupingBy(Person::getGender));
	mapWithNameKey.entrySet().forEach(System.out::println);
}
}
