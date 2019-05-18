package edu.slu.prog2;

public class Labels {
    private int room, pcno;
    private String updateStatus, MaintainStatus, os;

    public Labels(String updateStatus, String MaintainStatus, String os, int room, int pcno){
        this.updateStatus = updateStatus;
        this.MaintainStatus = MaintainStatus;
        this.os = os;
        this.pcno = pcno;
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

    public int getPcno() {
        return this.pcno;
    }

    public int getRoom() {
        return this.room;
    }

    public String toString(){
        return String.format("%s %-25s %-8s %d %.2f",this.getUpdateStatus(),this.getMaintainStatus(),this.getOs(),
                this.getPcno(),this.getOs());
    }

}
