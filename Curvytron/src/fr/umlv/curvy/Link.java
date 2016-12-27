package fr.umlv.curvy;

class Link<E>
{
	
	final E value;
	final Link<E> next;

	public Link(E value, Link<E> next)
	{
		this.value = value;
		this.next = next;
 	}
	
	@Override
	public boolean equals(Object o)
	{
		if (o instanceof Snake)
		{
			Snake s = (Snake)o;
			if (value instanceof Snake)
			{
				Snake s2 = (Snake)value;
				if (((int)s.getPosx() >= (int)s2.getPosx() - 2 && (int)s.getPosx() <= (int)s2.getPosx() + 2)
						&& ((int)s.getPosy() >= (int)s2.getPosy() - 1 && (int)s.getPosy() <= (int)s2.getPosy() + 2))
					return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString()
	{
		return value.toString() + "\n";
	}
	


}