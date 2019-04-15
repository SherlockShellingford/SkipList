public interface Scalar {
    Scalar add(Scalar toAdd);

    Scalar pow(int exp);

    Scalar mul(Scalar toMul);

    Scalar neg(Scalar toNeg);

    boolean equals(Scalar toCom);
}
