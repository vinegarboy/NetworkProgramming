import java.util.*;

public class PrimeCheck {
    public static void main(String[] args) {
        Map<Integer, Integer> lastDigitCount = new HashMap<>();
        Map<Integer, Integer> lastDigitPairCount = new HashMap<>();
        int[] primes = sieveOfEratosthenes(100000);

        for (int i = 0; i < primes.length - 1; i++) {
            int lastDigit = primes[i] % 10;
            int nextLastDigit = primes[i + 1] % 10;
            lastDigitCount.put(lastDigit, lastDigitCount.getOrDefault(lastDigit, 0) + 1);
            int pairKey = lastDigit * 10 + nextLastDigit;
            lastDigitPairCount.put(pairKey, lastDigitPairCount.getOrDefault(pairKey, 0) + 1);
        }

        System.out.println("素数の下一桁の出現回数:");
        lastDigitCount.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        System.out.println("\n連続する素数の下一桁のペアの出現回数のランキング:");
        lastDigitPairCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    private static int[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes.stream().mapToInt(Integer::intValue).toArray();
    }
}
