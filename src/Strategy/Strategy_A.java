package Strategy;

public class Strategy_A extends Strategy {


	/* 
	 * Linear Congruential Generator (Lineer Kongrüans Oluşturucusu) algoritmasi kullanarak rastgele sayi uretimi 
	 * asagida gerceklestirilmistir
	 * 
	 * */
		private static final int A = 48271;
	    private static final int M = 2147483647;
	    private static final int Q = M / A;
	    private static final int R = M % A;
	    
	    private static int seed = (int) System.currentTimeMillis(); 
		@Override
		public int War() {
			// Başlangıç değeri olarak sistem saatini kullanabilirsiniz.
		    
		  
		        int hi = seed / Q;
		        int lo = seed % Q;
		        int test = A * lo - R * hi;
		        if (test > 0) 
		        {
		            seed = test;
		        } 
		        else 
		        {
		            seed = test + M;
		        }
		        return seed % 1001; // 0 ile 1000 arasında rastgele bir sayı döndürür.

		}
	}


