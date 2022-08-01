package make_a_spiral;

import java.util.Arrays;

class Main{

    public static final String ANSI_RED = "\u001B[31m";

    public static final String ANSI_YELLOW = "\u001B[33m";

    public static final String ANSI_RESET = "\u001B[37m";

    public static void main(String[] args) {

        int[][] spiral = new int[][]{
                { 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 1 },
                { 1, 1, 1, 0, 1 },
                { 1, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1 }
        };

        int[][] spiraled = spiralize(5);

        if(Arrays.deepEquals(spiral, spiraled)){

            System.out.println("It worked");
        }else{

            System.out.println("It did not work");
        }

        System.out.println();
        System.out.println();

        int[][] spiraled2 = spiralize(19);

        printGrid(spiraled2);

    }

    public static int[][] spiralize(int size) {

        // The Code Between these commentblocks can be pasted as the solution
        // ------------------------------------------------------------------
        // ------------------------------------------------------------------
        // ------------------------------------------------------------------
        // ------------------------------------------------------------------
        // ------------------------------------------------------------------

        int[][] array = new int[size][size];

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                array[i][j] = 1;
            }
        }

        String[] direction = new String[]{"East","South","West","North"};

        int dir = 0;

        int index = 1;

        diggingLoop: while(true){

            if(dir == 0){

                array[index][index - 1] = 0;
            }

            boolean weDugAtLeastOnce = false;

            if(dir % 2 == 0){

                switch (direction[dir]){

                    case "East":

                        for (int i = index; i < array.length - index; i++) {

                            array[index][i] = 0;

                            weDugAtLeastOnce = true;
                        }

                        break;

                    case "West":

                        for (int i = array.length - index - 2; i >= index ; i--) {

                            array[array.length - index - 1][i] = 0;

                            weDugAtLeastOnce = true;
                        }

                        break;
                }
            }else{

                switch (direction[dir]){

                    case "South":

                        for (int i = index + 1; i <= array.length - index - 1; i++) {

                            array[i][array.length - index - 1] = 0;

                            weDugAtLeastOnce = true;
                        }

                        break;

                    case "North":

                        for (int i = array.length - index - 1; i >= index + 2 ; i--) {

                            array[i][index] = 0;

                            weDugAtLeastOnce = true;
                        }

                        break;
                }
            }

            if(weDugAtLeastOnce == false){

                break diggingLoop;
            }

            dir++;

            if(dir == 4){

                index += 2;
                dir = 0;
            }



        }

        return array;

        // ------------------------------------------------------------------
        // ------------------------------------------------------------------
        // ------------------------------------------------------------------
        // ------------------------------------------------------------------
        // ------------------------------------------------------------------
        // ------------------------------------------------------------------

    }

    static void printGrid(int[][] array){

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[0].length; j++) {

                if (array[i][j] == 0){
                    System.out.print(ANSI_RED + array[i][j] + " ");
                }
                else{
                    System.out.print(ANSI_YELLOW + array[i][j] + " ");
                }


            }
            System.out.println();
        }
    }

}