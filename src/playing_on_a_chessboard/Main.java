package playing_on_a_chessboard;

import java.lang.reflect.Array;

// 6 kyu
class Main{

    public static void main(String[] args) {

        String game = game(1);

        System.out.println("game = " + game);
    }

    static String game(long n){

        if(n % 2 == 0){

            return "[" + n * n / 2 + "]";
        }else {

            return "[" + ( n * n ) + ", 2]";
        }
    }

}