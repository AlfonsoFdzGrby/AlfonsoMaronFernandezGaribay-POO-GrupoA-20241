public class Main {
    public static void main(String args[]) throws Exception {
        //R E C T A N G L E S
        Rectangle rect = new Rectangle();

        System.out.println("-----------------------------------------");
        System.out.println("R E C T A N G L E");
        System.out.println("-----------------------------------------");
        System.out.printf("Area of first triangle: %d", rect.calcArea(2, 4));
        System.out.printf("\nPerimeter of fist triangle: %d", rect.calcPer(2, 4));
        System.out.printf("\nArea of second triangle: %.3f", rect.calcArea(2.583, 4.213));
        System.out.printf("\nPerimeter of second triangle: %.3f\n", rect.calcPer(2.583, 4.213));

        //E M P L O Y E E
        Employee emp = new Employee();

        System.out.println("-----------------------------------------");
        System.out.println("E M P L O Y E E");
        System.out.println("-----------------------------------------");
        System.out.printf("Base Salary: $%.2f", emp.calcSalary(30000));
        System.out.printf("\nBase Salary with bonus: $%.2f", emp.calcSalary(30000,15.000));
        System.out.printf("\nBase Salary with bonus and extra time pay: $%.2f\n", emp.calcSalary(30000,15000,15));

        //T A X   C A L C U L A T O R
        TaxCalculator tax = new TaxCalculator();

        System.out.println("-----------------------------------------");
        System.out.println("T A X   C A L C U L A T O R");
        System.out.println("-----------------------------------------");
        System.out.printf("Income Only: $%.2f", tax.calcTax(20000));
        System.out.printf("\nDividends and Tax Percentage: $%.2f", tax.calcTax(1500250,16));
        System.out.printf("\nDividends, Tax Percentage and Excemption (Exemption < Tax): $%.2f", tax.calcTax(1500250,16,2000));
        System.out.printf("\nDividends, Tax Percentage and Excemption (Exemption > Tax): $%.2f", tax.calcTax(1500250,16,2000000));

    }
}