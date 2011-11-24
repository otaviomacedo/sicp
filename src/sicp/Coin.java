package sicp;

import java.util.*;

import static com.google.common.collect.Maps.newHashMap;

public class Coin {

    public static void main(String[] args) {
        int amount = 50;
        List<Integer> coins = Arrays.asList(1, 5, 10, 25, 50);

        Map<Integer, Node> nodes = nodes(amount, coins);

        int result = 0;
        for (int i = 1; i < coins.size(); i++){
            Iterator<Integer> multiples = multiples(amount, coins.get(i));
            Node node = new Node(0, i);
            while (multiples.hasNext()){
                Integer mult = multiples.next();
                if (nodes.containsKey(mult)){
                    node = nodes.get(mult).shift(i, coins).plus(node);
                    result = node.degree;
                    nodes.put(mult, node);
                }
            }

        }
        
        System.out.println(result + 1);
    }


    private static class Node {
        private final int degree, level;

        Node(int degree, int level) {
            this.degree = degree;
            this.level = level;
        }

        Node shift(int level, List<Integer> coins){
            return level - this.level == 1
                    ? new Node(degree, level)
                    : new Node(degree + coins.get(this.level), level);
        }

        Node plus(Node other){
            return new Node(this.degree + other.degree, level);
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", degree, level);
        }
    }

    private static Map<Integer, Node> nodes(int amount, List<Integer> coins){
        Map<Integer, Node> nodes = newHashMap();

        Iterator<Integer> multiples = multiples(amount, coins.get(0));

        final Node baseNode = new Node(1, 0);
        while (multiples.hasNext()){
            nodes.put(multiples.next(), baseNode);
        }

        return nodes;
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
            int nextValue = amount % coin;

            public boolean hasNext() {
                return nextValue < amount;
            }

            public Integer next() {
                int result = nextValue;
                nextValue += coin;
                return result;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

}
