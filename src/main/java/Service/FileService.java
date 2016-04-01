package Service;

import Model.SortedFileModel;
import Model.ZipModel;

import java.util.ArrayList;

/**
 * Created by HAMMAX on 31.03.2016.
 */
public class FileService {
    public String findByProduct(ArrayList<ZipModel> zipModelArrayList,String nameOfProduct){
        String nameOfTextFile ="";
        boolean a =false;
        for(ZipModel model : zipModelArrayList){
          String  nameOfTextFiles = model.getFileName();
            for(String values : model.getFileEntities()){
                if(values.equals(nameOfProduct)){
                    a = true;
                    nameOfTextFile = nameOfTextFiles;

                }

            }

        }
        if(a)
        return nameOfTextFile;
        else return "";
    }

    public ArrayList<String> listOfProducts(ArrayList<ZipModel> zipModelArrayList){
        ArrayList<String> listFromFilesInArchive = new ArrayList<>();
        for(ZipModel zipModel : zipModelArrayList){
            for (String list:zipModel.getFileEntities()){
                listFromFilesInArchive.add(list);
            }
        }
        return listFromFilesInArchive;
    }

    public ArrayList<SortedFileModel> putAllProductsInOrderByFirstLetter(ArrayList<String> arrayList) {
        ArrayList<SortedFileModel> sortedFileModels = new ArrayList<>();
        for (char a = 'a'; a <= 'z'; a++) {
            SortedFileModel sortedFileModel = new SortedFileModel();
            ArrayList<String> product = new ArrayList<>();
            for (String values : arrayList) {
                if (values.toLowerCase().startsWith(String.valueOf(a))) {
                    sortedFileModel.setLetter(String.valueOf(a).toUpperCase());
                    product.add(values);
                }
            }
            if (sortedFileModel.getLetter() != null) {
                sortedFileModel.setProducts(product);
                sortedFileModels.add(sortedFileModel);
            }
        }
        for (char a = 'à'; a <= 'ÿ'; a++) {
            SortedFileModel sortedFileModel = new SortedFileModel();
            ArrayList<String> product = new ArrayList<>();
            for (String values : arrayList) {
                if (values.toLowerCase().startsWith(String.valueOf(a))) {
                    sortedFileModel.setLetter(String.valueOf(a).toUpperCase());
                    product.add(values);
                }
            }
            if (sortedFileModel.getLetter() != null) {
                sortedFileModel.setProducts(product);
                sortedFileModels.add(sortedFileModel);
            }
        }
        return sortedFileModels;
    }


}
