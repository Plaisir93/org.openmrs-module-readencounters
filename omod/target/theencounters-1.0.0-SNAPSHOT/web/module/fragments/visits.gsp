<table>
  <tr>
   <th>Visit Id</th>
   <th>Patient</th>
   <th>Visit Type</th>
   <th>Date Started</th>
   <th>Date Stopped</th>
  </tr>
  <% if (visits) { %>
     <% visits.each { %>
      <tr>
        <td>${ ui.format(it.visitId) }</td>
         <td>${ ui.format(it.patient) }</td>
        <td>${ ui.format(it.visitType) }</td>
        <td>${ ui.format(it.startDatetime) }</td>
        <td>${ ui.format(it.stopDatetime) }</td>
      </tr>
    <% } %>
  <% } else { %>
  <tr>
    <td colspan="4">${ ui.message("general.none") }</td>
  </tr>
  <% } %>
</table>