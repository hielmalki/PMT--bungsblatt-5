package Aufgabe3;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import Aufgabe1.MyAnnotaion;
import Aufgabe1.MyAnnotatedClass;
import Aufgabe1.TestAnnotation;
import turban.utils.ReflectionUtils;

public class StringIterator implements Iterable <String>{
	//String to iterate 
	private static final List<String> myStrings = new ArrayList<String>();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	//Constructor
	public StringIterator(List <String> string){
		//string = new ArrayList();
		//Collections.addAll(string, "Hallo", "How", "are", "you", "doing");
		myStrings.addAll(string);
	}
	
	//Constructor
		public StringIterator(String [] string){
			//string = new ArrayList();
			//Collections.addAll(string, "Hallo", "How", "are", "you", "doing");
			for(String str:string){
				myStrings.add(str);
			}
		}
	
	
	//Instanz
	@Override
	public Iterator<String> iterator() {
		return new MyIterator();
	}

	private class MyIterator implements Iterator<String>{
		
		private int _index = 0;

		@Override
		public boolean hasNext() {
			boolean temp;
			temp= this._index < StringIterator.myStrings.size();
				return temp;
			
		}

		@Override
		public String next() {
			if(hasNext()== false){
				throw new NoSuchElementException();
			}
			String result = StringIterator.this.myStrings.get(_index);
			_index++;
			return result;
		}
		
	}
	public static StringIterator annotation(){
		List<String> list = ReflectionUtils.getMethodNamesWithAnnotation(MyAnnotatedClass.class, (Class<? extends Annotation>) MyAnnotaion.class);
		StringIterator str = new StringIterator(list.toArray(new String[] {}));
		MyAnnotatedClass annotation = new MyAnnotatedClass();
		//annotation.method1withAnnotation();
		for(String string : str){
			try {
				ReflectionUtils.invokeSimpleMethod(annotation, string);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}return str;
	}
	public static void main(String [] args){
		StringIterator str = new StringIterator(myStrings);
		str.annotation();
		TestAnnotation str1 = new TestAnnotation();
		//str1.getNamevonMethode();
	}
}

	
