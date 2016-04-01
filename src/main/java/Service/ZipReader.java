package Service;

import Model.ZipModel;

import javax.servlet.http.Part;
import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * Created by HAMMAX on 31.03.2016.
 */
public class ZipReader {

        public ArrayList<ZipModel> versionOfReading(Part file) throws IOException {
            ArrayList<ZipModel> zipModelArrayList = new ArrayList<>();
            InputStream fileContent = file.getInputStream();
            ZipInputStream zipInputStream = new ZipInputStream(fileContent);
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                ZipModel model = new ZipModel();
                final String fileName = entry.getName();
                model.setFileName(fileName);
                BufferedReader br = new BufferedReader(new InputStreamReader(zipInputStream, "UTF-8"));
                String line;
                ArrayList<String> lines = new ArrayList<>();
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
                model.setFileEntities(lines);
                zipModelArrayList.add(model);
            }
            return zipModelArrayList;
        }
}
