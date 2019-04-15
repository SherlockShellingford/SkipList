
public class PolyTerm implements Comparable {
private Scalar co;
private int exp;

public PolyTerm(Scalar co, int exp) {
	this.co=co;
	this.exp=exp;
}
public boolean canAdd(PolyTerm other) {
	if(this.exp==other.getExponent()) {
		return true;
	}
	return false;
}
public PolyTerm add(PolyTerm other) {
	if(!this.canAdd(other)) {
		return null;
	}
	return new PolyTerm(this.co.add(other.co),this.exp);
	
}
public PolyTerm mul(PolyTerm other) {
	return new PolyTerm(this.co.mul(other.co),this.exp+other.exp);
}
public Scalar evaluate(Scalar s) {
	return co.mul(s.pow(exp));
}

public PolyTerm derivate() {
	return new PolyTerm(this.co.mul(exp),exp-1);
}
public boolean equals(PolyTerm other) {
	return this.co.equals(other.co)&&other.co==this.co;
}
public String toString() {
	return ""+co.toString()+"*X^"+exp;
}
public Scalar getCoefficient() {
	return co;
}
public int getExponent() {
	return exp;
}
public void setCoefficient(Scalar s) {
	co=s;
}
public void setExponent(int e) {
	exp=e;
}
@Override
public int compareTo(Object o) {
	PolyTerm other=(PolyTerm)o;
	return this.exp-other.exp;
	
}
}
