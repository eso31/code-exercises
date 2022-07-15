package com.codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PunchedCards {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int cases = Integer.parseInt(br.readLine());
//
//        for (int caseNumber = 1; caseNumber <= cases; caseNumber++) {
//            String[] input = br.readLine().split(" ");
//
//            System.out.println("Case #" + caseNumber + ":");
//            printPunchedCards(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
//        }

        printPunchedCards(2,2);
    }

    private static void printPunchedCards(int r, int c) {
        for (int row = 0; row < r; row++) {
            for (int i = 0; i < 2; i++) {
                for (int column = 0; column < c; column++) {
                    if (column == 0 && row == 0) {
                        System.out.print("..");
                    } else {
                        if (i == 0) {
                            if (column == c-1) {
                                System.out.print("+-+");
                            } else {
                                System.out.print("+-");
                            }
                        } else {
                            if (column == c-1) {
                                System.out.print("|.|");
                            } else {
                                System.out.print("|.");
                            }
                        }
                    }
                }
                System.out.println();
            }
        }
        for (int column = 0; column < c; column++) {
            System.out.print("+-");
        }
        System.out.println("+");
    }


}
