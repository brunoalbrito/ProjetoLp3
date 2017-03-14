<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><!DOCTYPE html>
<html>
    <head>
        <title>Consulta Restaurantes</title>
        <meta charset="utf-8"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
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
            }

            body header{
                width: 100%;
                height: 5%;
                position: fixed;
                background-color: lawngreen;
            }

            body header nav{
                width: 100%;
                height: 100%;
                margin: 0;
                padding: 0;

                display: flex;
                flex-direction: row;
                justify-content: center;
                align-items: center;
            }

            body header ul{
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

            body header ul li{
                margin: 0;
                padding: 0;
                width: 20%;
                height: 100%;

                display: flex;
                flex-direction: row;
                justify-content: space-around;
                align-items: center;
                flex-basis: auto;
            }

            body header ul li a, a:active, a:visited{
                text-decoration: none;
                color: #000;
                display: inline-block;
            }

            body header ul li:nth-child(1) a{
                width: 100%;
                height: 100%;

                display: flex;
                flex-direction: row;
                flex-wrap: nowrap;
                justify-content: center;
                align-items: center;
            }

            body header ul li:nth-child(1) a img{
                margin: 0;
                padding: 0;
                display: flex;
            }

            body header ul li:hover{
                background-color: #fff;
                transition-duration: 0.7s;
            }

            body header ul li:hover a{
                color: lawngreen;
                transition-duration: 0.7s;
            }

            body header ul li:nth-child(1):hover{
                background-color: lawngreen;
            }

            body header ul li:nth-child(1):hover a{
                color: #000;
                transition-duration: 0s;
            }

            body footer{
                width: 100%;
                height: 5%;

                display: flex;
                flex-direction: row;
                justify-content: center;
                align-items: center;

                background-color: lawngreen;
            }
            
            body footer a, body footer a:active, body footer a:visited{
                text-decoration: none;
                color: #000;
            }
        </style>
    </head>
    <body>
        <header>
            <nav>
                <ul>
                    <li><a href="index.jsp"><img alt="logo" src="..."/>NOME SITE</a></li>
                    <li><a href="index.jsp">INICIO</a></li>
                    <li><a href="signup.jsp">REGISTRAR-SE</a></li>
                    <li><a href="signin.jsp">LOGIN</a></li>
                </ul>
            </nav>
        </header>
