<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<t:baseLayout>
  <jsp:attribute name="title">${mockup.name}</jsp:attribute>
  <jsp:attribute name="head">
    <link href="/css/sidebar.css" type="text/css" rel="stylesheet">
    <jsp:include page="/WEB-INF/templates/parts/widgets.jsp" />
  </jsp:attribute>
  <jsp:body>
	<div id="wrapper">
      <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
          <li class="sidebar-brand">
            Elements
          </li>          
          <li>
            <label class="control-label">Title</label>
            <div class="mk mk-title">This is a title</div>
          </li>
          <li>
            <label class="control-label">Label</label>
            <div id="create-label" class="ui-widget-content mk mk-label" style="position: relative;">Label:</div>
            <script>
            	$('#create-label').click(function(){
            		var label = new Label();
            		label.setText("New label");
            		label.draw();
            	})
            </script>
          </li>
          <li>
            <label class="control-label">Input</label>
            <div class="mk mk-input">
              <span class="form-control"></span>
            </div>
          </li>
          <li>
            <label class="control-label">Button</label>
            <div class="mk mk-button">
              <button class="btn btn-primary">Press me!</button>
            </div>
          </li>
        </ul>
      </div>
      <div id="page" style="height:100%; margin-left:250px; position:fixed;">
      </div>
      <div class="container">
        <h4>${mockup.name}</h4>
        <div id="myModal" class="modal fade" style="overflow-y: auto;">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        <h4 class="modal-title"></h4>
		      </div>
		      <div class="modal-body">
		      </div>
	          <div class="modal-footer">
	            <button type="button" id="close" class="btn btn-default" data-dismiss="modal">Close</button>
	            <button type="button" id="save-changes" class="btn btn-primary">Save changes</button>
	          </div>
		    </div>
		   </div>
		</div>
      </div>
	</div>
  </jsp:body>
</t:baseLayout>
