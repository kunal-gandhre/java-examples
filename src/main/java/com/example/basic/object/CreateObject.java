package com.example.basic.object;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

public class CreateObject implements Cloneable, Serializable {

	private static final long serialVersionUID = -2944942439249240773L;

	String name;

	public static void main(String[] args) {

		try {
			// Using new keyword
			CreateObject l1 = new CreateObject();

			// Using newInstance()
			Class clazz = Class.forName("com.example.basic.object.CreateObject");
			CreateObject l2 = (CreateObject) clazz.newInstance();

			// clone() method
			CreateObject l3 = (CreateObject) l1.clone();

			// Deserilization
			CreateObject l4 = new CreateObject("Kunal");
			FileOutputStream file = new FileOutputStream("c://object.txt");
			ObjectOutputStream oos = new ObjectOutputStream(file);
			oos.writeObject(l4);
			oos.close();
			file.close();
			
			CreateObject l5;
            FileInputStream f = new FileInputStream("c://object.txt");
            ObjectInputStream ois = new ObjectInputStream(f);
            l5 = (CreateObject)ois.readObject();
            System.out.println(l5.name);
            
            // Reflection
            Constructor<CreateObject> constr = CreateObject.class.getDeclaredConstructor();
            CreateObject l6 = constr.newInstance();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	CreateObject() {
		super();
	}

	CreateObject(String name) {
		this.name = name;
	}

}
