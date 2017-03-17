<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<title>${user.email}</title>
<a href="/home">вернуться на свою страницу</a>
<div>
    <p>Email: ${user.email}</p>
    <p>Sex: ${user.sex}</p>
    <p><a href="/chat?id=${user.id}">Написать сообщение</a></p>
</div>

<@sf.form role="form" action='/post?id=${user.id}' method="post" modelAttribute="postForm">
<fieldset>
    <div class="field">
        <@sf.label path="text">text</@sf.label>
        <@sf.input path="text" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <input class="btn btn-info btn-outline" type="submit" value="отправить">
    </div>
</fieldset>
</@sf.form>
<#list posts as p>
<div class="active">
    <p>${p.author.email} at ${p.date}: </p>
    <p>${p.text}</p>
    <a href="/repost?id=${p.id}">поделиться записью на своей странице</a>
</div>
</#list>