package seleniumconcepts;

public class WaitConcept {

	public static void main(String[] args) {
		//wait:
		//1. static : Thread.sleep(1000)
		//2. dynamic: timeout = 10
		//2.a: Implicitly Wait
		//2.b: Explicit Wait:
			//2.b.1: WebDriverWait(Class)
		    //2.b.2: FluentWait (Class)
		
		//WebDriverwait(C) --> extends --> FluentWait(C) --> implements --> Wait(I) ---> has Abstract method --> until(Method)
		//Fluentwait class implements Wait Abstract method from interface Wait.
		
		
		//CAse
		//Mix up implictly wait + explicitly wait together
		// it will add up and will increse total waiting time
		
		//never use implictly wait in framework
											
	}

}
