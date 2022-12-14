import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerFunctionalInterface {
    
	public void shouldPrintATextByUsingConsumerWithoutLambdaExpression() throws Exception {
		Consumer<String> printIt = new Consumer<String>() {

			@Override
			public void accept(String guide) {
				System.out.println("Awesome Guide:" + guide);
			}
		};
		
		printIt.accept("Java 8");
	}
	
	public void shouldPrintATextByUsingConsumerWithLambdaExpression() throws Exception {
		Consumer<String> printIt = guide -> System.out.println("Awesome Guide:" + guide); 
		
		printIt.accept("Java 8");
	}
	
	public void shouldSendAnEmail() throws Exception {
		User javaWarrior = new User("java1@allra.com");
		User javaBrave = new User("java2@allra.com");
		User javaHipster = new User("java3@allra.com");
		
		List<User> javaFans = Arrays.asList(javaWarrior, javaBrave, javaHipster);
		
		javaFans.forEach(user -> EmailSender.sendFor(user));
	}
	
}

class EmailSender {
	
	public static void sendFor(User user) {
		System.out.println("Sending email to: " + user.getEmail());
	}
	
}

class User {
	
	private String email;

	public User(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
}
