package Aufgabe1;

public class MyAnnotatedClass {
	@MyAnnotaion
	public void method1withAnnotation(){ System.out.println("Method: " + "method1withAnnotation" + "called"); }
	@MyAnnotaion
	public void method2withAnnotation(){ System.out.println("Method: " + "method2withAnnotation" + "called"); }
	// without Annotations
	public void method3withoutAnnotation(){ System.out.println("Method: " + "method3withoutAnnotation" + "called"); }
	// without Annotations
	public void method4withoutAnnotation(){ System.out.println("Method: " + "method3withoutAnnotation" + "called"); }
}