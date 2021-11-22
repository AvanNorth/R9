<#-- @ftlvariable name="user" type="ru.itis.servletsapp.dto.UserDto" -->
<#-- @ftlvariable name="posts" type="java.util.List<ru.itis.servletsapp.dto.PostDto>" -->

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Новости</title>

    <link href="/resources/css/style.css" rel="stylesheet">
    <link href="/resources/css/menu.css" rel="stylesheet">
    <link href="/resources/css/headers.css" rel="stylesheet">
    <link href="/resources/css/profile.css" rel="stylesheet">

    <script src="/resources/js/jquery.min.js"></script>
    <script src="/resources/js/feed.js"></script>
</head>
<body>
<div class="container">
    <#include "menu.ftl">
    <div class="center-content">
        <button class = "button text-center" onclick="location.href='/feed'" >Обновить ленту</button>
        <div class="container emp-profile">
            <div class="container">
                <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3" id="service-list">

                    <#if posts??>
                        <#list posts as post>
                            <div class="col" id="card${post.id}">
                                <div class="card shadow-sm">
                                    <div class="card-body">
                                        <div class="card-header text-center">
                                            <strong>${post.author.firstName} ${post.author.lastName}</strong>
                                        </div>
                                        <#if post.author.avatarId??>
                                            <img class="user-avatar" style="width: 70px; height: 70px; margin: 2% 2% 2% 2%;" alt="IMAGE" src="/files/${post.author.avatarId}"/>
                                        <#else>
                                            <img class="user-avatar"  style="width: 70px; height: 70px; margin: 2% 2% 2% 2%;" alt="IMAGE" src="/no-avatar.png"/>
                                        </#if>
                                        <p >${post.createdAt?string("dd MMMM yyyy 'г.,' HH:mm")}</p>
                                        <p class="card-text">${post.content}</p>
                                    </div>
                                </div>
                            </div>
                            <div class="divider"></div>
                        </#list>
                    <#else>
                        <h6>Новостей нет...</h6>
                    </#if>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>


