
package differentbases;

import java.util.Scanner;

/**
 * This program convert the specified number into different bases.
 * Then total the obtained sequence of each base sequence.
 * Then return the minimum sum.
 * 
 * @author DIVYESH
 */

public class DifferentBases {
    
    //Add values of specified array.
    static int addSequence(int[] seq){
        int sum = 0;
        for(int i=0; i<seq.length; i++){
            sum += seq[i];
        }
        return sum;
    }
    
    //Take negative number and Convert it to base 2 only.
    static int[] negativeNum(int num, int[] seq){
        num = Math.abs(num);
        boolean flipStart = false;
        for(int i=31; i>=0; i--){
            if(!flipStart){
                if(num%2 == 0){
                    seq[i] = num % 2;
                }
                else {
                    flipStart = true;
                    seq[i] = 1;
                }
            }
            else{
                seq[i] = (num % 2 == 0) ? 1 : 0; 
            }
            num = num / 2;
        }
        return seq;
    }
        
    //Take positive number and convert it to the specified base.
    static int[] convertToBase(int num, int[] seq, int base){
        for(int i=31; i>=0; i--){
            if(num > 0){
                seq[i] = num % base;  
                num = num / base;
            }
            else seq[i] = 0;
        }
        return seq;
    }
    
    //Take a number.
    //If num is positive call convertToBase() method.
    //Else call negativeNum() method and get sequence.
    //Then call addSequence() method and return the minimum sum.
    static int minBase(int num){ 
        int seq[] = new int[32];
        int a;
        int min = 99999999;
        System.out.println("number to convert : " + num);
        if(num > 0){
            for(int base=2; base <=10; base++){
                System.out.println("\nBase : " + base);
                seq = convertToBase(num, seq, base);
                System.out.print("Sequence : ");
                for(int i=0; i<seq.length; i++){
                    System.out.print(seq[i]);
                }
                System.out.println();
            }
        }
        else{
            seq = negativeNum(num, seq);
            System.out.print("\nBase : 2 \nSequence : ");
            for(int i=0; i<seq.length; i++){
                System.out.print(seq[i]);
            }
        }
            
        a = addSequence(seq);
        System.out.println("\ntotal sum : " + a);
        if(a < min){
            min = a;
        }
        System.out.println();
        return min;
    }

    public static void main(String[] args) {
        int num;
        for(;;){
            try{
                System.out.println("\nEnter a number :");
                System.out.println("Enter 0 to exit :");
                Scanner scan = new Scanner(System.in);
                num = scan.nextInt();
                if(num == 0) break;
                System.out.println("Minumum sum is : " + minBase(num));
            }
            catch(java.util.InputMismatchException e){
                System.out.println("------Only numbers allowed------");
            }
        }
        
    }  
}
