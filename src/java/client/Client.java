package client;

import base.TemplateMethodBase;
import impl.TemplateMethodImplementation;

public class Client {
	public static void main(String[] args) {
		TemplateMethodBase printer = new TemplateMethodImplementation();
		printer.print();
	}
}
