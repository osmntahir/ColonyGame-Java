package Strategy;
import java.security.SecureRandom;
	
public class Strategy_B extends Strategy {
				
		/* Kriptografik algortimalardan biri olan rastgeliligi yuksek Fortuna
		 *  algoritmasi asagida kullanilarak rastgele sayi uretimi gerceklestirilmistir
		 */
		 private static SecureRandom secureRandom;
		   
		 private static int convertBytesToInt(byte[] bytes) {
		        int value = 0;
		        for (int i = 0; i < 4; i++) {
		            value = (value << 8) + (bytes[i] & 0xff);
		        }
		        return value;
		    }
		@Override
		public int War() {
			
			if (secureRandom == null) {
	            secureRandom = new SecureRandom();
	            secureRandom.setSeed(System.nanoTime());
	        }

	        byte[] randomBytes = new byte[4];
	        secureRandom.nextBytes(randomBytes);

	        int randomNumber = Math.abs(convertBytesToInt(randomBytes));
	        		return randomNumber % 1001; // 0-1000 arasında rastgele sayı üretir
			    }

			

	}

