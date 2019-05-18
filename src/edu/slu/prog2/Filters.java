package edu.slu.prog2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

class Filter{

    public static void main(String[] args) {
        List<Labels> computerList = readDataFileIntoList("D:\\FinalProjectFinalsLecture\\data\\Computer_Lists.csv");

        displayItems(computerList);

    }
    public static List<Labels> readDataFileIntoList(String filename) {
        try {
            ArrayList<Labels> computerList = new ArrayList<>();

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
                int pcno = Integer.parseInt(parts[4]);

                Labels labels = new Labels(updateStatus,maintainStatus,os,room,pcno);

                computerList.add(labels);
            } while (true);

            br.close();

            return computerList;

        } catch (Exception e) {
            throw new RuntimeException("Data file read error.");
        }
    }

    public static void displayItems(List<Labels> computerList) {

        Map<Integer, Map<Integer, Set<Labels>>> allComputers = new TreeMap<>();


        /* building the data structure, version 1.. */

        for (Labels labels : computerList) {
            int pcno = labels.getPcno();
            int room = labels.getRoom();

            Map<Integer, Set<Labels>> roomList = allComputers.get(room);

            if (roomList == null) {
                roomList = new TreeMap<>();
                allComputers.put(room, roomList);
            }

            Set<Labels> pcList = roomList.get(pcno);

            if (pcList == null) {
                pcList = new TreeSet<>();
                roomList.put(pcno, pcList);
            }

            pcList.add(labels);
        }
    }
}
