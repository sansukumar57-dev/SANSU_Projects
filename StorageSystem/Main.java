package StorageSystem;

public class Main {

    public static void main(String[] args) {

User user1= new User();
User user2= new User();
LocalStorage localStorage=new LocalStorage();
CloudStorage cloudStorage=new CloudStorage();

user1.setStorageType("CLOUD");
user1.setFiles(2);
user1.setStorageId(7);
user1.setUsedSpace(5);
cloudStorage.setUsedSpace(user1.getUsedSpace());
if(user1.getStorageType()=="CLOUD"){
    System.out.println("===== USER 1: CLOUD =====");
    cloudStorage.uploadFile(user1.getFiles());
    cloudStorage.syncDevices();

}



user2.setStorageType("LOCAL");
user2.setFiles(2);
user2.setStorageId(7);
user2.setUsedSpace(5);
localStorage.setUsedSpace(user2.getUsedSpace());
if(user2.getStorageType()=="LOCAL"){
    System.out.println("===== USER 2: LOCAL =====");
    localStorage.uploadFile(user1.getFiles());
    localStorage.createBackup();
}





    }
}
