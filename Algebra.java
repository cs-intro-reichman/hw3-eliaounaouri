public class Algebra {
    public static void main(String args[]) {
        System.out.println(plus(2,3));
        System.out.println(minus(7,2));
        System.out.println(minus(2,7));
        System.out.println(times(3,4));
        System.out.println(plus(2,times(4,2)));
        System.out.println(pow(5,3));
        System.out.println(pow(3,5));
        System.out.println(div(12,3));
        System.out.println(div(5,5));
        System.out.println(div(25,7));
        System.out.println(mod(25,7));
        System.out.println(mod(120,6));
        System.out.println(sqrt(36));
        System.out.println(sqrt(263169));
        System.out.println(sqrt(76123));
    }

    public static int plus(int x1, int x2) {
        if (x2 > 0) {
            for (int i = 0; i < x2; i++) {
                x1++;
            }
        } else {
            for (int i = 0; i > x2; i--) {
                x1--;
            }
        }
        return x1;
    }

    public static int minus(int x1, int x2) {
        if (x2 > 0) {
            for (int i = 0; i < x2; i++) {
                x1--;
            }
        } else {
            for (int i = 0; i > x2; i--) {
                x1++;
            }
        }
        return x1;
    }

    public static int times(int x1, int x2) {
        if (x1 == 0 || x2 == 0) return 0;
        
        boolean negativeResult = (x1 < 0) != (x2 < 0);
        
        int abs_x1 = (x1 < 0) ? minus(0, x1) : x1;
        int abs_x2 = (x2 < 0) ? minus(0, x2) : x2;
        
        int result = 0;
        for (int i = 0; i < abs_x2; i++) {
            result = plus(result, abs_x1);
        }
        
        return negativeResult ? minus(0, result) : result;
    }

    public static int pow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        
        int result = x;
        for (int i = 0; i < n - 1; i++) {
            result = times(result, x);
        }
        return result;
    }

    public static int div(int x1, int x2) {
        if (x2 == 0) {
            return 0; 
        }
        if (x1 == 0) return 0;

        boolean negativeResult = (x1 < 0) != (x2 < 0);
        
        int abs_x1 = (x1 < 0) ? minus(0, x1) : x1;
        int abs_x2 = (x2 < 0) ? minus(0, x2) : x2;

        int result = 0;
        while (abs_x1 >= abs_x2) {
            abs_x1 = minus(abs_x1, abs_x2);
            result++;
        }
        
        return negativeResult ? minus(0, result) : result;
    }

    public static int mod(int x1, int x2) {
        if (x2 == 0) {
            return x1;
        }
        if (x1 == 0) return 0;
        
        boolean negativeResult = x1 < 0;
        
        int abs_x1 = (x1 < 0) ? minus(0, x1) : x1;
        int abs_x2 = (x2 < 0) ? minus(0, x2) : x2;

        int remainder = abs_x1;
        while (remainder >= abs_x2) {
            remainder = minus(remainder, abs_x2);
        }
        
        return negativeResult ? minus(0, remainder) : remainder;
    }

    public static int sqrt(int x) {
        if (x < 0) {
            return 0; 
        }
        if (x == 0 || x == 1) {
            return x;
        }

        int i = 1;
        while (true) {
             int square = times(i, i);
             if (square > x) {
                 return minus(i, 1);
             }
             if (i > 46340) {
                 return i; 
             }
             i++;
         }
    }
}