package edu.neu.csye6200;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Demonstrate Java 8 Stream API
 * 
 * https://www.concretepage.com/java/jdk-8/java-8-stream-collect-example
 * 
 * @author danielgmp
 *
 */
public class DemoStreams {
	public static enum Gender {
		MALE, FEMALE
	}

	/**
	 * class SmallPerson
	 * use for sorting, nothing more
	 */
	private class InnerGuy {
		private String fName = "john";
		private String lName = "doe";
		private int age = 1;		
		private Gender gender = Gender.MALE;
		
		public InnerGuy(String fName, String lName, int age) {
			super();
			this.fName = fName;
			this.lName = lName;
			this.age = age;
		}

		public String getfName() {
			return fName;
		}

		public void setfName(String fName) {
			this.fName = fName;
		}

		public String getlName() {
			return lName;
		}

		public void setlName(String lName) {
			this.lName = lName;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public Gender getGender() {
			return gender;
		}

		public void setGender(Gender gender) {
			this.gender = gender;
		}

		public boolean sortByAge(InnerGuy o1, InnerGuy o2) {
			return o1.getAge() < o1.getAge();
		}
		
	
		public String toString() {
			return getfName() + " " + getlName() + ", age: " + getAge();
		}
	}
		public void demoMixedStream() {
		System.out.println(DemoStreams.class.getSimpleName() + ".demoMixedStream()");
		Stream.of(1,2,"buckle my shoe",3,4,"shut the door",5,6).forEach(System.out::println);
		System.out.println();
		Stream.of(1,2,"buckle my shoe",3,4,"shut the door",5,6).forEach(e -> System.out.print(e + ","));
		System.out.println();
	}
	
	public void arrayStream() {
		System.out.println(DemoStreams.class.getSimpleName() + ".arrayStream()");
		int numbers[] = {1,2,3,4,5,6,7};
		IntStream numberStream = Arrays.stream(numbers);
		// forEach closes stream:is terminal operation
//		numberStream.forEach(System.out::println);
		System.out.println();
		// forEach closes stream:is terminal operation
		numberStream.forEach(n -> System.out.print(n+","));
		System.out.println();
	}
	
	public void listSream() {
		System.out.println(DemoStreams.class.getSimpleName() + ".listSream()");
		List<String> l = new ArrayList();
		l.add("three");
		l.add("one");
		l.add("two");
		Stream<String> nameStreamFromCol = l.stream();
		nameStreamFromCol.forEach( System.out::println );
		// re-create Stream closed by forEach terminal operation
		nameStreamFromCol = l.stream();
//		nameStreamFromCol.forEach(s -> System.out.print(s + ","));
		nameStreamFromCol.filter( (s) -> s.startsWith("t") ).forEach(s -> System.out.print(s + ","));
		System.out.println();
	}
	
	public void filterSream() {
		System.out.println(DemoStreams.class.getSimpleName() + ".filterSream()");
		List<String> l = new ArrayList();
		l.add("three");
		l.add("one");
		l.add("two");
		Stream<String> nameStreamFromCol = l.stream();
		nameStreamFromCol.forEach(s -> System.out.print(s + ","));
		System.out.println();
		// re-create Stream closed by forEach terminal operation
		nameStreamFromCol = l.stream();
		nameStreamFromCol.filter( (s) -> s.startsWith("t") ).forEach(s -> System.out.print(s + ","));
		System.out.println();
 
		nameStreamFromCol = l.stream();
		nameStreamFromCol.anyMatch( (s) -> s.startsWith("t") );
		
		nameStreamFromCol = l.stream();
		nameStreamFromCol.noneMatch( (s) -> s.startsWith("t") );
		System.out.println();
	}
	
	public void fileStream() {
		System.out.println(DemoStreams.class.getSimpleName() + ".fileStream()");
		try {
			Files.list( new File( "." ).toPath() ).forEach( System.out::println );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void demoCount() {
		System.out.println(DemoStreams.class.getSimpleName() + ".demoCount()");
		{
			String[] names = { "Jen", "Zac", "Dan" };
			List<String> list = new ArrayList<>(Arrays.asList(names));
			long count = 0;
			String startingWith = "J";

			for (String name : list) {
				System.out.print(name +", ");
				if (name.startsWith(startingWith))
					++count;
			}

			System.out.println(" includes " + count + " name(s) starting with '" + startingWith +"'");
		}
		{
			String[] names = { "Jen", "Zac", "Dan" };
			List<String> list = new ArrayList<>(Arrays.asList(names));
			String startingWith = "J";
			
			long count =  list.stream()
					.filter(name -> name.startsWith(startingWith))
					.count();

			list.forEach(name -> System.out.print(name +", "));
			System.out.println(" includes " + count + " name(s) starting with '" + startingWith +"'");
		}
		{
			String[] names = { "Jen", "Zac", "Dan" };
			List<String> list = new ArrayList<>(Arrays.asList(names));
			String startingWith = "J";
			
			long count =  list.parallelStream()
					.filter(name -> name.startsWith(startingWith))
					.count();

			list.forEach(name -> System.out.print(name +", "));
			System.out.println(" includes " + count + " name(s) starting with '" + startingWith +"'");
		}
		{
			List<String> list = Arrays.asList("Jen", "Zac", "Dan");
			list.forEach(System.out::print);
			System.out.println(list.size() + " elements in above list.");
		}
	}
	
	/**
	 * showList generic method for numbered output of collections of various type elements
	 * 
	 * @param title		Output title string
	 * @param l			Collection for output
	 */
	public <T> void showList(String title, List<T> l) {
		System.out.println(l.size() + title);
		int i = 1;		// 1 based numbering of elements
		for (T n : l) {
			System.out.print(i + ". " + n + " ");
			i++;
		}
		System.out.println();
	}

	public void process(List<Integer> numbers) {
		System.out.println(DemoStreams.class.getSimpleName() + ".process()");
//		numbers.add(70);	// can't add to fixed size list backed by array
//		numbers.parallelStream()	// sort is funny
		numbers.stream()
		.map(n-> n*10)
//		.map(n-> n-3)
		.sorted()
		.forEach(n-> System.out.print(n +", "));
		System.out.println(numbers.size() + " elements in container");
	}

	/**
	 * https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
	 */
	public void demoSumSquares() {
		System.out.println(DemoStreams.class.getSimpleName() + ".demoSumSquares()");

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		Integer totalSum = numbers.stream()
		       .filter(n -> {
		                System.out.println("filtering " + n); 
		                return n % 2 == 0;
		              })
		       .mapToInt(n -> {
		                System.out.println("mapping " + n);
		                return n * n;
		              })
		       .limit(2)
		       .sum();
		System.out.println("DemoStreams.demoSumSquares() = " + totalSum);
	}

	/**
	 * https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
	 */
	public void demoReduceSquares() {
		System.out.println(DemoStreams.class.getSimpleName() + ".demoReduceSquares()");

		// https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		Integer totalSum = numbers.stream()
		       .filter(n -> {
		                System.out.println("filtering " + n); 
		                return n % 2 == 0;
		              })
		       .mapToInt(n -> {
		                System.out.println("mapping " + n);
		                return n * n;
		              })
		       .limit(2)
		       // (identity/default/init, accumulator algorithm)
		       .reduce(0, (a,b) -> a + b);
		System.out.println("DemoStreams.demoReduceSquares() = " + totalSum);
	}

	/**
	 * https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
	 */
	public void demoCollect() {
		System.out.println(DemoStreams.class.getSimpleName() + ".demoCollect()");
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		List<Integer> collectedTwoEvenSquares = 
		    numbers.stream()
		       .filter(n -> {
		                System.out.println("filtering " + n); 
		                return n % 2 == 0;
		              })
		       .map(n -> {
		                System.out.println("mapping " + n);
		                return n * n;
		              })
		       .limit(2)
		       .collect(Collectors.toList());
		System.out.println(DemoStreams.class.getName() + ".demoCollect() = " + collectedTwoEvenSquares);
	}

	public void demoBasicCollect() {
		System.out.println(DemoStreams.class.getSimpleName() + ".demoBasicCollect()");
		int[] ints = {1,2,3 };
		List<Integer> numbers =  Arrays.stream(ints).boxed().collect(Collectors.toList());
		numbers.forEach(n -> System.out.print(n+","));
		List<Integer> list = new ArrayList<>();
		Collections.addAll(list, Arrays.stream(ints).boxed().toArray(Integer[]::new));
		list.forEach(n -> System.out.print(n+","));
		System.out.println();
	}
	
	public void sortInnerGuy() {
		System.out.println(DemoStreams.class.getSimpleName() + ".sortInnerGuy()");
		{
			List<InnerGuy> list = new ArrayList<>();
			list.add(new InnerGuy("john", "adams", 72));
			list.add(new InnerGuy("ben", "franklin", 62));
			list.add(new InnerGuy("george", "washington", 69));
			list.stream().forEach(n -> System.out.print(n + ", "));
			System.out.println(list.size() + " unsorted elements in list");
			Collections.sort(list, Comparator.comparing(InnerGuy::getAge));
			list.stream().forEach(n -> System.out.print(n + ", "));
			System.out.println(" " + DemoStreams.class.getName() + " sortInnerPerson() - " + list.size()
					+ " age sorted elements in list");
		}
		{
			List<InnerGuy> list = new ArrayList<>();
			list.add(new InnerGuy("john", "adams", 72));
			list.add(new InnerGuy("ben", "franklin", 62));
			list.add(new InnerGuy("george", "washington", 69));
			list.stream().forEach(n -> System.out.print(n + ", "));
			System.out.println(list.size() + " unsorted elements in list");
			list.stream()
					// .sorted(Comparator.comparing(InnerGuy::getlName))
					.sorted(Comparator.comparing(InnerGuy::getfName))
					// .sorted(Comparator.comparing(InnerGuy::getAge))
					.forEach(n -> System.out.print(n + ", "));
			System.out.println(" " + DemoStreams.class.getName() + " sortInnerPerson() - " + list.size()
					+ " first name sorted elements in list");
		}
	}
	
	public void partitionStream() {
		System.out.println("\n\n" + DemoStreams.class.getSimpleName() + ".partitionStream()");
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
		int threshold = 3;
		Map<Boolean, List<Integer>> parts = numbers.stream().collect(Collectors.partitioningBy(n -> n > threshold ));
		System.out.println("Partition Numbers exceeding threshold of " + threshold + "\n"
				+ numbers + " => \n"
				+ "    True: " + parts.get(true) + " \n"
				+ "   False: " + parts.get(false) + "\n");
	}
	

	/**
	 * Count the number of prime numbers from specified MAX and below.
	 * 
	 * https://dzone.com/articles/think-twice-using-java-8
	 * 
	 * @param max	highest number, use this and all lower for range
	 * @return		number of prime numbers in range inclusive.
	 */
	private long countPrimes(int max) {
		return LongStream.range(1, max).parallel().filter(this::isPrime).count();
//	    return range(1, max).parallel().filter(this::isPrime).count();
	}
	
	/**
	 * is the supplied number a prime number (divisible only by itself and one).
	 * 
	 * https://dzone.com/articles/think-twice-using-java-8
	 * 
	 * @param n		number to determine if prime
	 * @return		true if n is a prime number
	 */
	private boolean isPrime(long n) {

	    return n > 1 && LongStream.rangeClosed(2, (long) Math.sqrt(n)).noneMatch(divisor -> n % divisor == 0);
//	    return n > 1 && rangeClosed(2, (long) sqrt(n)).noneMatch(divisor -> n % divisor == 0);

	}
	
	public boolean isRange6To12(int n) {
		return 6 <= n && n <= 12;
	}

//	private int countUnderAge(int maxAge) {
//		// this won't work
//		int count = IntStream.range(1, maxAge).parallel().filter(n <= maxAge).count();
//		System.out.print(count + " ");
//		return count;
//	}
	
	public void dayChildCareAgeGroups() {
		System.out.println("\n" + DemoStreams.class.getSimpleName() + ".dayChildCareAgeGroups()");
		

		List<Integer> ages = Arrays.asList(12,23,35,62,32, 12,48,26,40,29, 14,12,27,12, 63,34,53,41,30);
		System.out.println("Given the following " + ages.size() + " ages: ");
		ages.stream().forEach(n -> System.out.print(n + " "));
		System.out.println();
		
		List<Integer> maxAge = Arrays.asList(12,24,35,47,59);
		System.out.println("Arrange by age group WHERE: MAX age is: ");
		maxAge.stream().forEach(n -> System.out.print(n + " "));
		System.out.println();
		
		System.out.println(ages.size() + " Sorted ages: ");
		ages.stream().sorted().forEach(n -> System.out.print(n + " "));
		System.out.println();
		
		Predicate<Integer> agesOver6To12 = n -> 6 <= n && n <= 12;
		long underAge12Count = ages.stream().parallel().filter(agesOver6To12).count();
		System.out.print(underAge12Count + " ");
		
		Predicate<Integer> agesOver12To24 = n -> 12 < n && n <= 24;
		long underAge24Count = ages.stream().parallel().filter(agesOver12To24).count();
		System.out.print(underAge24Count + " ");
		
		Predicate<Integer> agesOver24To35 = n -> 24 < n && n <= 35;
		long underAge35Count = ages.stream().parallel().filter(agesOver24To35).count();
		System.out.print(underAge35Count + " ");
		
		Predicate<Integer> agesOver35To47 = n -> 35 < n && n <= 47;
		long underAge47Count = ages.stream().parallel().filter(agesOver35To47).count();
		System.out.print(underAge47Count + " ");
		
		Predicate<Integer> agesOver47To59 = n -> 47 < n && n <= 59;
		long underAge59Count = ages.stream().parallel().filter(agesOver47To59).count();
		System.out.print(underAge59Count + " ");
		
		Predicate<Integer> agesOver59 = n -> 59 < n ;
		long overAge59Count = ages.stream().parallel().filter(agesOver59).count();
		System.out.print(overAge59Count + " ");
		
		long totalCounts =  underAge12Count + underAge24Count + underAge35Count
				+ underAge47Count + underAge59Count + overAge59Count;
		System.out.print("= " + totalCounts);
		System.out.println();

//		maxAge.stream().forEach(this::countUnderAge);
//		this.countUnderAge(0);
		System.out.println("... done!");
		
	}
	
	public void collectStrings() {
		System.out.println("\n" + DemoStreams.class.getSimpleName() + ".collectStrings() ...");
		{
			List<String> list = new ArrayList<>(Arrays.asList("Kiwi","Apple","Cherry"));
			System.out.println(list.size() + " strings in list.");
			list.stream().forEach((s) -> System.out.print(s + " "));
			System.out.println();
			System.out.println("Natural Order Sort and collect Strings joining with delimiter \", \"");
			String collectedString = list.stream().sorted().collect(Collectors.joining(" > "));
			System.out.println(collectedString);
		}
		{
			List<String> list = new ArrayList<>(Arrays.asList("Kiwi","Apple","Cherry"));
			System.out.println(list.size() + " strings in list.");
			list.stream().forEach((s) -> System.out.print(s + " "));
			System.out.println();
			System.out.println("REVERSE Natural order Sort and collect Strings joining with delimiter \\\", \\\" prefix \\\"{ \\\" suffix \\\" }\\\"");
			String collectedString = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.joining(" < ", "{ ", " }" ));
			System.out.println(collectedString);
		}
		System.out.println("\n" + DemoStreams.class.getSimpleName() + ".collectStrings() ... done!");
	}

	public void collectNames() {
		System.out.println("\n" + DemoStreams.class.getSimpleName() + ".collectNames()");
		List<InnerGuy> innerGuys = Arrays.asList(new InnerGuy("john", "adams", 72), 
				new InnerGuy("ben", "franklin", 62),
				new InnerGuy("george", "washington", 69));
		
		System.out.print("InnerGuys: ");
		innerGuys.forEach(p -> System.out.print(p + "; "));
		System.out.println();
		
		System.out.print("InnerGuy First Names: ");
//		System.out.print("InnerGuy SORTED First Names: ");
		innerGuys.stream().map(InnerGuy::getfName).collect(Collectors.toList()).forEach(n -> System.out.print(n + ", "));
		System.out.println();
		
		System.out.print("InnerGuy Last Names: ");
//		System.out.print("InnerGuy SORTED Last Names: ");
		innerGuys.stream().map(InnerGuy::getlName).collect(Collectors.toList()).forEach(n -> System.out.print(n + ", "));
		System.out.println();

		// Other operations
		
		// Accumulate names into a TreeSet
	     Set<String> set = innerGuys.stream().map(InnerGuy::getfName).collect(Collectors.toCollection(TreeSet::new));

	     // Convert elements to strings and concatenate them, separated by commas
	     String joined = innerGuys.stream()
	                           .map(Object::toString)
	                           .collect(Collectors.joining(", "));

	     // Compute sum of ages of innerGuys
	     int total = innerGuys.stream()
	                          .collect(Collectors.summingInt(InnerGuy::getAge));

	     // Group innerGuys by age
	     Map<Integer, List<InnerGuy>> byAge
	         = innerGuys.stream()
	                    .collect(Collectors.groupingBy(InnerGuy::getAge));

	  // Compute sum of ages by Gender
	     System.out.println("InnerGuys Total Age by Gender: ");
	     Map<Gender, Integer> totalByGender
	         = innerGuys.stream()
	                    .collect(Collectors.groupingBy(InnerGuy::getGender,
	                                                   Collectors.summingInt(InnerGuy::getAge)));
	     System.out.println(totalByGender);
	     
	  // Partition students into passing and failing
	     System.out.print("InnerGuys under age 70: ");
	     Map<Boolean, List<InnerGuy>> underAge70 =
	         innerGuys.stream()
	                 .collect(Collectors.partitioningBy(s -> s.getAge() < 70)); //BUG
	     System.out.println(underAge70);
//	     underAge70.forEach(p -> System.out.print(p));
	     System.out.println();
	     
		System.out.println("\n ... collectNames() done!");
	}
	
	public void collectAcumulateNames() {
		System.out.println("\n" + DemoStreams.class.getSimpleName() + ".collectAcumulateNames()");
		
		List<String> names = Arrays.asList("Moe", "Larry", "Curley");
		
		String result = names.parallelStream().collect(StringBuilder::new,
				(response, element) -> response.append(" Stooge ").append(element),
				(response1, response2) -> response1.append(", ").append(response2.toString()) ).toString();
		
		System.out.println(result + "\n collectAcumulateNames() ...done!");
	}
	
	public void collectAcumulateIntegers() {
		System.out.println("\n" + DemoStreams.class.getSimpleName() + ".collectAcumulateIntegers()");
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		/**
		 *  collect(Supplier supplier, BiConsumer accumulator, BiConsumer combiner)
		 *  employs parallel streams.
		 *  
		 *  Where:
		 *  supplier:	creates container for accumulator to populate with stream elements.
		 *  				Populated container is eventually returned as result.
		 *  				Parallel stream calls supplier multiple times and combiner combines results.
		 *  accumulator:	Lambda expression add element to supplier container. 
		 *  combiner:	Lambda expression combines results from all parallel streams
		 */
		List <Integer> newNumbers = numbers.parallelStream().collect(ArrayList<Integer>::new, (response, element) -> response.add(10*element), (response1, response2) -> response1.add(response2.get(0)));

		System.out.print("Original numbers: ");
		numbers.forEach(n -> System.out.print(n + " "));
		System.out.println();

		System.out.print("Scaled (10x) newNumbers: ");
		newNumbers.forEach(n -> System.out.print(n + " "));
		System.out.println();

		System.out.println("collectAcumulateIntegers() ...done!");
	}
	
	public static void demo () {
		System.out.println("\n\t" + DemoStreams.class.getSimpleName() + ".demo()");
		DemoStreams obj = new DemoStreams();
		obj.demoMixedStream();
		obj.arrayStream();
		obj.listSream();
		obj.fileStream();
		obj.filterSream();
		obj.demoCount();
		obj.demoSumSquares();
		obj.demoReduceSquares();
		obj.demoBasicCollect();
		obj.demoCollect();
		obj.process(Arrays.asList(8,2,4,5,7,6,1,9,3));
		obj.sortInnerGuy();
//		obj.process(new ArrayList<Integer>(Arrays.asList(8,2,4,5,7,6,1,9,3)));
		obj.partitionStream();
		System.out.println(obj.countPrimes(25) + " prime numbers 25 and lower.");
		
		obj.dayChildCareAgeGroups();
		obj.collectStrings();
		obj.collectNames();
		obj.collectAcumulateNames();
		obj.collectAcumulateIntegers();
		
		System.out.println("\n ...done!");
	}
}