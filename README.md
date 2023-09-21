# **코리아 IT 아카데미 앱개발**
## DBMS 수업정리

## JSP(Java Server Page)
- HTML을 중심으로 자바와 같이 연동하여 사용하는 웹 언어이다.
- HTML코드 안에 JAVA 코드를 작성할 수 있는 언어이다.

### 서버(service + er)
```
사용자의 요청에 맞는 서비스를 제공해주는 것

    요청
클라이언트 -------> 서버
      응답
서버---------> 클라이언트
```
### 웹(Web)
- 페이지 요청과 응답이 일어나는 장소.
- 인터넷에 연결된 컴퓨터들을 통해 사람들이 정보를 공유할 수 있는 정보 공간.

### 웹 서버(http) - 아파치
- 사용자의 요청이 정적 데이터인지 동적 데이터인지 판단한다.
- 정적 데이터일 경우 이미 준비된 HTML문서를 그대로 응답해주며,
- 동적 데이터라면 웹 컨테이너에 요청을 보낸다.

### 웹 컨테이너(서블릿 컨테이너)
- 동적 데이터일 경우 JSP, 서블릿으로 연산 및 제어 그리고 DB까지 접근한다.
- DB에 접근하는 연산을 복잡한 연산이라고 하며, JAVA로 처리한다.
- 동적 데이터가 정제된 데이터(정적 데이터)로 완성되면 이를 웹 서버로 전달해준다.

### WAS(Web Application Server) - Tomcat
```  
동적 데이터를 처리할 서블릿을 메모리에 할당하며, 
web.xml을 참조한 뒤 알맞는 서블릿에 대한 Thread를 생성한다.
서블릿 요청과 서블릿 응답 객체 생성 후 서블릿에 전달하면, 
연산 종료 후 메모리에서 해제시킨다.
```

### 서블릿(Servlet)
- Java 코드 안에 HTML 코드를 작성할 수 있는 Java 프로그램이다.
- Thread에 의해 서블릿에 있는 service() 메소드가 호출된다.
- 전송 방식 요청에 맞게 doGet() 또는 doPost()등의 메소드를 호출한다.

### 디렉티브 태그
```
<%@ page%>
```
- 현재 페이지에 대한 정보를 설정하는 태그이다.
- 되도록 페이지 최상단에 선언한다.
	
1. language(java) : 현재 JSP페이지가 사용할 프로그래밍 언어
2. contentType(text/html) : 현재 JSP 페이지가 생성할 문서의 콘텐츠 유형
3. pageEncoding(ISO-8859-1) : 현재 JSP 페이지의 문자 인코딩 설정
4. import : 현재 JSP 페이지에서 사용할 자바 패키지 및 클래스 설정
5. session(true) : 현재 JSP 페이지에서 세션 사용 여부 설정
6. info : 현재 JSP 페이지에 대한 설명을 설정
7. errorPage : 현재 JSP 페이지에 오류가 발생했을 때 보여줄 오류 페이지 설정
8. isErrorPage(false) : 현재 JSP 페이지가 오류 페이지인지 여부 설정

### 스크립트 태그
HTML 코드에 자바 코드를 넣어서 프로그램이 수행하는 기능을 구현할 수 있다. <br>
1. 선언문(declaration) <%! %> <br>
  자바 변수나 메소드를 정의하는 데 사용 <br>
2. 스크립틀릿(scriptlet) <% %> <br>
  자바 변수 및 자바 로직 코드를 작성한 데 사용 <br>
3. 표현문(expression) : <%= =%> <br>
  변수, 계산식, 리턴이 있는 메소드 호출 결과를 문자열 형태로 출력한다.

### include 디렉티브 태그
```
<% include file=""%>
```
현재 JSP 페이지의 특정 영역에 외부 파일의 내용을 포함하는 태그이다. <br>
보통 header와 footer는 대부분의 페이지에서 동일한 내용으로 작성되기 떄문에 <br>
유지보수 및 편의를 위하여 외부 파일로 만든 후 include해서 사용한다. <br>
이러한 것을 모듈화라고 한다.

### 액션 태그
```
서버나 클라이언트에게 어떤 행동을 하도록 명령하는 태그이다.
페이지와 페이지 사이를 제어하거나 다른 페이지의 실행 결과 내용을
현재 페이지에 포함시킬 때 사용한다. 또한 자바빈즈와 같은 다양한 기능을
제공하며, 액션 태그는 XML형식의 <jsp:/>를 사용한다.
```
1. forward (jsp:forward/> <br>
  다른 페이지로의 이동, 페이지 흐름을 제어한다.

2. include (<jsp:inculde page=""/> <br>
  외부 페이지의 내용을 포함거나 페이지 모듈화.

3. param (<jsp:param /> <br>
		현재 페이지에서 다른 페이지에 정보를 전달한다.

### 자바빈즈(액션태그)
JSP의 표준 태그를 통해 접근할 수 있는 자바 클래스로서 <br>
멤버변수와, setter getter메소드로 이루어져 있다.

### 자바빈즈 태그
1. 객체 생성 <br>
<%MemberVO member = new MemberVO();%> <br>
<jsp:useBean class="com.koreait.beans.MemberVO" id="member">

2. setter() <br>
<%member.setName("한동석");%> <br>
<jsp:setProperty property="name" name="member" value="한동석">

3. getter() <br>
<%member.getName();%> <br>
<jsp:getProperty property="name" name="member">

### 자바빈즈 규칙
1.패키지화
2.필드 접근자를 private으로 설정
3.getter, setter 메소드는 public으로 설정
4.기본 생성자 선언

### 내장객체
객체화 없이 사용할 수 있는 객체이며, JSP파일이 서블릿으로 변환될 때 <br>
웹 컨테이너가 자동으로 메모리에 할당하며 제공한다.
```
request : 웹 브라우저의 요청 정보를 저장
response : 웹 브라우저의 요청에 대한 응답 정보를 저장
out : JSP페이지 body에 출력할 내용 작성 시 사용
session : 하나의 웹 브라우저의 정보를 유지하기 위한 세션 정보를 저장
pageContext : JSP 페이지에 대한 정보를 저장
exception : JSP 페이지에 예외가 발생한 경우 사용되는 객체
```

### GET방식과 POST방식
```
GET
  	주소에 데이터를 추가하여 전달하는 방식.
	보통 쿼리 문자열(query string)에 포함되어 전송되므로, 길이에 제한이 있으며
	주소에 데이터가 보이므로 보안상 취약점이 존재한다.
	중요한 데이터 혹은 길이가 긴 데이터는 POST방식을 사용하여 요청하는 것이 좋지만
	GET방식이 POST방식보다 상대적으로 빠른 전송방식이다.

POST
	데이터를 별도로 첨부하여 전달하는 방식
	브라우저 히스토리에도 남지 않고 데이터는 쿼리 문자열과는 별도로 전송된다.
	따라서 데이터의 길이에 제한도 없으며, GET방식보다 보안성이 높다.
	하지만 GET방식 보다 상대적으로 느리다.
```
- 결론 <br>
	전송할 데이터의 양이 작고 노출되어도 무방하다면 GET방식을 사용하고 <br>
	전송할 데이터의 양이 크거나 노출이 되면 안될 데이터라면 POST방식을 사용한다.

## Ajax(Asynchronus Javascript and XML)
- 빠르게 동작하는 동적인 웹 페이지를 만들기위한 개발 기법이다.
- Ajax는 웹 페이지 전체를 다시 로딩하지 않고도, 웹 페이지 일부분만을 갱신할 수 있다.
- 백그라운드 영역에서 서버와 통신하여, 그 결과를 웹 페이지의 일부분에만 표시할 수 있다.
- 이 때 아래와 같은 데이터를 주고 받을 수 있다.
```
※ JSON
※ XML
※ HTML
※ 텍스트파일
```

### Ajax의 장점
1. 웹 페이지 전체를 다시 로딩하지 않고도, 웹 페이지의 일부분만을 갱신할 수 있다.
2. 웹 페이지가 로드된 후에 서버로 데이터 요청을 보내거나 받을 수 있다.
3. 다양한 UI(동적 페이지)구현이 가능해진다.

### Ajax의 단점
1. 페이지 이동이 없기 때문에 히스토리 관리가 안된다.
2. 반복적인 데이터를 요청하면 느려지거나 작동하지 않게 된다.
3. 페이지의 이동이 없다는 것은 보안 상의 문제도 발생할 수 있다는 것이다.

### Ajax의 구성 요소
- 웹 페이지의 표헌을 위한 HTML과 CSS
- 데이터에 접근하거나 화면 구성을 동적으로 조작하기 위해 사용되는 DOM 모델
- 데이터 교환을 위한 JSON이나 XML
- 웹 서버와의 비동기 통신을 위한 XMLHttpRequest객체
- 위에서 언급한 모든 기술을 결합하여 사용자가 작업 흐름을 제어하는 데 사용되는 자바스크립트

### XMLHttpRequest객체
- var 객체명 = new XMLHttpRequest();
- Ajax의 가장 핵심적인 구성 요소는 바로 XMLHttpRequest 객체이다.
- Ajax에서 XMLHttpRequest 객체는 웹 브라우저가 서버와 데이터를 교환할 때 사용된다.
- 웹 브라우저가 백그라운드에서 계속해서 서버와 통신할 수 있는 것은 바로 이 객체를 사용하기 때문이다.

### 서버에 요청하기
```
Ajax에서는 XMLHttpRequest객체를 사용하여 서버와 데이터를 교환한다.
따라서 서버에 요청을 보내기 위해서는 객체를 생성해야 하고, 객체의 open()메소드와
send()메소드를 사용하여 요청을 보낼 수 있다.
```

### open()
- 서버로 보낼 Ajax 요청 형식을 설정한다.
- open(전달방식, URL, 동기 여부);
```
전달방식: GET, POST 등 요청 방식 작성
URL: 요청을 처리할 서버의 파일 주소 전달
동기 여부: 요청을 동기식으로 전달할 지, 비동기식으로 전달할 지를 선택
```

### send()
- 작성된 Ajax 요청을 서버로 전달
- 전달방식에 따라서 인수를 가질 수도 또는 가지지 않을 수도 있다.
```
GET방식 : send()
POST방식 : send(전송할 데이터의 전달 방식에 맞추어 작성)
```

### setRequestHeader()
- POST 방식에서 전달할 데이터의 방식(타입)을 설정한다.
- setRequestHeader("Content-Type", "전달할 데이터의 방식");
```
Ajax 요청 시 XMLHttpRequest 객체는 각 상태별로 readyState가 변한다.
처음에는 readyState가 0(객체명/.UNSENT, 보내지 않음)이었다가,
open 메소드를 호출하는 순간 1(객체명.OPEND)로 바뀌고 send()메소드를
호출하게 되면 순차적으로 2(객체명.HEADERS_RECEIIVED),
3(객체명.LOADING),4(객체명.DONE)가 된다면 상태코드(객체명.status)가
성송을 의미하는 200, 201일 떄 응답을 확인해야 한다.
```

## 쿠키(Cookie)
- 웹 브라우저가 보관하고 있는 데이터로, 웹 서버에 요청을 보낼 때 헤더에 담아서 전송한다.
- 웹 브라우저는 쿠키가 삭제되기 전까지 웹 서버에 쿠키를 전송한다.

### 장단점
- 클라이언트의 일정 폴더에 정보를 저장하기 떄문에 서버의 부하를 줄일 수 있다.
- 정보가 사용자 컴퓨터(로컬)에 저장되기 때문에 보안에 위협받을 수 있다.
- 데이터 저장 용량에 한계가 있다.
- 일반 사용자가 브라우저 내의 기능인 "쿠키 차단"을 사용했을 경우 쿠키가 무용지물이 된다.

### 1. 동작 방식
1. 쿠키 생성 : 웹 서버에서 쿠키를 생성하고 쿠키에 응답 데이터를 담아서 웹 브라우저에 전송한다.
2. 쿠키 저장 : 웹 브라우저는 응답 데이터를 담고 있는 쿠키를 메모리나 파일로 저장한다.
3. 쿠키 전송 : 웹 브라우저는 쿠키 요청이 있을 떄마다 웹 서버에 전송한다.
	- 웹 서버는 쿠키를 사용해서 필요한 작업을 수행할 수 있다.

### 2. 쿠키 생성 및 사용 방식
1. 쿠키 생성 후 response 객체에 담아준다(이미 쿠키 이름이 존재하면, 값 수정)
```
Cookie cookie = new Cookie("쿠키이름", "쿠키값");
```
2. 쿠키 유무를 확인하고 쿠키의 값을 얻어온다.
```
String cookieCheck = request.getHeader("Cookie");
if(cookieCheck !== null){
	Cookie[] cookies = request.getCookies();
	for(Cookie cookie : cookies){
		cookie.getName();
		cookie.getValue();
	}
}
```
3. 쿠키를 삭제한다.
```
String cookieCheck = request.getHeader("Cookie");
if(cookieCheck != null){
	Cookie[] cookies = request.getCookies();
	for(Cookie cookie : cookies){
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
}
```

### 세션(Session)
- 내장 객체로서 브라우저마다 한 개씩 존재하고, 고유한 SessionID 생성 후 정보를 추출한다.

### 장단점
- JSP에서만 접근할 수 있기 대문에 보안성이 좋고, 저장 용량의 한계가 거의 없다.
- 서버에 데이터를 저장하므로 서버에 부하가 걸릴 수 있다. <br>
*** 쿠키보다 세션을 쓰는 것이 더 안정적이고, 안전하지만 세션에 저장할 공간이 부족할 경우 쿠키가 사용된다.

### ★☆★☆★☆★☆★ 암호화와 복호화(base64)
[js]
```
<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/aes.js"></script>
btoa(문자열): base64 암호화
atoa(문자열): base64 복호화
```
[java]
```
Base64.getEncoder().encodeToString(문자열.getBytes()) : base64 암호화
Base64.getDecoder().decode(문자열): base64 복호화
```

## JSON
- 경량화된 데이터 교환 형식.
- 서로 다른 언어들 간 데이터를 주고받을 수 있도록 만들어진 텍스트 기반의 형식이다.
- 프로그래밍 언어가 아닌 데이터 표기 방법 중 하나이고 기본적으로
- name : value 형태의 구조를 가지고 있다.

### JSON 형식
```
{"내부": {key : value,...}, "내부2" : {key: value,...},...}
```

### EL문과 JSTL
- 페이지 가독성 상승
- 자바 구문을 라이브러리 형태로 만들어 놓고 필요할 때마다 태그로 꺼내 쓰는 기술이다.
- JSP 페이지 내에서 자바코드와 HTML 코드가 섞여 있으면 가독성이 떨어지고 복잡해진다.
- EL문과 JSTL문을 사용하면 HTML과 태그로만 구성된 일관된 소스코드를 볼 수 있다는 장점이 있다.

### EL(Expression Language)
값을 간결하고 간편하게 출력할 수 있도록 해주는 기술
```
자바				EL
<%=name%>			${name}
<%=member.getName()%>		${member.getName()}
```
값을 찾을 때에는 작은 Scope에서 큰 Scope로 찾는다.
```
page -> request -> session -> application
```
원하는 스코프의 변수를 찾을 때 아래와 같이 사용한다.
```
${param.name} : GET방식, 쿼리 스트링으로 전달된 파라미터를 받을 때 사용한다.
${requestScope.name} : request.setAttribute(key, value)를 통해 ㅌ저장한 파라미터를 받을 떄 사용한다.
${sessionScope.name} : session.setAttribute(key, value)를 통해 ㅌ저장한 파라미터를 받을 떄 사용한다.
```

### EL 연산자
```
%, mod
&&, and
||, or
>, lt
<, gt
>=, le
<=, ge
==, eq
!=, ne
empty(값이 있으면 false 값이 없으면 true)
!, not
```

### JSTL(Jsp Standard Tag Library)
연산이나 조건문, 반복문 등을 편하게 처리할 수 있으며, JSP페이지 내에서 <br>
자바 코드를 사용하지 않고 로직을 구현할 수 있도록 효율적인 방법을 제공한다.
```
자바					JSTL
<%					<c:forEach var="변수명" items="${Iterator}">
for(자료형 변수명 : Iterator){			HTML 코드
%>
	HTML 코드				</c:forEach>
<%	
}
%>


<%					<c:forEach var="변수명" begin="초기값" end="끝값">
for(초기식:조건식; 증감식){				HTML 코드
%>
	HTML 코드				</c:forEach>
<%	
}
%>
```

### JSP에서 JSTL 추가
```
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
```

### core태그의 종류
```
<c:set>	 : 변수에 값 대입
<c:out>  : 값 출력
<c:if>   : 조건문(if문)
<c:choose> : 조건문(switch문 시작을 알림)
<c:when> : switch 문에서 case의 역할(break 사용할 필요가 없다)
<c:otherwise> : switch문에서 default 역할
<c:forEach> : 반복문(for문)
```

### DBCP(DataBase Connection Pool)
사용자 요청이 있을 때 마다 DB 연결을 한다면 코드가 복잡해지면, <br>
많은 요청이 있을 때 연결 속도가 저하될 수 있다. <br>
따라서 미리 Connection을 만들어 두고, 필요 시 저장된 공간에서 가져다 쓴 후 반환하는 기법이다.

### JNDI(Java Naming and Directory Interface)
디렉터리 서비스에서 제공하는 데이터 및 객체를 발견하고 참고하기 위한 자바 API이며, <br>
외부에 있는 객체를 가져오기 위한 기술이다

### ☆★☆ JSP JSTL 쓰는이유
자바스크립트로 쓰는것보다는 "태그"로 통일하자

### MyBatis Framework
1. 쓰는 이유
2. 자바 파일에서 SQL문이 없게끔 하자
3. 자바에는 자바파일 SQL문에서는 SQL
4. 합치자
5. MyBatis는 기존 JDBC 방식과는 달리 SQL문을 XML파일에 작성함으로써 코드가 줄어들고 SQL문 수정이 편해진다.
6. DBCP를 사용하여 커넥션을 여러 개 생성하기 때문에 JDBC만 사용하는 것 보다는 작업 효율과 가독성이 좋아진다.

### MyBatis 작동 순서
1. 응용 프로그램이 SqlSessionFactorybuilder를 통해 SqlSessionFactory를 빌드하도록 요청한다.
2. SqlSessionFactoryBuilder는 SqlSessionFactory를 생성하기 위한 MyBatis config(구성)파일을 읽는다.
3. SqlSessionFactoryBuilder는 MyBatis 구성 파일의 정의에 따라 SqlSessionFactory를 생성한다.
4. 클라이언트가 응용 프로그램에 대한 프로세스를 요청한다.
5. 응용 프로그램은 SqlSessionFactoryBuilder를 사용하여 빌드된 SqlSessionFactory에서 SqlSession을 가져온다
6. SqlSessionFactory는 SqlSession을 생성하고 이를 응용 프로그램에 반환한다.
7. 응용 프로그램이 SqlSession에서 매퍼 인터페이스의 구현 개체를 가져온다.
8. 응용 프로그램이 매퍼 인터페이스 메소드를 호출한다.
9. 매퍼 인터페이스 구현 객체가 SqlSession의 메소드를 호출하고 SQL실행을 요청한다.
10. SqlSession은 매핑 파일에서 실행할 SQL을 가져와 SQL을 실행한다.
