<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<title>моя страница</title>
<div>
    <p>Email: ${user.email}</p>
    <p>Sex: ${user.sex}</p>
    <a href="/users">Все пользователи</a>
    <br>
    <p><a href="/chat?id=${user.id}">Написать сообщение</a></p>
    <br>
</div>

<@sf.form role="form" action='/post?id=${user.id}' method="post" modelAttribute="postForm">
<fieldset>
    <div class="field">
        <@sf.label path="text">text</@sf.label>
        <@sf.input path="text" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <input class="btn btn-info btn-outline" type="submit" value="поделиться">
    </div>
</fieldset>
</@sf.form>
<#list posts as p>
<div class="active">
    <p>${p.author.email} at ${p.date}: </p>
    <p>${p.text}</p>
</div>
</#list>