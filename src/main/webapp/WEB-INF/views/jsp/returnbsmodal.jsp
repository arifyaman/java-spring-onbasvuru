<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${modal_show != null}">
<div class="modal fade" id="modal_message" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="${modal_type}">
  			<strong><b>${modal_title}</strong></b><br> ${modal_body}
			</div>
      </div>
      
    </div>
</c:if>