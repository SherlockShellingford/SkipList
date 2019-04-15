
public class Polyterm {
private Scalar co;
private int exp;

public Polyterm(Scalar co, int exp) {
	this.co=co;
	this.exp=exp;
}
public boolean canAdd(Polyterm other) {
	if(this.exp==other.getExponent()) {
		return true;
	}
	return false;
}
public Polyterm add(Polyterm other) {
	if(!this.canAdd(other)) {
		return null;
	}
	return new Polyterm(this.co.add(other.co),this.exp);
	
}
public Polyterm mul(Polyterm other) {
	return new Polyterm(this.co.mul(other.co),this.exp+other.exp);
}
public Scalar evaluate(Scalar s) {
	return co.mul(s.pow(exp));
}

public Polyterm derivate() {
	return new Polyterm(this.co.mul(exp),exp-1);
}
public boolean equals(Polyterm other) {
	return this.co.equals(other.co)&&other.co==this.co;
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
}
