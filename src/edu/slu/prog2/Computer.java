package edu.slu.prog2;

public class Computer implements Comparable <Computer> {
    private int room, pcNumber;
    private String updateStatus, MaintainStatus, os;

    public Computer (String updateStatus, String MaintainStatus, String os, int room, int pcNumber){
        this.updateStatus = updateStatus;
        this.MaintainStatus = MaintainStatus;
        this.os = os;
        this.pcNumber = pcNumber;
        this.room = room;
    }

    public String getUpdateStatus() {
        return this.updateStatus;
    }

    public String getMaintainStatus() {
        return this.MaintainStatus;
    }

    public String getOs() {
        return this.os;
    }

    public int getPcNumber() {
        return this.pcNumber;
    }

    public int getRoom() {
        return this.room;
    }

    public String toString(){
        return String.format("%s %-25s %-8s %d %.2f",this.getUpdateStatus(),this.getMaintainStatus(),this.getOs(),
                this.getPcNumber(),this.getRoom());
    }

    public int compareTo (Computer other){
        return this.getPcNumber().compareTo(other.getPcNumber);
        }

}
