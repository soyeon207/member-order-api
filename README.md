# 🙍‍♀🧾 member-order-api
회원 인증 및 주문 서비스 API 

## 👩‍💻 사용 스택 
Spring Boot : v2.7.1 + JPA, QueryDSL<br>
java : v11<br>
mysql : v8<br>

문서 자동화 : Swagger<br>
로그인 : Spring Security + JWT<br>
형상관리툴 : Flyway<br>

## 🤝 커밋 규칙
|태그 이름|설명|
|---|---|
|Feat|새로운 기능을 추가하는 경우|
|Fix|버그를 고친 경우|
|Style|코드 포맷 변경, 세미 콜론 누락, 코드 수정이 없는 경우|
|Refactor|리팩토링|
|Comment|필요한 주석 추가 및 변경|
|Docs|문서를 수정한 경우|
|Rename|파일 혹은 폴더명을 수정하거나 옮기는 작업만인 경우|
|Remove|파일을 삭제하는 작업만 수행한 경우|

`태그: 내용 (#이슈번호)`<br>

EX) Feat: 내용추가추가추가 (#1) , Refactor: Config 리팩토링 (#4)

## 실행 방법

### ① repository clone 받기 
```
git clone https://github.com/soyeon207/member-order-api.git
cd member-order-api
```

### ② docker-compose 실행
> 💡 Docker Desktop 을 실행하고 진행해주세요. 
> 없으신 경우  [Docker Desktop](https://www.docker.com/products/docker-desktop/) 에서 다운받아주시면 됩니다. 

```
docker-compose -p backpacker up -d
```

### ③ 환경변수 설정하기

configurations > environment variables 에 JWT 관련 environment 키-값을 세팅해주세요. 

|Name|Value| 설명      |
|---|---|---------|
|JWT_TOKEN|bWVtYmVyLW9yZGVyLWtleQ==| JWT 토큰  |
|JWT_REFRESH_TIME|1800| 30분     |
|JWT_EXPIRE_TIME|259200| 3일      |

### ④ 실행하기 
MemberOrderApplication 을 실행해주세요. 

## Swagger 사용하기
해당 프로젝트는 Swagger(springdoc-openapi v1.6.9) 을 사용해서 API 문서 자동화를 하고 있습니다.  

swagger 접속 URL : http://localhost:8080/swagger-ui/index.html

회원가입, 로그인 이외 API 들은 JWT 토큰이 있어야 합니다.

1. 오른쪽 상단의 **🔓Authorize** 를 누른다음  
![https://user-images.githubusercontent.com/39696812/177332423-9616ead5-77ae-4414-aea1-ecbce562c9f7.png](https://user-images.githubusercontent.com/39696812/177332423-9616ead5-77ae-4414-aea1-ecbce562c9f7.png)
2. 창이 뜨면 로그인 시 발급되는 token 을 입력해주세요. 
![https://user-images.githubusercontent.com/39696812/177332450-8c28852f-278d-4fa3-82a5-2a2a4b92d124.png](https://user-images.githubusercontent.com/39696812/177332450-8c28852f-278d-4fa3-82a5-2a2a4b92d124.png)

그러면 API 를 호출할 때 헤더에 `Authorization: Bearer #{입력한토큰값}` 을 넣어서 호출합니다.  





