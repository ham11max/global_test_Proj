package Model;

import java.util.ArrayList;

/**
 * Created by HAMMAX on 31.03.2016.
 */
public class ZipModel {
    String fileName;
    ArrayList <String> fileEntities = new ArrayList();

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String filesName) {
        this.fileName = filesName;
    }

    public ArrayList<String> getFileEntities() {
        return fileEntities;
    }

    public void setFileEntities(ArrayList<String> fileEntities) {
        this.fileEntities = fileEntities;
    }


}
