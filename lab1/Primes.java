package lab1;

public class Primes {

    public static void main(String[] args) {
        for (int i = 2; i < 101; i++) {
            if (isPrime(i)) System.out.println(i);
        }
    }

    /**
     * checks if n is prime
     * @param n number to be checked
     * @return true if n is prime
     * otherwise false
     */
    public static boolean isPrime(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}