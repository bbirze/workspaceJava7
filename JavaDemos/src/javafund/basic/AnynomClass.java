package javafund.basic;

public class AnynomClass {

	interface HelloWorld {
		public void sayHi();
	}

	public void sayHello() {

		class EnglishGreeting implements HelloWorld {
			public void sayHi() {
				System.out.println("Hi!");
			}
		}
		HelloWorld englishGreeting = new EnglishGreeting();

		HelloWorld spanishGreeting = new HelloWorld() {
			public void sayHi() {
				System.out.println("Hola!");
			}
		};
		englishGreeting.sayHi();
		spanishGreeting.sayHi();
	}

	public static void main(String[] args) {
		AnynomClass aObj = new AnynomClass();
		aObj.sayHello();
	}

}
