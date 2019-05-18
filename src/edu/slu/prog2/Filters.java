import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Filter{

    public static void main(String[] args) {
        List<Labels> computerList = readDataFileIntoList("C:\\Users\\Geyl\\Desktop\\FinalProjectFinalsLecture\\data\\Computer_Lists.csv");
        List<String> stringList = getMac(computerList, "MAC");


        displayItems(computerList);
        System.out.println(stringList);

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

    public static List<String> getMac(List<Labels> computerList, String match){
        List<String> macList = null;

        try(Stream<String> stream = Files.lines(computerList)){
            macList = stream.filter(line -> line.contains(match)).collect(Collectors.toList());
        }catch(IOException ioe){

        }
        return macList;
    }

}
