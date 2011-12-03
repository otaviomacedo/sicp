package sicp;

import com.google.common.collect.ImmutableList;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import static com.google.common.collect.Maps.newHashMap;

public class Coin {

    public static void main(String[] args) {
        int amount = 100;
        ImmutableList<Integer> coins = ImmutableList.of(1, 5, 10, 25, 50);
        System.out.println(countChange(amount, coins));
    }

    public static int countChange(final int amount, final List<Integer> coins) {
        Stack<Cell> cells = new Stack<Cell>();
        Cell mainCell = new Cell(amount, coins.size() - 1);
        cells.add(mainCell);

        HashMap<Cell,Integer> cache = newHashMap();

        while (!cells.isEmpty()){
            Cell cell = cells.peek();
            if (cell.amount == 0){
                cells.pop();
                cache.put(cell, 1);
            } else if (cell.amount < 0 || cell.index < 0){
                cells.pop();
                cache.put(cell, 0);
            } else {
                Cell cell1 = new Cell(cell.amount - coins.get(cell.index), cell.index);
                Cell cell2 = new Cell(cell.amount, cell.index - 1);
                if (cache.containsKey(cell1) && cache.containsKey(cell2)){
                    cells.pop();
                    cache.put(cell, cache.get(cell1) + cache.get(cell2));
                } else {
                    if (!cache.containsKey(cell1)){cells.push(cell1);}
                    if (!cache.containsKey(cell2)){cells.push(cell2);}
                }
            }
        }

        return cache.get(mainCell);
    }

    private static class Cell {
        private final int amount, index;

        private Cell(int amount, int index) {
            this.amount = amount;
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Cell cell = (Cell) o;

            if (amount != cell.amount) return false;
            if (index != cell.index) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = amount;
            result = 31 * result + index;
            return result;
        }

        @Override
        public String toString() {
            return "(" + amount + "," + index + ')';
        }
    }



}
