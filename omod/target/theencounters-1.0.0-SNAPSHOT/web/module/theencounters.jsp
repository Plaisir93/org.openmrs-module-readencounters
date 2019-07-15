<%@ include file="/WEB-INF/template/include.jsp"%>

<%@ include file="/WEB-INF/template/header.jsp"%>

<h2><spring:message code="theencounters-omod.title" /></h2>

<br/>
<table>
  <tr>
   <th>Encounter Id</th>
   <th>Encounter Type</th>
   <th>Encounter Date Time</th>
   <th>Encounter Date Created</th>
  </tr>
  <c:forEach var="encounter" items="${encounters}">
      <tr>
        <td>${encounter.encounterId}</td>
        <td>${encounter.encounterType}</td>
        <td>${encounter.encounterDateTime}</td>
        <td>${encounter.dateCreated}</td>
      </tr>		
  </c:forEach>
</table>

<%@ include file="/WEB-INF/template/footer.jsp"%>
