public class GenericStackTest {

	public static void main(String[] args) {
		GenericStack<String> gsString = new GenericStack<>(2);
		gsString.push("one");
		gsString.push("two");
		gsString.push("three");
		System.out.println(gsString);
		System.out.println("peek is: " +  gsString.peek());
		while (!(gsString.isEmpty())) {
			System.out.println("pop:" + gsString.pop());
			System.out.println(gsString);
		}

		
		GenericStack<Integer> gsInteger = new GenericStack<>(2);
		gsInteger.push(1);
		gsInteger.push(2);
		gsInteger.push(3);
		//gsInteger.push("4");
		System.out.println(gsInteger);
		System.out.println("peek is: " + gsInteger.peek());
		while (!(gsInteger.isEmpty()))
		   System.out.println("pop:" + gsInteger.pop());
		System.out.println(gsInteger);
	}
}
