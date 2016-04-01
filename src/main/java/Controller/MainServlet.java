package Controller;

import Model.ZipModel;
import Service.FileService;
import Service.ZipReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;


/**
 * Created by HAMMAX on 30.03.2016.
 */
@WebServlet("/")
@MultipartConfig
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("name");
        Part filePart = request.getPart("fileInput");
        ZipReader zipReader = new ZipReader();
        FileService fileService = new FileService();

        request.setAttribute("values",fileService.putAllProductsInOrderByFirstLetter(fileService.listOfProducts(zipReader.versionOfReading(filePart))));
        request.setAttribute("model",zipReader.versionOfReading(filePart));

        if(!fileService.findByProduct(zipReader.versionOfReading(filePart) , product).isEmpty()) {
            request.setAttribute("nameOfFile", fileService.findByProduct(zipReader.versionOfReading(filePart), product));
            request.setAttribute("nameOfProduct" , product);
        }else{
            request.setAttribute("nameOfFile", "File NOT FOUND!!!!");
            request.setAttribute("nameOfProduct" , "File NOT FOUND!!!!");
        }
        request.getRequestDispatcher("result.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("home.jsp").forward(request,response);
    }
}
