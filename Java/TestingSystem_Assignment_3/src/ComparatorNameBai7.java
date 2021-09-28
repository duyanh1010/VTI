import java.util.Comparator;

public class ComparatorNameBai7 implements Comparator<Department>{

	
	

	@Override
	public int compare(Department d1, Department d2) {
		int lIndex1=d1.name.lastIndexOf(" ");
		java.lang.String d11=d1.name.substring(lIndex1+1);
		int lIndex2=d2.name.lastIndexOf(" ");
		java.lang.String d22=d2.name.substring(lIndex2+1);
		if(d11==null) {
			return -1;
		}
		
		if(d22==null) {
			return 1;
		}
		return d11.compareTo(d22);
	}
}
