package mapas;

public class Pareja implements Comparable{
	String pal;
	Integer cnt;
	
	Pareja()
	{
	}
	
	public int compareTo(Object o)
	{
		Pareja p=(Pareja)o;
		if(this.cnt>p.cnt)
			return -1;
		else
		{
			if(this.cnt>p.cnt)
				return 1;
			else
				return 0;
		}
	}
}
