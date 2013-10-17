// Solution for HackerRank Problem "RED JOHN IS BACK"
import java.util.Arrays;
import java.util.Scanner;


public class redJohn {
	int N;
		boolean[] primes=new boolean[1000000]; 
		int[] table=new int[1];
		public redJohn(int I) {
			N=I;
			table=new int[N+1];
			for(int j=0;j<=N;j++)
			{
				table[j]=-2;
			}
			fillSieve();
		}
		
		public void fillSieve() {
		  Arrays.fill(primes,true);       
		  primes[0]=primes[1]=false;       
		  for (int i=2;i<primes.length;i++) {
		      if(primes[i]) {
		          for (int j=2;i*j<primes.length;j++) {
		              primes[i*j]=false;
		          }
		      }
		  }
		}

		public boolean isPrime(int n) {
		  return primes[n];
		}

		/**
		 * @param args
		 */
		public static void main(String[] args) {
			Scanner inp=new Scanner(System.in);
			redJohn T = new redJohn(1);
			int cases=inp.nextInt();
			for(int i=0;i<cases;i++)
			{
				int n = inp.nextInt();
				T=new redJohn(n);
				System.out.println(T.evaluate());
			}
			inp.close();

		}

		private int evaluate() {
			return getPrimes(helper(N));
		}

		private int getPrimes(int p) {
			int count=0;
			for(int i=1;i<=p;i++)
			{
				if(isPrime(i)) count++;
			}
			return count;
		}

		private int helper(int n) {
			if(table[n]==-2)
			{
				if (n<4) table[n]=1;
				else 
				{
					table[n]=helper(n-1) + helper(n-4); 
				}
			}
			return table[n];
		}
}
