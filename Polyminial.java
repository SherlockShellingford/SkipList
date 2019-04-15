import java.util.*;
public class Polyminial {
List<PolyTerm> pol;
public Polyminial(List<PolyTerm> lst) {
	pol=lst;
	Collections.sort(pol);
}
public Polyminial add(Polyminial other) {
	List<PolyTerm> ret=new LinkedList<PolyTerm>();
	for(int i=0;i<other.pol.size();++i) {
		for(int j=0;j<pol.size();++j) {
			if(pol.get(j).canAdd(other.pol.get(i))) {
				ret.add(pol.get(j).add(other.pol.get(j)));
				break;
			}
		}
	}
	return new Polyminial(ret);
}
public Polyminial mul(Polyminial other) {
	List<PolyTerm> ret=new LinkedList<PolyTerm>();
	for(int i=0;i<other.pol.size();++i) {
		for(int j=0;j<pol.size();++j) {
			if(pol.get(j).canAdd(other.pol.get(i))) {
				boolean added=false;
				PolyTerm toAdd=pol.get(j).add(other.pol.get(j));
				for(int m=0;m<ret.size();++m) {
					
					if(ret.get(m).canAdd(toAdd)) {
						ret.get(m).add(toAdd);
						added=true;
						break;
					}
				}
				if(!added) {
					ret.add(toAdd);
				}
				
				break;
			}
		}
	}
	Collections.sort(ret);
	return new Polyminial(ret);
}
public Scalar evaluate(Scalar s) {
	if(pol.isEmpty()) {
		return null;
	}
	Scalar ret=pol.get(0).evaluate(s);
	for(int i=1;i<pol.size();++i) {
		ret.add(pol.get(i).evaluate(s));
	}
	return ret;
}
public Polyminial derivate() {
	List<PolyTerm> ret=new LinkedList<PolyTerm>();
	for(int i=0;i<pol.size();++i) {
		if(pol.get(i).getExponent()!=0) {
			ret.add(pol.get(i).derivate());
		}
		
	}
	return new Polyminial(ret);
	
	
	
}
public boolean equals(Polyminial other) {
	for(int i=0;i<other.pol.size();++i) {
		boolean notequal=true;
		for(int j=0;j<pol.size();++j) {
			if(pol.get(j).equals(other.pol.get(i))) {
				notequal=false;
			}
		}
		if(notequal) {
			return false;
		}
		
	}
	return true;
}

public String toString() {
	
	if(pol.isEmpty()) {
		return "";
	}
	String ret=pol.get(0).toString();
	for(int i=1;i<pol.size();++i) {
		String addString=pol.get(i).toString();
		if(!addString.contains("-")) {
			ret+="+";
		}
		ret+=addString;
	}
	return ret;
}
public List<PolyTerm> getPol(){
	return this.pol;
}
public void setPol(List<PolyTerm> npol) {
	this.pol=npol;
}
}
