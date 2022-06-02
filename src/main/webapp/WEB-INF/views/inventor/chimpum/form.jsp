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
		<acme:message code="inventor.chimpum.form.label.chimpum" />
	</h2>


	<acme:input-textbox code="inventor.chimpum.form.label.code" path="code"
		readonly="false" />
	<acme:input-textbox code="inventor.chimpum.form.label.title" path="title"
		readonly="false" />

	<acme:input-money code="inventor.chimpum.form.label.budget" path="budget" />
	<acme:input-moment code="inventor.chimpum.form.label.creationTime"
		path="creationTime" />
	<acme:input-moment code="inventor.chimpum.form.label.startTime"
		path="startTime" />
	<acme:input-moment code="inventor.chimpum.form.label.endTime"
		path="endTime" />
	<acme:input-url code="inventor.chimpum.form.label.link" path="link" />
	<acme:input-textbox code="inventor.chimpum.form.label.description"
		path="description" readonly="false" />

	<h3>
		<acme:message code="inventor.chimpum.form.label.invention" />
	</h3>
	<acme:input-textbox code="inventor.chimpum.form.label.invention.code"
		path="inventionCode" readonly="false" />
		<acme:input-textbox code="inventor.chimpum.form.label.invention.name"
		path="inventionName" readonly="false" />
		<acme:input-textbox code="inventor.chimpum.form.label.invention.published"
		path="inventionPublished" readonly="false" />
		<acme:input-textbox code="inventor.chimpum.form.label.invention.link"
		path="inventionLink" readonly="false" />
		<acme:input-textbox code="inventor.chimpum.form.label.invention.inventionType"
		path="inventionType" readonly="false" />
			<acme:input-textbox code="inventor.chimpum.form.label.invention.retailPrice"
		path="inventionRetailPrice" readonly="false" />
		<acme:input-textbox code="inventor.chimpum.form.label.invention.technology"
		path="inventionTechnology" readonly="false" />
		<acme:input-textbox code="inventor.chimpum.form.label.invention.description"
		path="inventionDescription" readonly="false" />








</acme:form>