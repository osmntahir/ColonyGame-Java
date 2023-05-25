package tr.edu.sakarya.campus;


import tr.edu.sakarya.campus.specs.Production;
import tr.edu.sakarya.campus.specs.Strategy;

public class Colony {

    private final char symbol;
	private final Strategy strategy;
	private final Production production;
    private int foodStock;
    private int population;
    private int winsCount;
    private int lossesCount;

    public Colony(int population, char symbol, Strategy strategy, Production production) {
        this.symbol = symbol;
        this.foodStock = population * population;
        this.population = population;
        this.winsCount = 0;
        this.lossesCount = 0;
		this.strategy = strategy;
		this.production = production;
    }

    public char symbol() {
        return symbol;
    }


    public int foodStock() {
        return foodStock;
    }

    public int population() {
        return population;
    }

    public int winsCount() {
        return winsCount;
    }

    public int lossesCount() {
        return lossesCount;
    }

    public int strategyAchievement() {
        return strategy.achievement();
    }

    public boolean isAlive() {
        return this.population > 0 && this.foodStock > 0;
    }

	public void wonAgainst(Colony opponent, double dominanceFactor) {
		this.foodStock += opponent.foodStock * dominanceFactor;
		++this.winsCount;

		opponent.population -= this.population * dominanceFactor;
		opponent.foodStock -= this.foodStock * dominanceFactor;
		++opponent.lossesCount;
	}

	public void biggerThan(Colony opponent) {
		++this.winsCount;
		++opponent.lossesCount;
	}
    public void prepare() {
        this.population += (int) (this.population * 0.2);
        this.foodStock += this.production.produce();
        this.foodStock -= this.population * 2;
    }
}
