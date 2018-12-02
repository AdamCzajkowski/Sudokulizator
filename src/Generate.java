
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
Squares of sudoku:
	1 | 2 | 3
	4 | 5 | 6
	7 | 8 | 9

columns of sudoku:
	c1
	c2
	...
	c9

rows of sudoku:
	r1 r2 ... r9
 */

public class Generate {
	public static char[][] sudoku = new char[9][9];
	public static List c1 = new ArrayList(9);
	public static List c2 = new ArrayList(9);
	public static List c3 = new ArrayList(9);
	public static List c4 = new ArrayList(9);
	public static List c5 = new ArrayList(9);
	public static List c6 = new ArrayList(9);
	public static List c7 = new ArrayList(9);
	public static List c8 = new ArrayList(9);
	public static List c9 = new ArrayList(9);
	public static List[] columnsList = new List[] {c1,c2,c3,c4,c5,c6,c7,c8,c9};

	public static List r1 = new ArrayList(9);
	public static List r2 = new ArrayList(9);
	public static List r3 = new ArrayList(9);
	public static List r4 = new ArrayList(9);
	public static List r5 = new ArrayList(9);
	public static List r6 = new ArrayList(9);
	public static List r7 = new ArrayList(9);
	public static List r8 = new ArrayList(9);
	public static List r9 = new ArrayList(9);
	public static List[] rowsList = new List[] {r1,r2,r3,r4,r5,r6,r7,r8,r9};

	public static List s1 = new ArrayList(9);
	public static List s2 = new ArrayList(9);
	public static List s3 = new ArrayList(9);
	public static List s4 = new ArrayList(9);
	public static List s5 = new ArrayList(9);
	public static List s6 = new ArrayList(9);
	public static List s7 = new ArrayList(9);
	public static List s8 = new ArrayList(9);
	public static List s9 = new ArrayList(9);
	public static List[] squaresList = new List[] {s1,s2,s3,s4,s5,s6,s7,s8,s9};

	public static int[] numberOfFreeSquare = new int[] {0,4,8};
    public static int[] startValueOfSudokuSquars = new int[] {0,3,6};
	public static int[] numbersStart = new int[] {0,3,6};
	public static int[] numbersEnd = new int[] {2,5,8};
	public static int iteration = 0;
	final static int LIMIT = 50;

	public static void fullZero() {
		for (int row = 0; row < 9; row++) {
			for (int column = 0; column < 9; column++){
				sudoku[row][column] = '0';
				squaresList[row].clear();
				rowsList[row].clear();
				columnsList[column].clear();

			}
		}
	}
	public static char randomElement() {
		Random random = new Random();
		String posibility = "123456789";
		char element = posibility.charAt(random.nextInt(posibility.length()));
		return element;
	}

	public static void generateIISquares() {
		for (int i = 0; i <=3; i=i+3) {
			for (int row = 3 + i; row <= 5+i; row++) {
				for (int column = 0; column < 3; column++) {
					sudoku[row][column] = randomElement();
					if (!((squaresList[3+i].contains(sudoku[row][column]))) && !(rowsList[row].contains(sudoku[row][column])) && !(columnsList[column].contains(sudoku[row][column])) ) {
						squaresList[3+i].add(sudoku[row][column]);
						rowsList[row].add(sudoku[row][column]);
						columnsList[column].add(sudoku[row][column]);
						iteration = 0;
					} else {
						column--;
						Show.showSudoku();
						iteration++;
						if (iteration > LIMIT){
							generate();

						}
					}
				}
			}
		}
	}

	public static void generateIIISquares() {
		for (int i = 0; i <=3; i=i+3) {
			for (int row = 0 + i; row <= 2+i; row++) {
				for (int column = 6; column <= 8; column++) {
					sudoku[row][column] = randomElement();
					if (!((squaresList[2+i].contains(sudoku[row][column]))) && !(rowsList[row].contains(sudoku[row][column])) && !(columnsList[column].contains(sudoku[row][column])) ) {
						squaresList[2+i].add(sudoku[row][column]);
						rowsList[row].add(sudoku[row][column]);
						columnsList[column].add(sudoku[row][column]);
						iteration = 0;
						continue;
					} else {
						column--;
						Show.showSudoku();
						iteration++;
						if (iteration > LIMIT){
							generate();

						}
					}
				}
			}
		}
	}

	public static void generateIVSquares() {
		for (int i = 0; i <=6; i=i+6) {
			for (int row = 0 + i; row <= 3+i; row++) {
				for (int column = 3; column <= 5; column++) {
					sudoku[row][column] = randomElement();
					if (!((squaresList[1+i].contains(sudoku[row][column]))) && !(rowsList[row].contains(sudoku[row][column])) && !(columnsList[column].contains(sudoku[row][column])) ) {
						squaresList[1+i].add(sudoku[row][column]);
						rowsList[row].add(sudoku[row][column]);
						columnsList[column].add(sudoku[row][column]);
						iteration = 0;
						continue;
					} else {
						column--;
						//Show.showSudoku();
						iteration++;
						if (iteration > LIMIT){
							generate();

						}
					}
				}
			}
		}
	}

	public static void generate3FreeSquares() {
		for (int i = 0; i <=2; i++) {
			for (int row = 0 + startValueOfSudokuSquars[i]; row < 3+startValueOfSudokuSquars[i]; row++) {
				for (int column = 0 +startValueOfSudokuSquars[i]; column < 3+startValueOfSudokuSquars[i]; column++) {
					sudoku[row][column] = randomElement();
					if (!((squaresList[numberOfFreeSquare[i]].contains(sudoku[row][column])))) {
						squaresList[numberOfFreeSquare[i]].add(sudoku[row][column]);
						rowsList[row].add(sudoku[row][column]);
						columnsList[column].add(sudoku[row][column]);
						iteration = 0;
					} else {
						column--;
						iteration++;
						if (iteration > LIMIT){
							generate();

						}
					}

				}
			}
		}
	}


	public static void generate() {
		fullZero();
		generate3FreeSquares();
		generateIISquares();
		generateIIISquares();
		generateIVSquares();
	}
	}



