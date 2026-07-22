package StorageSystem;



public abstract class BaseFunctionality implements BaseFunctionalityInterface {
    private int  storageId, usedSpace;

    public int getStorageId() {
        return this.storageId;
    }

    public void setStorageId(int storageId) {
        this.storageId = storageId;
    }

    public int getUsedSpace() {
        return this.usedSpace;
    }

    public void setUsedSpace(int usedSpace) {
        this.usedSpace = usedSpace;
    }
}
