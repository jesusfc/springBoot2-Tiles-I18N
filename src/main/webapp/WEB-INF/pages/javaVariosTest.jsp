<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/defs/taglibs.jsp"%>
<%@ include file="../../js/js_javaVariosTest.jsp"%>

<style>
    body {background-color: #ccfdcf;}
    h1   {color: red;}
    p    {color: red;}
</style>

<h1 style="color:#ff0000 !important;">javaVariosTest.jsp</h1>
<h1>-------------------------------------------------------------------------------------</h1>

<div>
    <ul>
        <li>
            <div>
                <label>Pruebas usando Spring</label>
                <ul>
                    <li>- User Nombre: ${user.nombre}</li>
                    <li>- User apellido: ${user.apellido}</li>
                    <li>- User email: ${user.email}</li>
                </ul>
            </div>
        </li>
    </ul>
</div>
<div>
    <ul>
        <li>
            <div>
                <label>Pruebas de JSON - UTF8 Decode Encode</label>
                <ul>
                    <li>- User Nombre: <span id="userName"></span></li>
                    <li>- User apellido: <span id="userApell"></span></li>
                    <li>- User email: <span id="userEmail"></span></li>
                </ul>
            </div>
        </li>
    </ul>
</div>


