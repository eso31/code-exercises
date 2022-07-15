package com.cracking.coding.interview.ood.minesweeper;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        MineSweeper mineSweeper = new MineSweeper(10, 5);
        mineSweeper.prettyPrintHidden();

        Scanner myScanner = new Scanner(System.in);

        while (true) {
            System.out.println("1) Mark a flag");
            System.out.println("2) Write a coordinate to expose cell");
            System.out.println("3) Exit");
            System.out.println("Choose an option: ");
            String option = myScanner.nextLine();

            switch (option) {
                case "1":
                    markCellWithFlag(mineSweeper);
                    break;
                case "2":
                    writeCoordinate(mineSweeper);
                    break;
                case "3":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Not a valid option");
            }
        }
    }

    private static void markCellWithFlag(MineSweeper mineSweeper) {
        Position position = getPositionIndex();
        mineSweeper.markCellWithFlag(position.getRow(), position.getColumn());
    }

    private static void writeCoordinate(MineSweeper mineSweeper) throws Exception {
        Position position = getPositionIndex();
        mineSweeper.exposeCell(position.getRow(), position.getColumn());
    }

    private static Position getPositionIndex() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Write a coordinate in the form x,y: ");
        String position = myScanner.nextLine();
        List<Integer> positions = Arrays.stream(position.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        return new Position(positions.get(0), positions.get(1));
    }
}
