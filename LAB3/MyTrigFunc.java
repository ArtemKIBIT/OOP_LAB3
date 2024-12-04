package LAB3;

public class MyTrigFunc implements Calculable {
    @Override
    public double calculate(double x) {
        return Math.sin(x) * Math.sin(x) - Math.cos(x);
    }
}
