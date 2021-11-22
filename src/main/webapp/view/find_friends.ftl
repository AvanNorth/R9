<#-- @ftlvariable name="user" type="ru.itis.servletsapp.dto.UserDto" -->
<#-- @ftlvariable name="posts" type="java.util.List<ru.itis.servletsapp.dto.PostDto>" -->

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Поиск друзей</title>

    <link href="/resources/css/style.css" rel="stylesheet">
    <link href="/resources/css/menu.css" rel="stylesheet">
    <link href="/resources/css/headers.css" rel="stylesheet">
    <link href="/resources/css/profile.css" rel="stylesheet">

    <script src="/resources/js/jquery.min.js"></script>
    <script src="/resources/js/friends.js"></script>
</head>
<body>
<div class="container">
    <#include "menu.ftl">
    <div class="center-content">
        <div class="container emp-profile">
            <div class="container">
                <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3" id="service-list">
                    <#list users as user>
                    <div class="col" id="${user.id}">
                        <div class="card shadow-sm">
                            <div class="card-body">
                                <div class="card-header text-center">
                                    <strong>${user.firstName} ${user.lastName}</strong>
                                </div>
                                <#if user.avatarId??>
                                    <img class="user-avatar" style="width: 70px; height: 70px; margin: 2% 2% 2% 2%;"
                                         alt="IMAGE" src="/files/${user.avatarId}"/>
                                <#else>
                                    <img class="user-avatar" style="width: 70px; height: 70px; margin: 2% 2% 2% 2%;"
                                         alt="IMAGE" src="/no-avatar.png"/>
                                </#if>
                                <p class="card-text">email: ${user.email}</p>
                                <p>age: ${user.age}</p>
                                <#if sessionUser?? && sessionUser.id == user.id>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group">
                                        <a href="/profile" type="button"
                                           class="btn btn-secondary" style="margin-right: 3%">Открыть мой профиль</a>
                                    </div>
                                </div>
                                <#else>
                                <#if !friends?seq_contains(user)>
                                    <button id="addBtn${user.id}" type="button" class="btn btn-secondary"
                                            style="color: green; float: right" onclick="addFriend(${user.id})">добавить
                                    </button>
                                    <p id="addTxt${user.id}" style="color: limegreen; float: right" hidden>добавлен</p>
                                </#if>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group">
                                        <a href="/profile?userId=${user.id}" type="button"
                                           class="btn btn-secondary" style="margin-right: 3%">Открыть профиль</a>
                                    </div>
                                    </#if>
                                </div>
                            </div>
                        </div>
                        <div class="divider"></div>
                        </#list>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>