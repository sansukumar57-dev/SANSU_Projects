package StorageSystem;

public class User extends BaseFunctionality implements UserInterface {

    private String storageType;
    private  int files;

    public String getStorageType() {
        return this.storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public int getFiles() {
        return this.files;
    }

    public void setFiles(int files) {
        this.files = files;
    }
}
