public class TaxCalculator {
    double calcTax(int income){
        return income+0.15;
    }

    double calcTax(double dividends, double taxPercentage){
        return dividends*(taxPercentage/100);
    }

    double calcTax(int dividends, double taxPercentage, double exemption){
        double total = dividends*(taxPercentage/100);

        if(total > exemption){
            return total-exemption;
        }else{
            return 0;
        }
    }
}
