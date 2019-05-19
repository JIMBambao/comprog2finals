package edu.slu.prog2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

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

                String room = parts[0];
                int pcNumber = Integer.parseInt(parts[1]);
                String updateStatus = parts[2];
                String maintenanceStatus = parts[3];
                String operatingSystem = parts[4];
                String IPAddress = parts[5];
                String IPAddressV6 = parts[6];
                String MACAddress = parts[7];
                String RAMAmount = parts [8];
                String networkStatus = parts [9];

                Computer computer = new Computer(room, pcNumber,updateStatus,maintenanceStatus, operatingSystem, IPAddress,
                        IPAddressV6, MACAddress,RAMAmount, networkStatus);

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
            int pcNumber = computer.getPcNumber();
            int room = computer.getRoom();

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

            Map <String, Set <Computer>> updateStatusList = pcNumber.get(updateStatus);
            if (updateStatusList == null){
                updateStatusList = new TreeMap <>();
                updateStatusList.put(updateStatus, updateStatusList);
            }

            Map <String, Set<Computer>> maintainStatusList =
                    maintainStatusList.computeIfAbsent{
                maintainStatus, k -> new TreeMap<>();
            }
        }

    }
    public static void displayComputersbyUpdateStatus(List<Computer> computerList){
        computerList
                .stream()
                .collect(Collectors.groupingBy(Computer::getRoom))
                .forEach(
                        (room, roomList) ->{
                            System.out.printf ("\n\n*** Room: %s\n", room);

                            roomList
                                    .stream()
                                    .collect(Collectors.groupingBy(Computer::getUpdateStatus))
                                    .forEach(
                                            (updateStatus, updateStatusList) ->{
                                                System.out.printf("\n* %s %d\n", room, updateStatus);

                                                updateStatusList.forEach(
                                                        computer -> System.out.println(computer));
                                            });
                        });
                //ano yung status frens? omg hahahahahaha sorry
    }
    /*public static void displayComputerByMaintainStatus (List <Computer> computerList){
        computerList
                .forEach(
                        (room, roomList) ->{
                            ("\n\n*** Room: %s\n", room);

                            roomList
                                    .forEach(
                                            (maintainStatus, maintainStatusList) ->{
                                                System.out.printf("\n* %s %d\n", room, maintainStatus);

                                                maintainStatusList
                                                        .forEach(
                                                                computer -> System.out.println(student)
                                                        );
                                            });
                        });

    }*/
    public static void displayComputerByOS(List<Computer> computerList){
       /* List<Computer> collect = computerList
                .stream()
                .filter(c -> Boolean.parseBoolean(c.getOperatingSystem()))
                .collect(Collectors.toList());
        assert(collect).contains("MAC");*/
        computerList
                .stream()
                .collect(Collectors.groupingBy(Computer::getOperatingSystem))
                .forEach(
                        (os, macList) ->{
                            System.out.printf ("\n\n*** OS: %s\n", os);

                            macList
                                    .stream()
                                    .collect(Collectors.groupingBy(Computer::getUpdateStatus))
                                    .forEach(
                                            (updateStatus, updateStatusList) ->{
                                                System.out.printf("\n* %s %d\n", os, updateStatus);

                                                updateStatusList.forEach(
                                                        computer -> System.out.println(computer));
                                            });
                        });
    }

}
