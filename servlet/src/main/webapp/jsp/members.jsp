<%@ page import="com.hello.servlet.domain.member.Member" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hello.servlet.domain.member.MemberRepository" %><%--
  Created by IntelliJ IDEA.
  User: minsulee
  Date: 2024. 7. 17.
  Time: 오전 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> members = memberRepository.findAll();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody><%
        for (Member member : members) {
            out.write("<tr>");
            out.write("     <td>" + member.getId() + "</td>");
            out.write("     <td>" + member.getUsername() + "</td>");
            out.write("     <td>" + member.getAge() + "</td>");
            out.write("<tr>");
        } %>
    </tbody>
</table>
<a href="/index.html">메인</a>
</body>
</html>
