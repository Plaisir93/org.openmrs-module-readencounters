<%@ include file="/WEB-INF/template/include.jsp"%>

<%@ include file="/WEB-INF/template/header.jsp"%>

<h2><spring:message code="theencounters-omod.title" /></h2>

<br/>
<table>
  <tr>
   <th>Patient Id</th>
   <th>Creator</th>
   <th>Date Created</th>
   <th>Date Changed</th>
  </tr>
  <c:forEach var="patient" items="${patients}">
      <tr>
        <td>${patient.patientId}</td>
        <td>${patient.creator}</td>
        <td>${patient.dateCreated}</td>
        <td>${patient.dateChanged}</td>
      </tr>		
  </c:forEach>
</table>

<%@ include file="/WEB-INF/template/footer.jsp"%>
