package sicp;

import java.util.*;

public class Coin {

    public static void main(String[] args) {
        int amount = 49;
        List<Integer> coins = Arrays.asList(1, 5, 10, 25, 50);

        Map<Integer, Integer> weights = weights(amount, coins);

        int result = 1;
        for (int i = 1; i < coins.size(); i++){
            Iterator<Integer> multiples = multiples(amount, coins.get(i));
            int weight = amount / coins.get(i);
            while (multiples.hasNext()){
                Integer mult = multiples.next();
                if (weights.containsKey(mult)){
                    result += weights.get(mult);
                    weights.put(mult, weight--);
                }
            }

        }
        
        System.out.println(result);
    }

    private static Map<Integer, Integer> weights(int amount, List<Integer> coins) {
        Map<Integer, Integer> weights = new HashMap<Integer, Integer>();
        Iterator<Integer> multiples = multiples(amount, coins.get(0));
        while (multiples.hasNext()){
            weights.put(multiples.next(), 1);
        }
        return weights;
    }

    private static Iterator<Integer> multiples(final int amount, final int coin){
        return new Iterator<Integer>() {
            int nextValue = amount - coin;
            public boolean hasNext() {
                return nextValue >= 0;
            }

            public Integer next() {
                int result = nextValue;
                nextValue -= coin;
                return result;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

}
