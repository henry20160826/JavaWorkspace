class Matrix {
	Matrix(int mw, int nw, int pw[][]) {
		p = pw;
		m = mw;
		n = nw;
	}

	Matrix(int mw, int nw) {
		m = mw;
		n = nw;
		p = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				p[i][j] = 0;
			}
		}
	}

	public int p[][];
	public int m, n;

	public void print() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(p[i][j] + " ");
			}
			System.out.println();
		}
	}
}

public class RotatePicture {

	public static void main(String[] args) {
		// System.out.println("hello world");
		int p[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		Matrix m = new Matrix(3, 3, p);
		Matrix nm = rotatePictureMethod(m, 1);
		nm.print();
	}

	static Matrix rotatePictureMethod(Matrix matrix, int flag) {
		Matrix newm = new Matrix(matrix.n, matrix.m);
		// newm.print();
		if (0 == flag) {
			for (int i = 0; i < matrix.m; i++) {
				for (int j = 0; j < matrix.n; j++) {
					// System.out.println("i:" + i + ",j:" + j);
					// System.out.println(newm.p[0][0]);
					newm.p[newm.m - j - 1][i] = matrix.p[i][j];
				}
			}
		} else {
			for (int i = 0; i < matrix.m; i++) {
				for (int j = 0; j < matrix.n; j++) {
					newm.p[j][newm.n - i - 1] = matrix.p[i][j];
				}
			}
		}
		return newm;
	}
}
