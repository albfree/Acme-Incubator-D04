<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>

	<input id="dfId" name="dfId" type="hidden" value= "${param.dfId}" />
	<acme:form-textbox code="authenticated.discussion-forum.form.label.title" path="title"/>
	<acme:form-moment code="authenticated.discussion-forum.form.label.creation-moment" path="creationMoment"/>
	<acme:form-hidden path="investmentRound"/>

	<acme:form-submit method="get" code="authenticated.discussion-forum.form.button.messages" 
		action="/authenticated/message/list-mine/?dfId=${id}"/>
	<acme:form-return code="authenticated.discussion-forum.form.button.return"/>

</acme:form>