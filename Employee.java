public class Employee {
    double calcSalary(double base){
        return base;
    }

    double calcSalary(double base, double bonus){
        return base+bonus;
    }

    double calcSalary(double base, double bonus, int extra){
        return base+bonus+(extra*20);
    }

}
