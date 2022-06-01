<%--
- form.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>



	<h2>
		<acme:message code="patron.patronage.form.label.chimpum" />
	</h2>


	<acme:input-textbox code="patron.chimpum.form.label.code" path="code"
		readonly="false" />
	<acme:input-textbox code="patron.chimpum.form.label.title" path="title"
		readonly="false" />

	<acme:input-money code="patron.chimpum.form.label.budget" path="budget" />
	<acme:input-moment code="patron.chimpum.form.label.creationTime"
		path="creationTime" />
	<acme:input-moment code="patron.chimpum.form.label.startTime"
		path="startTime" />
	<acme:input-moment code="patron.chimpum.form.label.endTime"
		path="endTime" />
	<acme:input-url code="patron.chimpum.form.label.link" path="link" />
	<acme:input-textbox code="patron.chimpum.form.label.description"
		path="description" readonly="false" />

	<h3>
		<acme:message code="patron.patronage.form.label.invention" />
	</h3>
	<acme:input-textbox code="patron.chimpum.form.label.invention.code"
		path="invention.code" readonly="false" />








</acme:form>