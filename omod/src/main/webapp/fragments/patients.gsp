<table>
  <tr>
   <th>Patient Id</th>
   <th>Creator</th>
   <th>Date Created</th>
   <th>Date Changed</th>
  </tr>
  <% if (patients) { %>
     <% patients.each { %>
      <tr>
        <td>${ ui.format(it.patientId) }</td>
        <td>${ ui.format(it.creator) }</td>
        <td>${ ui.format(it.dateCreated) }</td>
        <td>${ ui.format(it.dateChanged) }</td>
      </tr>
    <% } %>
  <% } else { %>
  <tr>
    <td colspan="4">${ ui.message("general.none") }</td>
  </tr>
  <% } %>
</table>