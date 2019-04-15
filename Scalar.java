public abstract class Scalar {

    abstract Scalar add(Scalar toAdd);

    abstract Scalar pow(int exp);

    abstract Scalar mul(Scalar toMul);

    abstract Scalar neg();

    abstract boolean equals(Scalar toCom);
}
