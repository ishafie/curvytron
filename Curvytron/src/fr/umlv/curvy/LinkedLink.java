package fr.umlv.curvy;

public class LinkedLink <E>
{
	private Link<E> first;
	private int size;
	
	public LinkedLink()
	{
		this.size = 0;
	}
	
	public void add(E value)
	{
		first = new Link<E>(value, first);
		size++;
	}
	
	public boolean search(Snake snake)
	{
		Link<E> s;
		
		for (s = first; s != null; s = s.next)
		{	
			if (s.equals(snake))
				return (true);
		}
		return false;
	}
	
	public Object get(int index)
	{
		int i = 0;
		if (index < 0)
			throw new IllegalArgumentException("Index inferieur a 0 : " + index);
		else if (index >= size)
			throw new IllegalArgumentException("Index superieur a la taille du tableau : " + index);
		Link<E> s;
		for (s = first; i < index && s != null; s = s.next)
			i ++;
		return s.value;	
	}
	
	@Override
	public String toString()
	{
		Link<E> s = first;
		StringBuilder str = new StringBuilder();
		while (s != null)
		{
			str.append(s.toString());
			s = s.next;
		}
		return str.toString();
	}
}