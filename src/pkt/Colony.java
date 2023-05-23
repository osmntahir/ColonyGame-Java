package pkt;


import Strategy.Strategy;
import Strategy.Strategy_A;
import Strategy.Strategy_B;

import Production.Production;
import Production.Production_A;
import Production.Production_B;


import java.util.Random;

public class Colony {
		
		private char symbol;
		private int foodStock;
		private int population;
		private int winsCount;
		private int lossesCount;
		private Strategy strategy;
		private Production production;
		private boolean isAlive;


		public Colony(int population , char symbol) {
			super();
			this.symbol = symbol;
			this.foodStock = population*population;
			this.population = population;
			this.winsCount = 0;
			this.lossesCount = 0;
			this.isAlive = true;
			
			Random random = new Random();
	        int choice = random.nextInt(2); // 0 veya 1'i rastgele seçer

	        if (choice == 0) {
	        	strategy = new Strategy_A();
	        	production = new Production_A();
	        } else {
	        	strategy = new Strategy_B();
	        	production = new Production_B();
	        }
		
		}
		
		public void updateTurn() {
	        this.population += (int) (this.population * 0.2);
	        this.foodStock += (int) (this.production.Produce());
	        this.foodStock -= (int) (this.population * 2);
	    }
		
		public String toString() {
		    return  this.symbol + "\t\t" + " "+this.population+ "\t\t" + " "+this.foodStock+ "\t\t" + " "+this.winsCount
		    		+ "\t\t" + " "+this.lossesCount;
		  }

		public char getSymbol() {
			return symbol;
		}

		public void setSymbol(char symbol) {
			this.symbol = symbol;
		}

		public int getFoodStock() {
			return foodStock;
		}

		public void setFoodStock(int foodStock) {
			this.foodStock = foodStock;
		}

		public int getPopulation() {
			return population;
		}

		public void setPopulation(int population) {
			this.population = population;
		}

		public int getWinsCount() {
			return winsCount;
		}

		public void setWinsCount(int winsCount) {
			this.winsCount = winsCount;
		}

		public int getLossesCount() {
			return lossesCount;
		}

		public void setLossesCount(int lossesCount) {
			this.lossesCount = lossesCount;
		}

		public Strategy getStrategy() {
			return strategy;
		}

		public void setStrategy(Strategy strategy) {
			this.strategy = strategy;
		}

		public Production getProduction() {
			return production;
		}

		public void setProduction(Production production) {
			this.production = production;
		}

		public boolean isAlive() {
			return isAlive;
		}

		public void setAlive(boolean isAlive) {
			this.isAlive = isAlive;
		}


		
		
		
		
		
		
			
	}
