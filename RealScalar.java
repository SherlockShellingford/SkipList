public class RealScalar extends Scalar {

    private double value;

    public RealScalar(double value){
        this.value = value;
    }

    Scalar add(Scalar toAdd){
        RealScalar a = (RealScalar)toAdd;
        RealScalar out = new RealScalar(this.value + a.getValue());
        return out;
    }

    Scalar pow(int exp){
        RealScalar out = new RealScalar(this.value);
        out.setValue(Math.pow(out.getValue(), (double)exp));
        return out;
    }

    Scalar mul(Scalar toMul){
        RealScalar a = (RealScalar)toMul;
        RealScalar out = new RealScalar(this.value * a.getValue());
        return out;
    }

    Scalar mul(int toMul){
        RealScalar out = new RealScalar(this.value * toMul);
        return out;
    }

    Scalar neg(){
        RealScalar out = new RealScalar(this.value * (-1));
        return out;
    }

    boolean equals(Scalar toCom){
        RealScalar a = (RealScalar)toCom;
        return (this.value == a.getValue());
    }

    public double getValue(){
        return this.value;
    }

    public void setValue(double value){
        this.value = value;
    }

    @Override
    public String toString() {
        int a = (int)(this.value*1000);
        return "" + ((double)a)/1000;
    }
}
