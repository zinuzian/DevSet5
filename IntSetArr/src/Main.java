import java.util.Random;

public class Main {

	public static void main(String[] args) {
		int m = 10;
		int maxval = 150;
		int v[] = new int[m];
		
		Random rand = new Random();
		
		IntSetArr S = new IntSetArr(m, maxval);

		while (S.size() < m)
			S.insert(rand.nextInt(maxval));
		S.report(v);
		
		for (int i = 0; i < m; ++i) {
			System.out.println(v[i]);
		}
	}

}
