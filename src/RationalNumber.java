

/**
 *
 * @author Eric Marble
 * 
 */
public class RationalNumber {
    //This is a class for a RationalNumber and some methods for typical
    //operations that might be performed on rational numbers.
       private int numerator;
       private int denominator;
    RationalNumber(double num, double denom){
        setNum(num);
        setDenom(denom);
    }
    private void setNum(double num){
        numerator = removeDecimals(num);
    }
    private void setDenom(double denom){
        denominator = removeDecimals(denom);
    }
    public int removeDecimals(double n){
         while (n % 1 != 0){
            n = n*10;
        }
        return (int)n;
    }
    public void printFraction(){
        System.out.println(numerator + "/" + denominator);
    }
    public void printDecimal(){
        System.out.println(numerator / denominator);
    }
    public void add(RationalNumber ratNum){
        if (ratNum.denominator == this.denominator){ this.numerator += ratNum.numerator;}
        else{
            this.denominator = ratNum.denominator * this.denominator;
            this.numerator -= ratNum.numerator * this.numerator;
        }       
    }
    public void subtract(RationalNumber ratNum){
        if (ratNum.denominator == this.denominator){ this.numerator -= ratNum.numerator;}
        else{
            this.numerator *= ratNum.denominator;
            ratNum.numerator *= this.denominator;
            this.denominator = ratNum.denominator * this.denominator;
            this.numerator = this.numerator - ratNum.numerator;
        }
    }
    public void multiply(RationalNumber ratNum){
        if(ratNum.denominator == this.denominator){this.numerator*= ratNum.numerator;}
        else{
            this.denominator = ratNum.denominator * this.denominator;
            this.numerator = ratNum.numerator * this.numerator;
        }   
    } 
    public void divide(RationalNumber ratNum){ //same operation as multiply, just use reciprocal
        this.multiply(ratNum.reciprocal());
    }
    public RationalNumber reciprocal(){
        RationalNumber rn = new RationalNumber(this.denominator, this.numerator);
        return rn;         
    }
    public void reduce(){
        if(this.numerator > 1){
            for(int i = 2; i<Math.sqrt(this.denominator); i++){
                if(this.numerator%i == 0 && this.denominator%i == 0){
                    this.numerator = this.numerator/i;
                    this.denominator = this.denominator/i;
                }
            }
        }
    }
    @Override
    public String toString(){
        return this.numerator + "/" + this.denominator;
                
    }
    
    
}
