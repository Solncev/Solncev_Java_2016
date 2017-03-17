<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<title>сообщения</title>
<p><a href="/home">вернуться на свою страницу</a></p>
<br>
<@sf.form role="form" action='/send?id=${interlocutor}' method="post" modelAttribute="messageForm">
<fieldset>
    <div class="field">
        <@sf.label path="text"></@sf.label>
        <@sf.input path="text" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <input class="btn btn-info btn-outline" type="submit" value="отправить">
    </div>
</fieldset>
</@sf.form>
<#list messages as m>
<div>
    <p>${m.sender.email} at ${m.date}: ${m.text}</p>
</div>

</#list>