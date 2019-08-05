<% ui.decorateWith("appui", "standardEmrPage") %>

Welcome Solutions S.A

<br />
Here is a list of the current month Patients:
<br />

${ ui.includeFragment("theencounters", "patients") }