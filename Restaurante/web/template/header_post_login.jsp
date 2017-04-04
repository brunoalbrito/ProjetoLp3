<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><!DOCTYPE html>
<html>
    <head>
        <title>Consulta Restaurantes</title>
        <meta charset="utf-8"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript">
            function setColor(){
                var profile = document.getElementById('profile');
                var subMenu = document.getElementById('sub_menu');
                var profileStyle = window.getComputedStyle(profile);
                var subMenuStyle = window.getComputedStyle(subMenu);
                var profileColor = profileStyle.getPropertyValue('color');
                var profileBgColor = profileStyle.getPropertyValue('background-color');
                var subMenuLeft = subMenuStyle.getPropertyValue('left');
                
                if(profileColor == 'rgb(12, 255, 0)' && subMenuLeft == '0px'){
                    profile.style.color = 'rgb(12, 255, 0)';
                }else                
                if(profileColor == 'rgb(255, 255, 255)' && subMenuLeft == '0px'){
                    profile.style.color = 'rgb(12, 255, 0)';
                }else{
                    profile.style.color = 'rgb(255, 255, 255)';
                }              
            }
            
            function setColor2(){                
                var profile = document.getElementById('profile');
                var profileStyle = window.getComputedStyle(profile);
                var profileColor = profileStyle.getPropertyValue('color');
                
                if(profileColor == 'rgb(255, 255, 255)')
                    profile.style.color = 'rgb(12, 255, 0)';
            }
        </script>
        <style>    
            @font-face{
                font-family: Paprika;
                src: url(../css/Paprika-Regular.ttf);
            }
            *{
                margin: 0;
                padding: 0;
            }

            html{
                margin: 0;
                padding: 0;
                width: 100%;
                height: 100%;
            }

            body{
                margin: 0;
                padding: 0;
                width: 100%;
                height: 100%;

                font-family: Paprika;
            }

            body header{
                width: 100%;
                height: 7.5%;
                position: fixed;
                background-color: rgb(13,255,0);
            }

            body header nav{
                width: 100%;
                height: 100%;
                margin: 0;
                padding: 0;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2), 0 0px 10px rgba(0, 0, 0, 0.19);

                display: flex;
                flex-direction: row;
                justify-content: center;
                align-items: center;
            }

            body header nav ul{
                width: 80%;
                height: 100%;
                margin: 0;
                padding: 0;
                list-style: none;

                display: flex;
                flex-direction: row;
                flex-wrap: nowrap;
                justify-content: center;
                align-items: center;
            }

            body header nav ul li{
                margin: 0;
                padding: 0;
                width: 20%;
                height: 100%;
                color: #FFF;

                display: flex;
                flex-direction: row;
                justify-content: space-around;
                align-items: center;
                flex-basis: auto;
            }

            body header nav ul #logo{
                background-color: rgba(9,181,29,0.4);
            }

            body header nav ul li a,body header nav ul li a:active,body header nav ul li a:visited{
                text-decoration: none;
                color: #fff;
                display: inline-block;
            }

            body header nav ul #logo a{
                width: 100%;
                height: 100%;

                display: flex;
                flex-direction: row;
                flex-wrap: nowrap;
                justify-content: center;
                align-items: center;
            }

            body header nav ul #logo a img{
                margin: 0;
                padding: 0;
                display: flex;
            }            

            body header nav ul li:hover{
                background-color: #fff;
                transition-duration: 0.7s;
            }

            body header nav ul li:hover a{
                color: rgb(13,255,0);
                transition-duration: 0.7s;
            }

            body header nav ul #logo:hover{
                background-color: rgba(9,181,29,0.4);
            }

            body header nav ul #logo:hover a{
                color: #fff;
                transition-duration: 0s;
            }            

            body header nav ul li:nth-child(4){
                position: relative;
            }

            body header nav ul li:nth-child(4) span{
                width: 100%;
                height: 100%;
                display: flex;
                flex-direction: row;
                justify-content: center;
                align-items: center;
            }

            body header nav ul li:nth-child(4) span:hover{
                color: rgb(13,255,0);
                cursor: pointer;
            }

            body header nav ul li:nth-child(4) ul{
                width: 100%;
                height: 200%;
                position: absolute;
                top: 100%;
                background-color: rgb(13, 255, 0);
                left: -9999px;

                display: flex;
                flex-direction: column;
                flex-wrap: nowrap;
            }

            body header nav ul li:nth-child(4) ul li{
                width: 100%;
                height: 50%;
            }

            body header nav ul li:nth-child(4):hover ul{
                left: 0;
            }

            body header nav ul li:nth-child(4):hover ul li a{
                color: #FFF;
            }

            body header nav ul li:nth-child(4) ul li:hover a{
                color: rgb(13, 255, 0);
            }

            body footer{
                width: 100%;
                height: 5%;

                display: flex;
                flex-direction: row;
                justify-content: center;
                align-items: center;
                background-color: rgb(13,255,0);
            }

            body footer a{
                color: #fff;
                font-size: 14px;
            }

            body footer a:active, body footer a:visited{
                text-decoration: none;
                color: #fff;
            }

            section, main{
                z-index: -1;
            }
        </style>
    </head>
    <body>
        <header>
            <nav>
                <ul>
                    <li id="logo"><a href="index.jsp"><img alt="logo" src="..."/>BRConsulta</a></li>
                    <li><a href="home.jsp">busca</a></li>
                    <li><a href="favorites.jsp">favoritos</a></li>
                    <li onmouseout="setColor()" onmouseenter="setColor2()">
                        <span id="profile">${usuario.userName}</span>
                        <ul id="sub_menu" onmouseout="setColor()">
                            <li><a href="profile.jsp">perfil</a></li>
                            <li><a href="${pageContext.request.contextPath}/FrontController?ctrl=Logout">logout</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </header>
