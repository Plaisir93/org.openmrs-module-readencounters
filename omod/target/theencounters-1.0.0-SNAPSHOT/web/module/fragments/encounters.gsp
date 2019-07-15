<table>
  <tr>
   <th>Encounter Id</th>
   <th>Encounter Type</th>
   <th>Encounter Date Time</th>
   <th>Encounter Date Created</th>
  </tr>
  <% if (encounters) { %>
     <% encounters.each { %>
      <tr>
        <td>${ ui.format(it.encounterId) }</td>
        <td>${ ui.format(it.encounterType) }</td>
        
        <td>${ ui.format(it.encounterDatetime) }</td>
        
        <td>${ ui.format(it.dateCreated) }</td>
      </tr>
    <% } %>
  <% } else { %>
  <tr>
    <td colspan="4">${ ui.message("general.none") }</td>
  </tr>
  <% } %>
</table>