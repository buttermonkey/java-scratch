package client;

import base.TemplateMethodBase;
import impl.TemplateMethodImplementation;

import java.util.List;

public class Client {
	public static void main(String[] args) {
		TemplateMethodBase printer = new TemplateMethodImplementation();
		printer.print();


		List<Object> of = List.of();
		System.out.println(of.getClass());
		printer.print();
	}
}
