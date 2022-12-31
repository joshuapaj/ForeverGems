public class Calculation extends Product{
    public double overhead(double materialcost1){
    double overheadf;
    double baseprice = materialcost1*4;
    double overhead = baseprice * .10;
    overheadf = baseprice+overhead; 
    return overheadf;
    }
    public double wage(double laborcost1,double hoursworked1){
    double laborcostf = laborcost1*hoursworked1;
    return laborcostf;
    }
    public double finalpriceR(double laborcostf, double overheadf){
    double finalpriceR = laborcostf+overheadf;
    return finalpriceR;
    }
    public double finalpriceW(double laborcostf,double overheadf){
    double finalpriceR = laborcostf+overheadf;
    double finalpriceW = finalpriceR/2;
    return finalpriceW;
    }
    }


