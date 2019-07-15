<table>
  <tr>
   <th>Obs Id</th>
   <th>Obs Concept</th>
   <th>Obs Date Time</th>
  </tr>
  <% if (observations) { %>
     <% observations.each { %>
      <tr>
        <td>${ ui.format(it.obsId) }</td>
        <td>${ ui.format(it.concept) }</td>
         <td>${ ui.format(it.obsDatetime) }</td>
      </tr>
    <% } %>
  <% } else { %>
  <tr>
    <td colspan="3">${ ui.message("general.none") }</td>
  </tr>
  <% } %>
</table>