package com.example.basic.object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 
 */
public class CloneMe {
	public static void main(String[] args) {
		Student s1 = new Student(1,"Kunal",null); 
		System.out.println(s1.hashCode());
		Student s2 = new Student(1,"Rahul", Arrays.asList()); 
		System.out.println(s2.hashCode());
		Student s3 = s2.clone();
		System.out.println(s3.hashCode());
	}
}

class Student implements Cloneable {
	
	int rollNumber;
	String name;
	List<Subject> subjects;
	
	public Student(int rollNumber, String name, List<Subject> subjects) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
		this.subjects = subjects;
	}
	
    public Student clone() {
        try {
        	Student s = (Student) super.clone();
            s.name = name;
            s.rollNumber = rollNumber;
            if ( this.subjects == null ) return s;
            s.subjects = (List<Subject>) new ArrayList<>(this.subjects).clone();
            return s;
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError(e);
        }
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rollNumber != other.rollNumber)
			return false;
		if (subjects == null) {
			if (other.subjects != null)
				return false;
		} else if (!subjects.equals(other.subjects))
			return false;
		return true;
	}

	class Subject {
		String subject;
		public Subject(String name) {
			this.subject = name;
		}
	} 
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + rollNumber;
		result = prime * result + ((subjects == null) ? 0 : subjects.hashCode());
		return result;
	}
}
