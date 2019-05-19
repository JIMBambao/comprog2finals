package edu.slu.prog2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
                boolean networkStatus = Boolean.valueOf( parts [9]);

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


    public Stream<Computer> ComputersUnderMaintenanceSortedByRoom (List <Computer> computerList){
        return computerList
                .stream()
                .filter(
                        computer -> computer.getMaintenanceStatus().equals("IN MAINTENANCE")
                )
                .sorted(
                        Comparator.comparing(Computer::getRoom)
                )
                .sorted(
                        Comparator.comparingInt(Computer::getPcNumber)
                );
    }

    public static Stream <Computer> ComputersMaintainedSortedByRoom (List <Computer> computerList){
        return computerList
                .stream()
                .filter(
                        computer -> computer.getMaintenanceStatus().equals("MAINTAINED")
                )
                .sorted(
                        Comparator.comparing(Computer::getRoom)
                )
                .sorted(
                        Comparator.comparingInt(Computer::getPcNumber)
                );
    }

    public static Stream <Computer> ComputersUnmaintainedSortedByRoom (List <Computer> computerList){
        return computerList
                .stream()
                .filter(
                        computer -> computer.getMaintenanceStatus().equals("UNMAINTAINED")
                )
                .sorted(
                        Comparator.comparing(Computer::getRoom)
                )
                .sorted(
                        Comparator.comparingInt(Computer::getPcNumber)
                );
    }

    public static Stream <Computer> ComputersNotUpdatedSortedByRoom (List <Computer> computerList){
        return computerList
                .stream()
                .filter(
                        computer -> computer.getUpdateStatus().equals("NOT UPDATED")
                )
                .sorted(
                        Comparator.comparing(Computer::getRoom)
                )
                .sorted(
                        Comparator.comparingInt(Computer::getPcNumber)
                );
    }


    public static Stream <Computer> ComputersUpdatingSortedByRoom (List <Computer> computerList){
        return computerList
                .stream()
                .filter(
                        computer -> computer.getUpdateStatus().equals("UPDATING")
                )
                .sorted(
                        Comparator.comparing(Computer::getRoom)
                )
                .sorted(
                        Comparator.comparingInt(Computer::getPcNumber)
                );
    }

    public static Stream <Computer> ComputersUpdatedSortedByRoom (List <Computer> computerList){
        return computerList
                .stream()
                .filter(
                        computer -> computer.getUpdateStatus().equals("UPDATED")
                )
                .sorted(
                        Comparator.comparing(Computer::getRoom)
                )
                .sorted(
                        Comparator.comparingInt(Computer::getPcNumber)
                );
    }



    public static void displayItems(List<Computer> computerList) {

        Map<Integer, Map<Integer, Set<Computer>>> allComputers = new TreeMap<>();


        /* building the data structure, version 1.. */

        for (Computer computer : computerList) {
            int pcNumber = computer.getPcNumber();
            int room = Integer.parseInt(computer.getRoom());

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

            pcList.add(computer);

        }

    }
    public static void displayComputersByUpdateStatus(List<Computer> computerList){
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
                                                        System.out::println
                                                );
                                            });
                        });

    }
    public static void displayComputerByMaintenanceStatus (List <Computer> computerList){
        computerList
                .stream()
                .collect(Collectors.groupingBy(Computer::getRoom))
                .forEach(
                        (room, roomList) ->{
                           System.out.printf ("\n\n*** Room: %s\n", room);
                            roomList
                                    .stream()
                                    .collect(Collectors.groupingBy(Computer::getMaintenanceStatus))
                                    .forEach(
                                            (maintenanceStatus, maintainStatusList) ->{
                                                System.out.printf("\n* %s %d\n", room, maintenanceStatus);

                                                maintainStatusList
                                                        .forEach(
                                                                computer -> System.out.println(computer)
                                                        );
                                            });
                        });

    }
    public static void displayMAC(List<Computer> computerList){
       /* List<Computer> collect = computerList
                .stream()
                .filter(c -> Boolean.parseBoolean(c.getOperatingSystem()))
                .collect(Collectors.toList());
        assert(collect).contains("MAC");*/
        List<Computer> computers = computerList
                .stream()
                .filter(c -> c.getOperatingSystem().equals("MAC")).collect(Collectors.toList());
    }
    public static void displayWindows(List<Computer> computerList){
        List<Computer> computers = computerList
                .stream()
                .filter(x -> x.getOperatingSystem().equals("WINDOWS")).collect(Collectors.toList());
    }
    public void filterOnline(){
        List<Computer> list = new ArrayList<>();
        list.stream().filter(comp -> comp.equals("ONLINE")).forEach(System.out::println);
    }

}