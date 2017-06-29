package Aufgabe1;

import static org.junit.Assert.*;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Aufgabe3.StringIterator;
import turban.utils.ReflectionUtils;

public class TestAnnotation {

		List<String> _methodnames;
		
		@Before
		public void before() {
			_methodnames = ReflectionUtils.getMethodNamesWithAnnotation(MyAnnotatedClass.class, (Class<? extends Annotation>) MyAnnotaion.class);
		}

		@Test
		public void test1() {
			assertEquals("war erfolgreich", "method1", _methodnames.get(0));
		}
		
		@Test
		public void test2() {
			assertEquals("war erfolgreich", "method2", _methodnames.get(1));
		}
		
		@Test
		public void test3() {
			assertEquals("war erfolgreich", 2, _methodnames.size());
			assertTrue("war erfolgreich", _methodnames.contains("method1"));
			assertTrue("war erfolgreich", _methodnames.contains("method2"));
		}
		//		private void AssertEquals(String string, boolean b,
		//		Class<MyAnnotatedClass> class1) {
		//	// TODO Auto-generated method stub
		//	
		//}
		
		/*public void getNamevonMethode(){
			MyAnnotatedClass myClass = new MyAnnotatedClass();
			List<String> methodnams = ReflectionUtils.getMethodNamesWithAnnotation(MyAnnotatedClass.class, MyAnnotaion.class);
			
			for(int i=0; i<methodnams.size(); i++){
				System.out.println(methodnams.get(i));
			}
		}
		*/
		@Test
		public void testStringIterator() {
			List <String> list = new ArrayList<String>();
			list.add("Hallo");
			list.add("Hey!");
			StringIterator s1 = new StringIterator(list);
			int index = 0;
			for(String str : s1){
				assertTrue("", str.equals(list.get(0)) || str.equals(list.get(1)));
				index++;
			}
			
			assertEquals("mehr oder weniger als Schleifen Durchgänge!", 2, index);
		}
		//public static void main(String [] args){
			//TestAnnotation annotation = new TestAnnotation();;
			//annotation.getNamevonMethode();
			//List<String> methodnames = ReflectionUtils.getMethodNamesWithAnnotation(MyAnnotatedClass.class, MyAnnotaion.class);
			//System.out.println(methodnames);
			
			
		//}


}
