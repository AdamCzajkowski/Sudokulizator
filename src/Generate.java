
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

	public static int[] numberOfFreeSquare = new int[] {0,3,8};


	public static void fullZero() {
		for (int row = 0; row < 9; row++) {
			for (int column = 0; column < 9; column++){
				sudoku[row][column] = '0';
			}
		}
	}
	public static char randomElement() {
		Random random = new Random();
		String posibility = "123456789";
		char element = posibility.charAt(random.nextInt(posibility.length()));
		return element;
	}

	public static void generate3FreeSquares() {
	    for (int freeSquare = 0; freeSquare <=2; freeSquare++) {
            for (int row = 0; row < 3; row++) {
                for (int column = 0; column < 3; column++) {
                    sudoku[row][column] = randomElement();
                    if (!((squaresList[numberOfFreeSquare[freeSquare]].contains(sudoku[row][column])))) {
                        squaresList[numberOfFreeSquare[freeSquare]].add(sudoku[row][column]);
                        continue;
                    } else {
                        column--;
                    }

                }
            }
        }
	}


	}
