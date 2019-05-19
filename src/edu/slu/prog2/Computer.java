package edu.slu.prog2;

public class Computer{
        //implements Comparable <Computer>{
    private String room, updateStatus, maintenanceStatus, operatingSystem, IPAddress, IPAddressV6, MACAddress, RAMAmount;
    private boolean networkStatus;
    private int pcNumber;

    public Computer(String room,int pcNumber, String updateStatus, String maintenanceStatus, String operatingSystem,
                    String IPAddress, String IPAddressV6, String MACAddress, String RAMAmount,
                    boolean networkStatus) {
        this.room = room;
        this.pcNumber = pcNumber;
        this.updateStatus = updateStatus;
        this.maintenanceStatus = maintenanceStatus;
        this.operatingSystem = operatingSystem;
        this.IPAddress = IPAddress;
        this.IPAddressV6 = IPAddressV6;
        this.MACAddress = MACAddress;
        this.RAMAmount = RAMAmount;
        this.networkStatus = networkStatus;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(String updateStatus) {
        this.updateStatus = updateStatus;
    }

    public String getMaintenanceStatus() {
        return maintenanceStatus;
    }

    public void setMaintenanceStatus(String maintenanceStatus) {
        this.maintenanceStatus = maintenanceStatus;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }

    public String getIPAddressV6() {
        return IPAddressV6;
    }

    public void setIPAddressV6(String IPAddressV6) {
        this.IPAddressV6 = IPAddressV6;
    }

    public String getMACAddress() {
        return MACAddress;
    }

    public void setMACAddress(String MACAddress) {
        this.MACAddress = MACAddress;
    }

    public String getRAMAmount() {
        return RAMAmount;
    }

    public void setRAMAmount(String RAMAmount) {
        this.RAMAmount = RAMAmount;
    }

    public boolean getNetworkStatus() {
        return networkStatus;
    }

    public void setNetworkStatus(boolean networkStatus) {
        this.networkStatus = networkStatus;
    }

    public int getPcNumber() {
        return pcNumber;
    }

    public void setPcNumber(int pcNumber) {
        this.pcNumber = pcNumber;
    }

//    public int compareTo(Computer other) {
//        return this.getPcNumber().compareTo(other.getPcNumber());
//    }
}
