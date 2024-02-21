<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach var="store" items="${storeList}">
    <div class="store-card">
        <img src="${store.image}" alt="${store.name}">
        <div class="store-info">
            <h3>${store.name}</h3>
            <p>${store.description}</p>
            <a href="${store.url}">자세히 보기</a>
        </div>
    </div>
</c:forEach>