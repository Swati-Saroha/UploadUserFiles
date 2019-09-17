<div class="fieldcontain ${hasErrors(bean: person1Instance, field: 'dateOfBirth', 'error')} required">
    <label for="dateOfBirth">
        <g:message code="person1.dateOfBirth.label" default="Date Of Birth"/>
        <span class="required-indicator">*</span>
    </label>
    <g:datePicker name="dateOfBirth" precision="day" value="${personInstance?.dateOfBirth}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'firstName', 'error')} ">
    <label for="firstName">
        <g:message code="person1.firstName.label" default="First Name"/>

    </label>
    <g:textField name="firstName" value="${personInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'lastName', 'error')} ">
    <label for="lastName">
        <g:message code="person1.lastName.label" default="Last Name"/>

    </label>
    <g:textField name="lastName" value="${personInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'numberOfChildren', 'error')} required">
    <label for="numberOfChildren">
        <g:message code="person1.numberOfChildren.label" default="Number Of Children"/>
        <span class="required-indicator">*</span>
    </label>
    <g:field name="numberOfChildren" type="number" value="${personInstance.numberOfChildren}" required=""/>
</div>
