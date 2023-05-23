public class IntegerPair<T> {
    private T leftNumber;
    private T rightNumber;
    public IntegerPair(T leftNumber, T rightNumber){
        this.leftNumber = leftNumber;
        this.rightNumber = rightNumber;
    }

    public T getLeftNumber() {
        return leftNumber;
    }

    public T getRightNumber() {
        return rightNumber;
    }
}
