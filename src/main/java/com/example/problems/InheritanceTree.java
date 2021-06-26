package com.example.problems;

public class InheritanceTree {
	
	public void print() { System.out.println("A");}
	public void print(int a) { System.out.println("A");}

	public static void main(String[] args) {
		InheritanceTreeB b = new InheritanceTreeB();
		InheritanceTreeC c = new InheritanceTreeC();
		//b = c;
		b.print(new Integer(1));
		b.print(1);
	}
	
}

class InheritanceTreeB extends InheritanceTree{
	public void print() { System.out.println("B");}
	public void print(Integer a) { System.out.println("B");}
}

class InheritanceTreeC extends InheritanceTree{
	public void print() { System.out.println("C");}
}


