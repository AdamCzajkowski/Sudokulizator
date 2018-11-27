public class Show {

    public static void showSudoku(){
        System.out.println(" ");
        for (char[] sudokuLine : Generate.sudoku) {
            for (char element : sudokuLine) {
                    System.out.print(element + " ");
            }
            System.out.println(" ");
        }
        System.out.println("\n");
    }





}
