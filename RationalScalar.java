public class RationalScalar extends Scalar{

    private int den;
    private int num;

    public RationalScalar(int num, int den){
        int gcd = gcd(num, den);
        this.num = num/gcd;
        this.den = den/gcd;
        if (this.getDen()<0){
            this.setValue(this.getNum()*(-1), this.getDen()*(-1));
        }
    }

    Scalar add(Scalar toAdd){
        RationalScalar a = (RationalScalar)toAdd;
        int outNum = this.num*a.getDen()+a.getNum()*this.den;
        int outDen = this.den*a.getDen();
        RationalScalar out = new RationalScalar(outNum, outDen);
        int gcd = gcd(out.getNum(), out.getDen());
        out.setValue(out.getNum()/gcd, out.getDen()/gcd);
        if (a.getDen()<0){
            a.setValue(a.getNum()*(-1), a.getDen()*(-1));
        }
        return out;
    }

    Scalar pow(int exp){
        RationalScalar a = new RationalScalar(this.num,this.den);
        a.setValue((int)Math.pow((double)a.num, (double)exp), (int)Math.pow((double)a.den, (double)exp));
        return a;
    }

    Scalar mul(Scalar toMul){
        RationalScalar a = new RationalScalar(this.num,this.den);
        RationalScalar b = (RationalScalar)toMul;
        a.setValue(a.getNum()*b.getNum(), a.getDen()*b.getDen());
        int gcd = gcd(a.getNum(), a.getDen());
        a.setValue(a.getNum()/gcd, a.getDen()/gcd);
        if (a.getDen()<0){
            a.setValue(a.getNum()*(-1), a.getDen()*(-1));
        }
        return a;
    }

    Scalar neg(){
        RationalScalar a = new RationalScalar(this.num*(-1),this.den);
        if (a.getDen()<0){
            a.setValue(a.getNum()*(-1), a.getDen()*(-1));
        }
        return a;
    }

    boolean equals(Scalar toCom){
        RationalScalar b = (RationalScalar)toCom;
        return  (this.num == b.getNum() & this.den == b.getDen());
    }

    public int getDen(){
        return this.den;
    }

    public int getNum(){
        return this.num;
    }

    private int gcd(int num, int den){
        if (den == 0){
            return num;
        }
        return gcd(den, num % den);
    }

    public void setValue(int Num, int den) {
        this.num = num;
        this.den = den;
    }

    @Override
    public String toString() {
        String s = "";
        if (this.den == 1){
            return s + this.num;
        }
        return s + this.num + "/" + this.den;
    }
}
