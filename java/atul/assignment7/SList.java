//: atTl/assignment8/SList.java

import java.io.*;
import java.util.*;

class Link<T> {
        T item;
        Link<T> next = null;
        public Link(T item) {
                this.item = item;
        }
	public Link(T item, Link<T> next){
		this.item = item;
		this.next = next;
	}
	public String toString() {
		if(item==null)
			return "null";
		return item.toString();
	}
}
class SListIterator<T> {
	Link<T> current;
	SListIterator(Link<T> link) {
		current = link;
	}
	public boolean hasNext() {
		return current.next != null;
	}
	public Link<T> next() {
		current = current.next;
		return current;
	}
	public void insert(T item) {
		current.next = new Link<T>(item, current.next);
		current = current.next;
	}
	public void remove() {
		if(current.next != null) {
			current.next = current.next.next;
		}
	}
}
public class SList<T> {
	private Link<T> head = new Link<T> (null);
	public SListIterator<T> iterator() {
		return new SListIterator<T> (head);
	}
	public String toString(){
		if(head == null)
			return "[]";
		StringBuilder sb = new StringBuilder();
		sb.append("[");
	        SListIterator<T> it = this.iterator();
                while(it.hasNext()){
                        sb.append(it.next()+(it.hasNext()?",":""));
                }
		return sb+"]";
	}
	public static void main(String[] args) {
		SList<Integer> sList = new SList<Integer>();
		SListIterator<Integer> sListIter = sList.iterator();
		sListIter.insert(new Integer(4));
		sListIter.insert(new Integer(5));
		System.out.println(sList);
		SList<String> sList2 = new SList<String>();
		SListIterator<String> sList2Iter = sList2.iterator();
		sList2Iter.insert("Piri Piri");
		sList2Iter.insert("Gati");
		sList2Iter.insert("Riot");
		System.out.println(sList2);
		sListIter = sList.iterator();
		sListIter.remove();
		System.out.println(sList);
		sList2Iter = sList2.iterator();
		sList2Iter.next();
		sList2Iter.remove();
		System.out.println(sList2);
	}
}
