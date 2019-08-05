<%@ include file="/WEB-INF/template/include.jsp"%>

<%@ include file="/WEB-INF/template/header.jsp"%>

<h2><spring:message code="theencounters-omod.title" /></h2>

<br/>
<table>
  <tr>
   <th>Visit Id</th>
   <th>Visit Type Id</th>
   <th>Date Started</th>
   <th>Date Stopped</th>
  </tr>
  <c:forEach var="visit" items="${visits}">
      <tr>
        <td>${visit.visitId}</td>
        <td>${visit.visitTypeId}</td>
        <td>${visit.dateStarted}</td>
        <td>${visit.dateStopped}</td>
      </tr>		
  </c:forEach>
</table>

<%@ include file="/WEB-INF/template/footer.jsp"%>
