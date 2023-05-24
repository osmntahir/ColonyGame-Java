package tr.edu.sakarya;

import tr.edu.sakarya.campus.Colony;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Game {

    private final AtomicInteger turnCount = new AtomicInteger(0);
    private final List<Colony> colonies;

    public Game(List<Colony> colonies) {
        this.colonies = colonies;
    }

    /**
     * Collides all colonies each other. Every one of each will fight against to others.
     * // TODO: add a brief info about the code block
     *
     * @return number alive colonies after each turn
     */
    public long collide() {
        /*
        Complexity (time and space)
        Time:
            n -> size of colonies
            n * log + n + n + n -> n goes to infinite -> ~nlogn -> O(nlogn) -> O(n) : Recursion
        Space:
            memory/disk usage -> O(n)
         */
        print();
        turnCount.incrementAndGet();
        for (int i = 0; i < colonies.size() - 1; ++i) {
            Colony colony = colonies.get(i);
            // a dead colony can not fight
            if (!colony.isAlive()) {
                continue;
            }
            for (int j = i + 1; j < colonies.size(); ++j) {
                Colony opponent = colonies.get(j);
                // a colony cannot fight itself besides it's a Turkish colony
                if (opponent.symbol() == colony.symbol()) {
                    continue;
                }
                // a dead colony can not fight
                if (!opponent.isAlive()) {
                    continue;
                }

                int strategyAchievement = colony.strategyAchievement();
                int opponentStrategyAchievement = opponent.strategyAchievement();
                double dominanceFactor = (double) (Math.abs(strategyAchievement - opponentStrategyAchievement)) / 1000;
                if (strategyAchievement > opponentStrategyAchievement) {
                    colony.wonAgainst(opponent, dominanceFactor);
                } else if (strategyAchievement < opponentStrategyAchievement) {
                    opponent.wonAgainst(colony, dominanceFactor);
                } else {
                    int populationDominance = colony.population() - opponent.population();

                    if (populationDominance > 0) {
                        colony.biggerThan(opponent);
                    } else if (populationDominance < 0) {
                        opponent.biggerThan(colony);
                    } else {
                        Random rand = new Random();
                        int choice = rand.nextInt(2);
                        if (choice == 0) {
                            colony.biggerThan(opponent);
                        } else {
                            opponent.biggerThan(colony);
                        }
                    }
                }
            }
        }
        colonies.forEach(Colony::prepare);
        long aliveCnt = colonies.stream().filter(Colony::isAlive).count();
        if(aliveCnt==1) {
            print();
        }

        return aliveCnt;
    }

    private void print() {
        printTurn();
        printColonies();
    }

    private void printTurn() {
        System.out.printf("---------------------------------------------------------------------%n");
        System.out.printf("Turn count: %5d %n", turnCount.get());
        System.out.printf("---------------------------------------------------------------------%n");
    }

    private void printColonies() {
        System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-10s |%n", "Symbol", "Population", "Food Stock", "Wins", "Losses");
        for (Colony colony : colonies) {
            if (colony.isAlive()) {
                System.out.printf("| %-10s | %10d | %10d | %10d | %10d |%n",
                        colony.symbol(), colony.population(), colony.foodStock(), colony.winsCount(), colony.lossesCount());
            } else {
                System.out.printf("| %-10s | %10s | %10s | %10s | %10s |%n",
                        colony.symbol(), "--", "--", "--", "--");
            }
        }
        System.out.printf("---------------------------------------------------------------------%n");
    }
}
