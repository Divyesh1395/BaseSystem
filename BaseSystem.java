import java.util.Scanner;
import java.lang.Math;

/**
 * This program convert the specified number into different bases.
 * Then total the obtained sequence of each base sequence.
 * Then return the minimum sum.
 * 
 * @author DIVYESH
 */

public class BaseSystem {
    
    static int addSequence(int[] seq){
        int sum = 0;
        for(int i=0; i<seq.length; i++){
            sum += seq[i];
        }
        return sum;
    }
        
    static int[] convertToBase(int num, int base){
        int seq[] = new int[32];
        if(num > 0){
            for(int i=31; i>=0; i--){
                if(num > 0){
                    seq[i] = num % base;  
                    num = num / base;
                }
                else 
                    seq[i] = 0;
            }
        }
        else {
            num = Math.abs(num);
            boolean stop = false;
            for(int i=31; i>=0; i--){
                if(!stop && (num%base == 0)){
                    seq[i] = num % base;  
                    num = num / base;
                }
                else {
                    stop = true;
                    seq[i] = 1;
                }
            }
        }
        return seq;
    }
    
    static int minBase(int num){
        int binarySeq[];
        int a, min = 99999999;
        System.out.println("number to convert : " + num);
        System.out.println();
        for(int base=2; base <=10; base++){
            System.out.println("Base : " + base);
            binarySeq = convertToBase(num, base);
            System.out.print("Sequence : ");
            for(int i=0; i<binarySeq.length; i++){
                System.out.print(binarySeq[i]);
            }    
            System.out.println();
            a = addSequence(binarySeq);
            System.out.println("total sum : " + a);
            if(a < min){
                min = a;
            }
            System.out.println();
        }
        return min;
    }

    public static void main(String[] args) {
        
        for(;;){
            try{
                Scanner scan = new Scanner(System.in);
                System.out.println("\nEnter a number : ");
                System.out.println("Minumum addition is : " + minBase(scan.nextInt()));
            }
            catch(java.util.InputMismatchException e){
                continue;
            }
        }
        
    }  
}
