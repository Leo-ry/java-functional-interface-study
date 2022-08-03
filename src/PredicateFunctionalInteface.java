import java.util.function.Predicate;

public class PredicateFunctionalInteface {
    
	public void shouldCheckThatTheTextIsGreaterThan5UsingAnonymousClass() throws Exception {
		Predicate<String> greaterThan5 = new Predicate<String>() {

			@Override
			public boolean test(String text) {
				return text.length() > 5;
			}
		};
		
		boolean isGreaterThan5 = greaterThan5.test("Java 8 - Guide");
		
	}
	
	public void shouldCheckThatTheTextIsGreaterThan5UsingLambdaExpression() throws Exception {
		Predicate<String> greaterThan5 = text -> text.length() > 5; 
			
		boolean isGreaterThan10 = greaterThan5.test("Java 8 - Guide");
		
	}
	
	public void shouldCheckThatTheTextIsGreaterThan5AndNegateIt() throws Exception {
		Predicate<String> greaterThan5 = text -> text.length() > 5; 
		
		boolean isGreaterThan5 = greaterThan5.negate().test("Java 8 - Guide");
	}
	
	public void shouldCheckThatTheTextIsGreaterThan5AndLessThan10UsingAnonymousClass() throws Exception {
		Predicate<String> greaterThan5 = new Predicate<String>() {
			
			@Override
			public boolean test(String text) {
				return text.length() > 5;
			}
		}; 
		
		Predicate<String> lessThan10 = new Predicate<String>() {

			@Override
			public boolean test(String text) {
				return text.length() < 10;
			}
		};
		
		boolean isGreaterThan5AndLessThan10 = greaterThan5.and(lessThan10).test("Java 8");
	}
	
	public void shouldCheckThatTheTextIsGreaterThan5AndLessThan10UsingLambdaExpression() throws Exception {
		Predicate<String> greaterThan5 = text -> text.length() > 5;
		
		Predicate<String> lessThan10 = text -> text.length() < 10;

		boolean isGreaterThan5AndLessThan10 = greaterThan5.and(lessThan10).test("Java 8");
	}
}
