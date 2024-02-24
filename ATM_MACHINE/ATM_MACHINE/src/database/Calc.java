package database;

//basic calculator function to add strings that are numbers
public class Calc {
	//add function
    public static String add(String num1, String num2) {
        if(isSmaller(num1,num2)) 
            num1 = fill(num1, num2.length());
        else            num2 = fill(num2, num1.length());
        boolean carry = false;
        String addition = "";
        for(int i = num1.length()-1; i >= 0; i --) {
            if(carry) {
                if((num1.charAt(i)%48) + (num2.charAt(i)%48) + 1 >= 10) 
                    carry = true;
                else                    carry = false;
                addition = (char) ((num1.charAt(i)%48 + (num2.charAt(i)%48) + 1)%10 + 48) + addition;
            }
            else {
                if((num1.charAt(i)%48) + (num2.charAt(i)%48) >= 10) 
                    carry = true;
                else                    carry = false;
                addition = (char) ((num1.charAt(i)%48 + (num2.charAt(i)%48)) %10 + 48) + addition;
            }
        }
        return addition;
    }
    //subtract function
    public static String subtract(String num1, String num2){
        boolean neg = false;
        if (isSmaller(num1, num2)) {
            String t = num1;
            num1 = num2;
            num2 = t;
            neg = true;
        }
        String addition = "";
        int n1 = num1.length(), n2 = num2.length();
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int carry = 0;
        for (int i = 0; i < n2; i++) {
            int sub = ((int)(num1.charAt(i) - '0') - (int)(num2.charAt(i) - '0') - carry);
            if (sub < 0) {
                sub = sub + 10;
                carry = 1;
            }
            else                carry = 0;
            addition += (char)(sub + '0');
        }
        for (int i = n2; i < n1; i++) {
            int sub = ((int)(num1.charAt(i) - '0') - carry);
            if (sub < 0) {
                sub = sub + 10;
                carry = 1;
            }
            else                carry = 0;
            addition += (char)(sub + '0');
        }
        String sumation = new StringBuilder(addition).reverse().toString();
        if(neg)
            sumation = '-' + sumation;
        return sumation;
    }
    //zero clear helper function
    public static String zeroClear(String num) {
        int size = num.length();
        for(int i = 0; i < size; i ++) {
            if(num.length() > 1 && num.charAt(i) == '0') {
                num = num.substring(0,i) + num.substring(i+1,num.length());
                i--;
            }
            else {
                break;
            }
        }
        return num;
    }
    //fill helper function
    public static String fill(String num, int size) {
        int oldsize = num.length();
        for(int i = 0; i < size - oldsize; i++) 
            num = '0' + num;
        return num;
    }
    
    //helper function to check which string is smaller
    public static boolean isSmaller(String num1, String num2) {
        if(num1.length() < num2.length())
            return true;
        else if(num1.length() == num2.length()) {
            for (int i = 0; i < num1.length(); i++)
                if (num1.charAt(i) < num1.charAt(i))
                    return true;
                else if (num1.charAt(i) > num2.charAt(i))
                    return false;
            }
        else            return false;
        return false;
    }
}