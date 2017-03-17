<title>все пользователи</title>
<#list users as u>
<div>
    <a href="/user?id=${u.id}">${u.email}</a>
</div>
</#list>