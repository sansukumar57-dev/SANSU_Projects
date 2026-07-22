package StorageSystem;

public class LocalStorage extends Storage implements LocalStorageInterface{

    public void createBackup(){
        System.out.println("Backup Created");
    }
}
