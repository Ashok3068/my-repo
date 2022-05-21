package com.springboot.demo.demo;

import java.util.ArrayList;
import java.util.List;

public class SudokoSolver2 {

    public static void main(String[] args) {
        char[][] c = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        long l = System.currentTimeMillis();
       // solveSudoku(c);
        for(int i=0;i<15;i++)
        permute("abc".toCharArray(),3);
        long l2 = System.currentTimeMillis();




        System.out.println("time taken" + (l2 - l));

    }

    static char[][] dupBoard;

    static char[] validChar;
    static List<String> validInsertedChars = new ArrayList<>();
    static int count = 0;
    static List<List<String>> string;
    static boolean sudokoNotDone = true;

    public static void solveSudoku(char[][] board) {

        dupBoard = new char[board.length][board[0].length];
        string = new ArrayList<>();
        arrangeSudoku(board, 0, board[0].length);

    }


    public static void arrangeSudoku(char[][] board, int row, int columnsLength) {

        int rowslength = board.length;
        while (sudokoNotDone && row < rowslength) {
            int col = 0;
            char[] currentClumn = new String(board[row]).toCharArray();
            char[] validChar = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
            char[] validChar1 = getValidChar(currentClumn, validChar);
            if (count != 0 && count >= validInsertedChars.size()) {
                validInsertedChars=  new ArrayList<>();
                permute(validChar1, validChar1.length);
                int j = 0;
                while (string.size() != 0 && j < string.get(row).size()) {
                    System.out.println(string.get(row).get(j));

                    while (validInsertedChars.contains(string.get(row).get(j))) {
                        int ind = validInsertedChars.indexOf(string.get(row).get(j));

                        validInsertedChars.remove(ind);


                    }
                    ++j;
                }
                while (string.size() > row + 1) {
                    string.remove(row + 1);

                }


            } else {
                validInsertedChars=  new ArrayList<>();
                permute(validChar1, validChar1.length);
            }
            count = 0;
            currIndex = 0;

            while (col < columnsLength && sudokoNotDone) {
                char c='-';

                if (count >= validInsertedChars.size()) {
                    row = row - 1;
                    board[row] = dupBoard[row];
                    arrangeSudoku(board, row, columnsLength);
                    break;

                }
                validChar = validInsertedChars.get(count).toCharArray();

                if (currentClumn[col] == '.') {

                    try {
                        c = getCurrentElement(currentClumn, validChar[currIndex], board, row, col);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }


                    if (c == '-') {
                        col = 0;
                        count++;
                        currIndex = 0;
                        currentClumn = new String(board[row]).toCharArray();

                    } else {
                        currentClumn[col] = c;
                        col++;
                        currIndex++;
                    }


                } else {

                    col++;
                }

            }
            if (sudokoNotDone) {

                if (string.size() <= row)
                    string.add(new ArrayList<>());
                string.get(row).add(validInsertedChars.get(count));
                dupBoard[row] = new String(board[row]).toCharArray();
                board[row] = currentClumn;
                if (row == 8) {
                    sudokoNotDone = false;
                }

                row++;
            } else {
                return;
            }


        }


    }

    public static boolean checkSquare(char[][] board, char c, int starRow, int endRow, int colStart, int colEnd) {

        int rowStart = starRow;
        int rowEnd = endRow;

        int endCol = colEnd;

        while (rowStart <= rowEnd) {
            int startCol = colStart;

            while (startCol <= endCol) {
                try {
                    if (board[rowStart][startCol] == c) {
                        return false;
                    }
                } catch (Exception e) {
                    System.out.println("failed" + currIndex);
                }
                ++startCol;

            }
            ++rowStart;
        }


        return true;

    }

    public static boolean checkRow(char[] row, char currIndex) {

        int i = 0;

        while (i < row.length) {

            if (row[i] == currIndex) {
                return false;
            }
            i++;

        }

        return true;

    }


    public static int[] getSquare(int x) {

        if (x <= 2) return new int[]{0, 2};
        else if (x <= 5 && x > 2) return new int[]{3, 5};
        else return new int[]{6, 8};

    }

    static int currIndex = 0;

    public static char getCurrentElement(char[] checkingRow, char currentChar, char[][] board, int currentRow, int currentColumn) {

        int[] startEndPoint = getSquare(currentRow);
        int rowStartPoint = startEndPoint[0];
        int rowStartEndPoint = startEndPoint[1];
        startEndPoint = getSquare(currentColumn);
        int colStartPoint = startEndPoint[0];
        int colStartEndPoint = startEndPoint[1];


        try {

            if (checkSquare(board, currentChar, rowStartPoint, rowStartEndPoint, colStartPoint, colStartEndPoint) &&
                    checkRow(checkingRow, currentChar) && checkRow(getColumn(board, currentColumn), currentChar)) {


                return currentChar;
            } else {
                return '-';

            }
        } catch (Exception e) {
            e.printStackTrace();
            return '-';
        }


    }

    public static char[] getValidChar(char[] row, char[] chars) {


        int length = 0;
        int i = 0;
        while (i < row.length) {
            int j = 0;
            while (j < row.length) {
                if (row[i] == chars[j]) {
                    chars[j] = '-';
                    ++length;
                }
                j++;
            }
            i++;
        }
        int i1 = 0;
        int j = 0;
        char[] newChars = new char[row.length - length];
        while (i1 < chars.length) {
            if (chars[i1] != '-') {
                newChars[j] = chars[i1];
                ++j;
            }
            ++i1;

        }

        return newChars;
    }


    public static void permute(char[] ourArray, int currentPosition) {
        if (currentPosition == 1) {
            validInsertedChars.add(new String(ourArray));
        } else {
            for (int i = 0; i < currentPosition; i++) {
                // subtract one from the last position (here is where you are
                // selecting the the next last item
                permute(ourArray, currentPosition - 1);

                // if it's odd position
                if (currentPosition % 2 == 1) {
                    swap(ourArray, 0, currentPosition - 1);
                } else {
                    swap(ourArray, i, currentPosition - 1);
                }
            }
        }
    }

    private static void swap(char[] ourarray, int right, int left) {
        char temp = ourarray[right];
        ourarray[right] = ourarray[left];
        ourarray[left] = temp;
    }

    public static char[] getColumn(char[][] board, int i) {
        char[] chars = new char[board[0].length];
        int j = 0;
        while (j < chars.length) {
            chars[j] = board[j][i];
            j++;
        }
        return chars;

    }
}
