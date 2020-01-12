public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public int hashCode() {
        int result = 13;
        result = 31 * result + hashCode(re);
        result = 31 * result + hashCode(im);
        return result;
    }

    private int hashCode(double value) {
        long l = Double.doubleToLongBits(value);
        return (int) (l ^ l >>> 32);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (!(obj instanceof ComplexNumber)) {
            return false;
        }
        ComplexNumber complexNumber = (ComplexNumber) obj;
        return this.re == complexNumber.re
                && this.im == complexNumber.im;
    }
}