package mf.qcon.talk.example12;

import static mf.qcon.examples.example12.FluentEndoMonoid.*;

public class SalaryCalculator {

    // B = basic + 20%
    public double plusAllowance(double d) {
        return d * 1.2;
    }

    // C = B + 10%
    public double plusBonus(double d) {
        return d * 1.1;
    }

    // D = C - 30%
    public double plusTax(double d) {
        return d * 0.7;
    }

    // E = D - 10%
    public double plusSurcharge(double d) {
        return d * 0.9;
    }

    public double calculateImperative(double basic, boolean... bs) {
        double salary = basic;
        if (bs[0]) salary = plusAllowance(salary);
        if (bs[1]) salary = plusBonus(salary);
        if (bs[2]) salary = plusTax(salary);
        if (bs[3]) salary = plusSurcharge(salary);
        return salary;
    }

}
