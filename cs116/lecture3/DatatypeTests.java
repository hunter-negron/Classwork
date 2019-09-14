public class DatatypeTests {
    public static short factorial (short x) {
        short fact = 1;
        while (x > 1) {
            fact = (short)(fact * x);
            x = (short)(x - 1);
        }
        return fact;
    }

    public static int factorial (int x) {
        int fact = 1;
        while (x > 1) {
            fact = fact * x;
            x = x - 1;
        }
        return fact;
    }

    public static double factorial (double x) {
        double fact = 1.0;
        while (x > 1) {
            fact = fact * x;
            x = x - 1;
        }
        return fact;
    }

    public static double invfactorial (double x) {
        return 1.0 / factorial(x);
    }

    public static float factorial (float x) {
        float fact = 1.0F;
        while (x > 1) {
            fact = fact * x;
            x = x - 1;
        }
        return fact;
    }

    public static float invfactorial (float x) {
        return 1.0F / factorial(x);
    }

    public static void main (String[] args) {
        try {
            int val = Integer.parseInt(args[0]);
            System.out.println("(short) factorial of " + val 
                               + " = " + factorial((short) val));
            System.out.println("(int) factorial of " + val 
                               + " = " + factorial(val));
            System.out.println("(float) factorial of " + val 
                               + " = " + factorial((float) val));
            System.out.println("(float) inverse factorial of " 
                               + val + " = " + invfactorial((float)val));
            System.out.println("(double) factorial of " + val 
                               + " = " + factorial((double) val));
            System.out.println("(double) inverse factorial of " 
                               + val + " = " + invfactorial((double)val));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You must provide a command line argument!");
        } catch (NumberFormatException e) {
            System.out.println("You must specify a whole number!!");
        }
    }
}
