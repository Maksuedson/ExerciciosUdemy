package testejava;

import java.util.ArrayList;
import java.util.List;

public class Sparkles {

	static void nullify(List list) {
		list = null;
	}

	public static void main(String[] args) {
		List sparkles = new ArrayList();
		nullify(sparkles);
		System.out.println(sparkles.get(0));

	}
}
