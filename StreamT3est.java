import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
public class StreamT3est {
public static void main(String args[]) {
	List<Integer> numbers=Arrays.asList(1,2,3,4,5,6,7,8,9);
	/*Person person=new Person("Ramu",21,Gender.MALE);
	Person person0=new Person("Samu",23,Gender.FEMALE);
	Person person1=new Person("Jamu",25,Gender.FEMALE);
	Person person2=new Person("Namu",27,Gender.FEMALE);
	List<Person> people=Arrays.asList(person,person0,person1,person2);*/
	/*Map<Integer,Person>map=
			people.stream()
			      .collect(Collectors.toMap((Person p)->p.getAge(),(Person p)->p));
	map.entrySet().forEach(System.out::println);*/ //it wil show error when duplicacy in gender will come.
	/*Map<Gender,List<Person>> mapWithNameKey=
			people.stream()
			.collect(Collectors.groupingBy(Person::getGender));
	mapWithNameKey.entrySet().forEach(System.out::println); */
	
	System.out.println(numbers.stream()
			.filter(v->v>3)
			.filter(v->v%2==0)
			//.reduce((v,k)->v=v+k));
	        .reduce(0,(v,k)->v=v+k));
}
}
