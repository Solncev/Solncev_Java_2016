<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<title>регистрация</title>
<@sf.form action="/sign_up" method="post" modelAttribute="user">
<fieldset>
    <div>
        <@sf.label path="email">Email</@sf.label>
        <@sf.input path="email" type="email"/>
        <@sf.errors path="email"/>
    </div>
    <div>
        <@sf.label path="password">Password</@sf.label>
        <@sf.input path="password" type="password"/>
        <@sf.errors path="password"/>
    </div>
    <div>
        <@sf.label path="sex">Sex</@sf.label>
        <@sf.select path="sex">
            <#list sex as s>
                <@sf.option value="${s}"/>
            </#list>
        </@sf.select>
    </div>
    <div>
        <input type="submit" value="зарегистрироваться">
    </div>
</fieldset>
</@sf.form>