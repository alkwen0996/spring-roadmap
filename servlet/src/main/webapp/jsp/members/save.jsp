<%@ page import="com.hello.servlet.domain.member.MemberRepository" %>
<%@ page import="com.hello.servlet.domain.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: minsulee
  Date: 2024. 7. 17.
  Time: 오전 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  // request, response 사용 가능
  MemberRepository memberRepository = MemberRepository.getInstance();

  System.out.println("MemberSaveServlet.service");
  String username = request.getParameter("username");
  int age = Integer.parseInt(request.getParameter("age"));

  Member member = new Member(username, age);
  memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
  성공
  <ul>
    <li>id=<%=member.getId()%></li>
    <li>id=<%=member.getUsername()%></li>
    <li>id=<%=member.getAge()%></li>
  </ul>
  <a href="/index.html">메인</a>
</body>
</html>
