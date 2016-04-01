<%--
  Created by IntelliJ IDEA.
  User: HAMMAX
  Date: 01.04.2016
  Time: 1:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div align="center">
  <img src="http://www.zip.uz/picture_library/Zip-icon.png" class="img-rounded" height="256px" width="256px"/>
  <script type="text/javascript">
    $(function error()  {
      $('form').submit(function() {
        if(!$("form input[type=file]").val()) {
          alert('You must select a file!');
          return false;
        }
      });
    });
  </script>
  <script type="text/JavaScript">
    var _validFileExtensions = [".zip", ".rar"];
    function Validate(oForm) {
      var arrInputs = oForm.getElementsByTagName("input");
      for (var i = 0; i < arrInputs.length; i++) {
        var oInput = arrInputs[i];
        if (oInput.type == "file") {
          var sFileName = oInput.value;
          if (sFileName.length >= 0) {
            var blnValid = false;
            for (var j = 0; j < _validFileExtensions.length; j++) {
              var sCurExtension = _validFileExtensions[j];
              if (sFileName.substr(sFileName.length - sCurExtension.length, sCurExtension.length).toLowerCase() == sCurExtension.toLowerCase()) {
                blnValid = true;
                break;
              }
            }

            if (!blnValid) {
              alert("Please choose right file with extension .zip or .rar");
              return false;
            }
          }
        }
      }

      return true;
    }
  </script>

  <form action="MainServlet"  method="post" enctype="multipart/form-data" onsubmit="return Validate(this); " >

    <input type="file" name="fileInput" id="fileInput" class="btn btn-success"  />
    <br> <br>

      <div class="form-group">
       <div class="input-group">
         <label class="sr-only" for="name">Name of product</label>
          <div class="input-group-addon">Search By Name Of Product in Upload file</div>
          <input type="text" class="form-control" name="name" id="name" placeholder="Product">
        </div>
      </div>
    <input type="submit" class="btn btn-primary" value="submit" name="submit"/>
  </form>
</div>
</body>
</html>
