
<%@page import="com.Dao.LogClass"%>
<%@page import="java.util.List"%>
<%@page import="com.Dao.DaoClass"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>feed</title>
        <link rel="styleSheet" href="style.css">
    </head>


    <body>
        <%
            HttpSession resSession = request.getSession(false);
            String result = (String) resSession.getAttribute("result");

            if (result == null) {
                response.sendRedirect("index.html");
            }
        %>


<!-- First div for result started-->         
        <div class="container">
            <div class="inner-div1" class ="inner-div" >
                <h2 id="result"><%=result%></h2>
            </div>
 <!-- First div for result end -->       




 <!-- 2nd div for form started -->
            <div class="inner-div2">  
                <body>      
                    <!-- form started -->
                    <div >
                        <form action="logs" method="post" >
                            
                            <label for="title">Title:</label>
                            <input type="text" id="title" name="title" required>

                            <label for="shortDescriptin">Short Description:</label>
                            <input type ="text" id="shortDescription" name="shortDescription" rows="4" required>   

                            <label for="logContent">Log Content:</label>
                            <textarea id="logContent" name="logContent" rows="4" ></textarea>
                            
                            <input type="number" id ="logId"  name="logId" value="-1" hidden>


                            <input type="submit" value="Submit">
                        </form>
                    </div>
            </div>
<!-- 2nd div for form end-->



<!-- 3rd div for log display started -->
            <div class="inner-div3"   >
                
                <%
                    DaoClass dao = new DaoClass();
                    List<LogClass> resultList = dao.getLogs();

                    for (LogClass lc : resultList) {

                        int id = lc.getId();
                        String title = lc.getTitle();
                        String logContent = lc.getLogContent();
                        String shortDescription = lc.getShortDescription();

                %>
                
                <div class="log" >

                    <div class="titlediv">
                        <h1 class="text" style="padding-top: 20px; padding-bottom: 0px; "  >  <%=title%></h1>
                        <div class="button-container" >
                            <button  ><a href="logs?id=<%= lc.getId()%>" style="text-decoration: none; color: white">Delete</a></button>
                            <button class="updateButton" data-title="<%=title%>" data-short-description="<%=shortDescription%>" data-log-content="<%=logContent%>"  data-id="<%=id%>" >Update</button>
                            

                        </div>
                    </div>   
                    <h4 class="text" style="padding-bottom: 10px;"><%=shortDescription%></h4>
                    <p class="text"> <%= logContent%>  </p>
                    <br>
                </div>

                <%
                    }
                %>
            </div>
        </div>
<!-- 3rd div for log display ended -->



<script>
  
  var updateButtons = document.querySelectorAll('.updateButton');
  updateButtons.forEach(function(button) {
    button.addEventListener('click', function() {
      var title = this.getAttribute('data-title');
      var shortDescription = this.getAttribute('data-short-description');
      var logContent = this.getAttribute('data-log-content');
      var id = this.getAttribute('data-id');

     
      document.getElementById('title').value = title;
      document.getElementById('shortDescription').value = shortDescription;
      document.getElementById('logContent').value = logContent;
      document.getElementById('logId').value=id;
      window.scrollTo(0, 0);
      
      
    });
  });
</script>



    </body>
</html>
