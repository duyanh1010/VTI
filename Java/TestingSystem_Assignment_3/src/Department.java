
public class Department /*implements Comparable<Department>*/  {

	int id;
	java.lang.String name;
	//private Department department;

	@Override
	public java.lang.String toString() {
		java.lang.String result = "";
		result += "id: " + id + "\n";
		result += "name: " + name + "\n";
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Department department2=(Department) obj;
		if (obj == null) {
			return false;
		}
		if( name.equals(department2.name)) {
			return true;
		}
		return false;
	}


	
}
