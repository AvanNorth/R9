<#-- @ftlvariable name="user" type="ru.itis.servletsapp.dto.UserDto" -->
<#-- @ftlvariable name="posts" type="java.util.List<ru.itis.servletsapp.dto.PostDto>" -->

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Друзья</title>

    <link href="/resources/css/style.css" rel="stylesheet">
    <link href="/resources/css/menu.css" rel="stylesheet">
    <link href="/resources/css/headers.css" rel="stylesheet">
    <link href="/resources/css/profile.css" rel="stylesheet">

    <script src="/resources/js/jquery.min.js"></script>
    <script src="/resources/js/profile.js"></script>
</head>
<body>
<div class="container">
    <#include "menu.ftl">
    <div class="center-content">
        <button class = "button text-center" onclick="location.href='/find'" >Найти друзей</button>
        <div class="container emp-profile">
            <div class="container">
                <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3" id="service-list">
                    <#if friends??>
                    <#list friends as friend>
                        <div class="col" id = "${friend.id}" >
                            <div class="card shadow-sm">
                                <div class="card-body">
                                    <div class="card-header text-center">
                                        <strong>${friend.firstName} ${friend.lastName}</strong>
                                    </div>
                                    <#if friend.avatarId??>
                                        <img class="user-avatar" style="width: 70px; height: 70px; margin: 2% 2% 2% 2%;" alt="IMAGE" src="/files/${friend.avatarId}"/>
                                    <#else>
                                        <img class="user-avatar"  style="width: 70px; height: 70px; margin: 2% 2% 2% 2%;" alt="IMAGE" src="/no-avatar.png"/>
                                    </#if>
                                    <p class="card-text">email: ${friend.email}</p>
                                        <p>age: ${friend.age}</p>
                                    <a type="button" class="btn btn-secondary" style="color: red; float: right">удалить</a>
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div class="btn-group">
                                            <a href="/profile?userId=${friend.id}" type="button" class="btn btn-secondary" style="margin-right: 3%">Открыть профиль</a>
                                            <a  type="button" class="btn btn-secondary" data-bs-toggle="modal">Написать сообщение</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="divider"></div>
                    </#list>
                        <#else>
                        <h6>У тебя нет друзей</h6>
                    </#if>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>