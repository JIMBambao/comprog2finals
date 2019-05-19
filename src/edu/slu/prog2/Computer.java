package edu.slu.prog2;

public class Computer {
    private String room, updateStatus, maintenanceStatus, operatingSystem, IPAdress, IPAdressV6, MACAddress, RAMAmount, networkStatus;
    private int pcNumber;

    public Computer(String room,int pcNumber, String updateStatus, String maintenanceStatus, String operatingSystem,
                    String IPAdress, String IPAdressV6, String MACAddress, String RAMAmount,
                    String networkStatus) {
        this.room = room;
        this.updateStatus = updateStatus;
        this.maintenanceStatus = maintenanceStatus;
        this.operatingSystem = operatingSystem;
        this.IPAdress = IPAdress;
        this.IPAdressV6 = IPAdressV6;
        this.MACAddress = MACAddress;
        this.RAMAmount = RAMAmount;
        this.networkStatus = networkStatus;
        this.pcNumber = pcNumber;
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

    public String getIPAdress() {
        return IPAdress;
    }

    public void setIPAdress(String IPAdress) {
        this.IPAdress = IPAdress;
    }

    public String getIPAdressV6() {
        return IPAdressV6;
    }

    public void setIPAdressV6(String IPAdressV6) {
        this.IPAdressV6 = IPAdressV6;
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

    public String getNetworkStatus() {
        return networkStatus;
    }

    public void setNetworkStatus(String networkStatus) {
        this.networkStatus = networkStatus;
    }

    public int getPcNumber() {
        return pcNumber;
    }

    public void setPcNumber(int pcNumber) {
        this.pcNumber = pcNumber;
    }
}
