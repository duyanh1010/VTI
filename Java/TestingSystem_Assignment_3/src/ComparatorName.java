import java.util.Comparator;

public class ComparatorName implements Comparator<Department>{

	
	

	@Override
	public int compare(Department d1, Department d2) {
		if(d1==null) {
			return -1;
		}
		
		if(d2==null) {
			return 1;
		}
		return d1.name.compareTo(d2.name);
	}

	

}
