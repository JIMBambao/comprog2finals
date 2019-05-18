package edu.slu.prog2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

class Filter{

    public static void main(String[] args) {
        List<Computer> computerList = readDataFileIntoList("D:\\FinalProjectFinalsLecture\\data\\Computer_Lists.csv");

        displayItems(computerList);

    }
    public static List<Computer> readDataFileIntoList(String filename) {
        try {
            ArrayList<Computer> computerList = new ArrayList<>();

            BufferedReader br = new BufferedReader(new FileReader(filename));

            do {
                String line = br.readLine();
                if (line == null)
                    break;

                String[] parts = line.split("[,]");

                String updateStatus = parts[0];
                String maintainStatus = parts[1];
                String os = parts[2];
                int room = Integer.parseInt(parts[3]);
                int pcNumber = Integer.parseInt(parts[4]);

                Computer computer = new Computer(updateStatus,maintainStatus,os,room,pcNumber);

                computerList.add(computer);
            } while (true);

            br.close();

            return computerList;

        } catch (Exception e) {
            throw new RuntimeException("Data file read error.");
        }
    }

    public static void displayItems(List<Computer> computerList) {

        Map<Integer, Map<Integer, Set<Computer>>> allComputers = new TreeMap<>();


        /* building the data structure, version 1.. */

        for (Computer computer : computerList) {
            int pcNumber = labels.getPcNumber();
            int room = labels.getRoom();

            Map<Integer, Set<Computer>> roomList = allComputers.get(room);

            if (roomList == null) {
                roomList = new TreeMap<>();
                allComputers.put(room, roomList);
            }

            Set<Computer> pcList = roomList.get(pcNumber);

            if (pcList == null) {
                pcList = new TreeSet<>();
                roomList.put(pcNumber, pcList);
            }

            pcList.add(Computer);
        }
    }
    public static void displayComputersbyStatus(List<Computer> computerList){
        computerList
                .stream()
                .collect(Collectors.groupingBy(Computer::))
                //ano yung status frens? omg hahahahahaha sorry
    }
}
