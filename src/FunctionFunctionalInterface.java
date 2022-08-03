import java.util.function.Function;

public class FunctionFunctionalInterface {
	public void shouldConvertANumberAsStringToIntegerUsingFunctionsWithAnonymousClass() throws Exception {
		Function<String, Integer> convertToInteger = new Function<String, Integer>() {

			@Override
			public Integer apply(String numberAsString) {
				return Integer.valueOf(numberAsString);
			}
		};
		
		Integer number = convertToInteger.apply("10");
	}
	
	public void shouldConvertANumberAsStringToIntegerUsingFunctionsWithLambdaExpression() throws Exception {
		Function<String, Integer> convertToInteger = numberAsString -> Integer.valueOf(numberAsString);
		
		Integer number = convertToInteger.apply("10");
	}
	
	public void shouldConvertANumberAsStringToIntegerAndMultiplyItUsingAnonymousClass() throws Exception {
		Function<String, Integer> convertToInteger = new Function<String, Integer>() {

			@Override
			public Integer apply(String numberAsString) {
				return Integer.valueOf(numberAsString);
			}
		};
		
		Function<Integer, Integer> multiplyBy10 = new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer number) {
				return number * 10;
			}
		};
		
		Integer number = convertToInteger.andThen(multiplyBy10).apply("10");
	}
	
	public void shouldConvertANumberAsStringToIntegerAndMultiplyItByUsingLambdaExpression() throws Exception {
		Function<String, Integer> convertToInteger = numberAsString -> Integer.valueOf(numberAsString);
		
		Function<Integer, Integer> multiplyBy10 = number -> number * 10; 
			
		Integer number = convertToInteger.andThen(multiplyBy10).apply("10");
	}
}
