
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>

	<acme:form-textbox code="bookkeeper.accounting-record.form.label.title" path="title" />
	<acme:form-textbox code="bookkeeper.accounting-record.form.label.status" path="status" />
	<acme:form-textbox code="bookkeeper.accounting-record.form.label.creationMoment" path="creationMoment" />
	<acme:form-textarea code="bookkeeper.accounting-record.form.label.body" path="body" />
	
	<acme:form-return code="bookkeeper.accounting-record.form.button.return" />


</acme:form>