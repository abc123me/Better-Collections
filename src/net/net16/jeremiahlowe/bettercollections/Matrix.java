package net.net16.jeremiahlowe.bettercollections;

public class Matrix implements Cloneable{
	//[start] Variables
	private float[][] contents;
	private int rows, columns;
	//[end]
	//[start] Constructors
	public Matrix(float[][] contents){
		if(contents.length <= 0 || contents[0].length <= 0) throw new RuntimeException("Rows and columns must be >0");
		rows = contents.length;
		columns = contents[0].length;
		this.contents = contents;
	}
	public Matrix(int rows, int columns){
		if(rows <= 0 || columns <= 0) throw new RuntimeException("Rows and columns must be >0");
		this.columns = columns; this.rows = rows;
		contents = new float[rows][columns];
	}
	
	public void fill(float val){
		for(int x = 0; x < rows; x++){
			for(int y = 0; y < columns; y++){
				contents[x][y] = val;
			}
		}
	}
	//[end] 
	//[start] Creation methods
	public static Matrix createNegatingMatrix(int rows, int columns){
		Matrix out = new Matrix(rows, columns);
		boolean neg = false;
		for(int x = 0; x < rows; x++){
			for(int y = 0; y < columns; y++){
				out.contents[x][y] = neg ? -1 : 1;
				neg = !neg;
			}
		}
		return out;
	}
	public static Matrix createIdentityMatrix(int size){
		Matrix out = new Matrix(size, size);
		for(int i = 0; i < size; i++) out.contents[i][i] = 1;
		return out;
	}
	//[end]
	//[start] Utility
	public Matrix resize(int rows, int columns){
		int maxX = rows > this.rows ? rows : this.rows;
		int maxY = columns > this.columns ? columns : this.columns;
		float[][] newContents = new float[maxX][maxY];
		for(int x = 0; x < maxX; x++){
			for(int y = 0; y < maxY; y++){
				newContents[x][y] = contents[x][y];
			}
		}
		contents = newContents;
		this.rows = rows;
		this.columns = columns;
		return this;
	}
	//[end]
	//[start] Multiplication/Division/Addition/Subtraction
	public static Matrix subtract(Matrix a, Matrix b){return add(a, negate(b));}
	public Matrix subtract(Matrix b){return add(this, negate(b));}
	public Matrix add(Matrix b){return add(this, b);}
	public static Matrix add(Matrix a, Matrix b){
		if(a.columns != b.columns || a.rows != b.rows) throw new RuntimeException("Matricies must be of same size to add/subtract");
		Matrix out = new Matrix(a.rows, a.columns);
		for(int x = 0; x < a.rows; x++){
			for(int y = 0; y < a.columns; y++){
				out.contents[x][y] = a.contents[x][y] + b.contents[x][y];
			}
		}
		return out;
	}
	public Matrix negate(){return negate(this);}
	public static Matrix negate(Matrix a){
		Matrix out = new Matrix(a.rows, a.columns);
		for(int x = 0; x < a.rows; x++){
			for(int y = 0; y < a.columns; y++){
				out.contents[x][y] = -a.contents[x][y];
			}
		}
		return out;
	}
	public Matrix divide(float b){return multiply(this, 1 / b);}
	public Matrix divide(Matrix b){return multiply(this, inverse(b));}
	public static Matrix divide(Matrix a, float b){return multiply(a, 1 / b);}
	public static Matrix divide(Matrix a, Matrix b){return multiply(a, inverse(b));}
	public Matrix multiply(float b){return multiply(this, b);}
	public static Matrix multiply(Matrix a, float b){
		float[][] out = new float[a.rows][a.columns];
		for(int x = 0; x < a.rows; x++){
			for(int y = 0; y < a.columns; y++){
				out[x][y] = a.contents[x][y] * b;
			}
		}
		return new Matrix(out);
	}
	public Matrix multiply(Matrix b){return multiply(this, b);}
	public static Matrix multiply(Matrix a, Matrix b){
		if(a.columns != b.rows) throw new RuntimeException("Matrixies could not be multiplied!");
		Matrix out = new Matrix(a.rows, b.columns);
		for(int x = 0; x < out.rows; x++){
			for(int y = 0; y < out.columns; y++){
				float val = 0;
				for(int i = 0; i < a.columns; i++) val = val + a.get(x, i) * b.get(i, y);
				out.set(x, y, val);
			}
		}
		return out;
	}
	public Matrix hadamardProduct(Matrix b){return hadamardProduct(this, b);}
	public static Matrix hadamardProduct(Matrix a, Matrix b){
		if(a.rows != b.rows || a.columns != b.columns) throw new RuntimeException("Matricies must be same size!");
		Matrix m = new Matrix(a.rows, a.columns);
		for(int x = 0; x < a.rows; x++){
			for(int y = 0; y < a.columns; y++){
				m.contents[x][y] = a.contents[x][y] * b.contents[x][y];
			}
		}
		return m;
	}
	//[end]
	//[start] Matrix functions
	public Matrix inverse(){return Matrix.inverse(this);}
	public static Matrix inverse(Matrix m){return multiply(m, 1f / m.det());}
	public float det(){return det(this);}
	public static float det(Matrix of){
		if(!of.isSquare()) throw new RuntimeException("Matrix must be square to get the determinant!");
		int size = of.rows;
		if(size == 1) return of.contents[0][0];
		if(size == 2) return det2x2(of);
		float det = 0;
		for(int cr = 0; cr < size; cr++){
            Matrix m = new Matrix(size - 1, size - 1);
            for(int y = 1; y < size; y++){
                int inc = 0;
                for(int x = 0; x < size; x++){
                    if(x == cr) continue;
                    m.contents[y - 1][inc] = of.contents[y][x];
                    inc++;
                }
            }
            det += Math.pow(-1.0, 1.0 + cr + 1.0) * of.contents[0][cr] * det(m);
        }
		return det;
	}
	public float det2x2(){return det2x2(this);}
	public static float det2x2(Matrix m){
		if(m.rows != 2 || m.columns != 2) throw new RuntimeException("This can only evaluate 2x2 matricies, please use det() for anything else");
		return m.contents[0][0] * m.contents[1][1] - m.contents[0][1] * m.contents[1][0];
	}
	//[end]
	//[start] Getters and setters
	public boolean isSquare(){return rows == columns;}
	public int getRows(){return rows;}
	public int getColumns(){return columns;}
	public float get(int x, int y){return contents[y][x];}
	public float set(int x, int y, float val){return (contents[y][x] = val);}
	//[end]
	//[start] Override methods
	@Override
	public String toString(){
		String ls = System.lineSeparator();
		String out = "Matrix (" + rows + " by " + columns + "):" + ls;
		for(int x = 0; x < rows; x++){
			out += "[";
			for(int y = 0; y < columns; y++){
				out += get(x, y) + ((y != (columns - 1)) ? ", " : "");
			}
			out += "]" + ls;
		}
		return out.substring(0, out.length() - 1);
	}
	@Override
	public Matrix clone(){
		Matrix out = new Matrix(rows, columns);
		for(int x = 0; x < rows; x++){
			for(int y = 0; y < columns; y++){
				out.contents[x][y] = contents[x][y];
			}
		}
		return out;
	}
	//[end]
}