
package falsepositionmethod;

import java.text.DecimalFormat;
import java.util.Scanner;

public class FalsePositionMethod {
    DecimalFormat df = new DecimalFormat("#.##");
    
    
    double function(double x){
    double value=(Math.pow(x,2))-x-2;
    return value;
    }
   
    double xroot(double upper, double fOFxl, double lower, double fOFxu){
    double calculate=Double.parseDouble(df.format(((upper*fOFxl)-(lower*fOFxu))/(fOFxl-fOFxu))) ;
    return calculate;
    }
    
    double errorCount(double presentValue, double pastValue){
    double error=((((presentValue-pastValue)/presentValue))*100);
    return error;
    }
    
    public static void main(String[] args) {
      FalsePositionMethod object=new FalsePositionMethod();
      
      Scanner sc=new Scanner(System.in);
      
      DecimalFormat df = new DecimalFormat("#.##");
     
        double upper;
        double lower;
        int iterationRange;
        double fOFxr;
        double fOFxl;
        double fOFxu;
        double xrValue=0;
        double errorCount;
        double pastXrvalue=0;
        int i;
        
    
        System.out.println("Enter Your Upper Value");
        upper=sc.nextDouble();
        
        System.out.println("Enter Your Lower Value");
        lower=sc.nextDouble();
        
        System.out.println("Enter The Limit Of Iteration You Want to Find");
        iterationRange=sc.nextInt(); 
        
        fOFxu=object.function(upper);
        System.out.println("f(xu): "+df.format(fOFxu));
        
        fOFxl=object.function(lower);
        System.out.println("f(xl): "+df.format(fOFxl));
       
        for(i=1; i<=iterationRange ; i++){
        if(fOFxu*fOFxl>0 || fOFxu*fOFxl==0){
         System.out.println("There is no root,itearation is not possible beacause two values are positive");
         break;
       }
       else if(fOFxu*fOFxl <0){
       System.out.println("iteration : "+i);
       xrValue=object.xroot(upper,fOFxl,lower,fOFxu);
       double presentXrvalue=xrValue;
       System.out.println("Xr Value :"+df.format(xrValue));
       fOFxr=object.function(xrValue);
       System.out.println("f(Xr):"+df.format(fOFxr));
       
       if(fOFxl*fOFxr>0){
       lower=xrValue;
       upper=upper;
       System.out.println("xl : "+lower);
       System.out.println("xu : "+upper);
       }
       
       if(fOFxl*fOFxr<0){
       lower=lower;
       upper=xrValue;
       System.out.println("f(xl): "+lower);
       System.out.println("f(xu): "+upper);
       }
       
       if(i==1){
       System.out.println("Error count is not possible untill second iteration");
       }
       
       if(i>1){
       errorCount=object.errorCount(presentXrvalue,pastXrvalue);
       System.out.println("Error : "+Math.abs(errorCount)+"%");
       
       }
       
       }
       pastXrvalue=xrValue;
       }
     
       
}

}
    
    
    

