<%@ include file="/WEB-INF/template/include.jsp"%>

<%@ include file="/WEB-INF/template/header.jsp"%>

<h2><spring:message code="plr-omod.title" /></h2>
<br />
<h4>This is the list of observations from 2019-03-6 to 2019-03-7</h4>
<br/>
<table>
  <tr>
   <th>Obs Id</th>
   <th>Obs Concept</th>
   <th>Obs Date Time</th>
  </tr>
  <c:forEach var="observation" items="${observations}">
      <tr>
        <td>${observation.obsId}</td>
        <td>${observation.concept}</td>
       <td>${observation.obsDatetime}</td>
      </tr>		
  </c:forEach>
</table>

<%@ include file="/WEB-INF/template/footer.jsp"%>
