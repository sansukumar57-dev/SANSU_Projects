package StorageSystem;



public interface UserInterface extends BaseFunctionalityInterface {
    public String getStorageType();
    public void setStorageType(String storageType) ;
    public int getFiles();
    public void setFiles(int files);

}
