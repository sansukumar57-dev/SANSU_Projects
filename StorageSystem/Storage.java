package StorageSystem;

public abstract class Storage extends BaseFunctionality implements StorageInterface{

    public void uploadFile(int files){
        int usedSpace=files*100;


        System.out.println("File Uploaded");
        System.out.println("Used Space:"+usedSpace+"MB");
    }
    public void deleteFiles(){
        System.out.println("File Deleted");
    }


}
