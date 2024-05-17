import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MaxPrimeCalculator implements ITask, Serializable {
    private int x;
    private int maxPrime;

    @Override
    public void setExecNumber(int x) {
        this.x = x;
    }

    @Override
    public void exec() {
        List<Integer> primes = findPrimes(x);
        maxPrime = primes.isEmpty()? 0 : primes.get(primes.size() - 1);
    }

    @Override
    public int getResult() {
        return maxPrime;
    }

    public int getX() {
        return x;
    }

    private List<Integer> findPrimes(int limit) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
            }
        }
        return primes;
    }
}