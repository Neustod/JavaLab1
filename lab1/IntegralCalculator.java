package lab1;

/**
 *
 * @author User
 */
public class IntegralCalculator {
    
    public IntegralCalculator()
    {
        a = 0;
        b = 1;
        e = 0.1e+6;
    }
    
    public IntegralCalculator(double _a, double _b, double _e)
    {
        a = _a;
        b = _b;
        
        if (b < a)
        {
            double tmp = a;
            a = b;
            b = tmp;
        }
        
        e = _e;
    }
    
    private double e, a, b;
    
    public double E() { return e; }
    public double A() { return a; }
    public double B() { return b; }
    
    public void SetE(double e) {
        if (e == 0) return;
        this.e = Math.abs(e); 
    }
    
    public void SetArea(double _a, double _b) {
        a = _a; b = _b;
        
        if (b < a)
        {
            double tmp = a;
            a = b;
            b = tmp;
        }
    }
    
    public double F()
    {
        double result = 0;
        double lBound = a, rBound = a + e;
        
        while (rBound < b)
        {
            result += e * (Math.exp(-lBound) + Math.exp(-rBound)) / 2;
            
            lBound += e;
            rBound += e;
        }
        
        if (lBound < b) result += e * (Math.exp(-lBound) + Math.exp(-b)) / 2;
        
        return result;
    }
}
