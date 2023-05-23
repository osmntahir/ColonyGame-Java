package pkt;

import java.util.ArrayList;
import java.util.Random;

public class Game {

    private int turnCount;
    public int aliveColonyCount;
    private ArrayList<Colony> colonies;

    public Game(ArrayList<Colony> colonies) {
        this.colonies = colonies;
        aliveColonyCount = colonies.size();
    }

    void performColonyOperation(double differenceRate, Colony colony1, Colony colony2) {

        colony2.setPopulation((int) (colony2.getPopulation() - (colony2.getPopulation() * differenceRate)));

        int foodAmount = (int) (colony2.getFoodStock() * differenceRate);
        colony1.setFoodStock(colony1.getFoodStock() + foodAmount);
        colony2.setFoodStock(colony2.getFoodStock() - foodAmount);

        colony1.setWinsCount(colony1.getWinsCount() + 1);
        colony2.setLossesCount(colony2.getLossesCount() + 1);

    }

    void setColonyBattleLoss(Colony colony1, Colony colony2) {

        colony1.setWinsCount(colony1.getWinsCount() + 1);
        colony2.setLossesCount(colony2.getLossesCount() + 1);
    }

    void collide() {

        for (int i = 0; i < colonies.size(); i++) {

            if (!colonies.get(i).isAlive()) {
                continue;
            }

            for (int j = i + 1; j < colonies.size(); j++) {

                if (!colonies.get(j).isAlive()) {
                    continue;
                }

                int colony1Value = colonies.get(i).getStrategy().War();
                int colony2Value = colonies.get(j).getStrategy().War();

                if (colony1Value > colony2Value) {
                    // Colony 1 wins
                    int difference = colony1Value - colony2Value;
                    double differenceRate = (double) difference / 1000;

                    performColonyOperation(differenceRate, colonies.get(i), colonies.get(j));

                } else if (colony1Value < colony2Value) {
                    // Colony 2 wins
                    int difference = colony2Value - colony1Value;
                    double differenceRate = (double) difference / 1000;

                    performColonyOperation(differenceRate, colonies.get(j), colonies.get(i));
                } else {
                    int populationDifference = colonies.get(i).getPopulation() - colonies.get(j).getPopulation();

                    if (populationDifference > 0) {
                        // Colony 1 wins
                        setColonyBattleLoss(colonies.get(i), colonies.get(j));

                    } else if (populationDifference < 0) {
                        // Colony 2 wins
                        setColonyBattleLoss(colonies.get(j), colonies.get(i));
                    } else {
                        Random rand = new Random();
                        int choice = rand.nextInt(2);
                        if (choice == 0) {
                            // Colony 1 wins
                            setColonyBattleLoss(colonies.get(i), colonies.get(j));
                        } else {
                            // Colony 2 wins
                            setColonyBattleLoss(colonies.get(j), colonies.get(i));
                        }
                    }
                }
            }
        }
    }

    void endTurnOperations() {

        // Operations to be performed at the end of each turn
        for (Colony colony : colonies) {

            if (colony.isAlive() && aliveColonyCount > 1) {

                colony.updateTurn();

                if (colony.getPopulation() <= 0 || colony.getFoodStock() <= 0) {
                    colony.setAlive(false);
                    aliveColonyCount--;
                }
            }
        }
    }

    void printColonies() {

        turnCount++;
        System.out.println("Turn count: " + turnCount);

        System.out.println("Colony" + "\t\t" + "Population" + "\t" + "Food Stock" + "\t" + "Wins" + "\t\t" + "Losses");
        for (Colony colony : colonies) {

            if (colony.isAlive()) {
                System.out.println(colony);
            } else {
                System.out.println(colony.getSymbol() + "\t\t--" + "\t\t--" + "\t\t--" + "\t\t--");
            }
        }
    }
}
