package testejava;

public class MetodoMau {

	public static void main(String[] args) {
		try {
			System.out.println("A");
			badMethod();
			System.out.println("B");
		} catch (Exception ex) {
			System.out.println("C");
		} finally {
			System.out.println("D");
		}
	}

	private static void badMethod() {
		throw new Error();
		
	}

}
