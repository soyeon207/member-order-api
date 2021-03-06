# ๐โโ๐งพ member-order-api  <img src="https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https://github.com/soyeon207/member-order-api&count_bg=%23000000&title_bg=%23000000&icon=github.svg&icon_color=%23E7E7E7&title=GitHub&edge_flat=false"/>
ํ์ ์ธ์ฆ ๋ฐ ์ฃผ๋ฌธ ์๋น์ค API 

## ๐ฉโ๐ป ์ฌ์ฉ ์คํ 
Spring Boot : v2.7.1 + JPA, QueryDSL<br>
java : v11<br>
mysql : v8<br>

๋ฌธ์ ์๋ํ : Swagger<br>
๋ก๊ทธ์ธ : Spring Security + JWT<br>
ํ์๊ด๋ฆฌํด : Flyway<br>

## ๐ค ์ปค๋ฐ ๊ท์น
|ํ๊ทธ ์ด๋ฆ|์ค๋ช|
|---|---|
|Feat|์๋ก์ด ๊ธฐ๋ฅ์ ์ถ๊ฐํ๋ ๊ฒฝ์ฐ|
|Fix|๋ฒ๊ทธ๋ฅผ ๊ณ ์น ๊ฒฝ์ฐ|
|Style|์ฝ๋ ํฌ๋งท ๋ณ๊ฒฝ, ์ธ๋ฏธ ์ฝ๋ก  ๋๋ฝ, ์ฝ๋ ์์ ์ด ์๋ ๊ฒฝ์ฐ|
|Refactor|๋ฆฌํฉํ ๋ง|
|Comment|ํ์ํ ์ฃผ์ ์ถ๊ฐ ๋ฐ ๋ณ๊ฒฝ|
|Docs|๋ฌธ์๋ฅผ ์์ ํ ๊ฒฝ์ฐ|
|Rename|ํ์ผ ํน์ ํด๋๋ช์ ์์ ํ๊ฑฐ๋ ์ฎ๊ธฐ๋ ์์๋ง์ธ ๊ฒฝ์ฐ|
|Remove|ํ์ผ์ ์ญ์ ํ๋ ์์๋ง ์ํํ ๊ฒฝ์ฐ|

`ํ๊ทธ: ๋ด์ฉ (#์ด์๋ฒํธ)`<br>

EX) Feat: ๋ด์ฉ์ถ๊ฐ์ถ๊ฐ์ถ๊ฐ (#1) , Refactor: Config ๋ฆฌํฉํ ๋ง (#4)

## ์คํ ๋ฐฉ๋ฒ

### โ  repository clone ๋ฐ๊ธฐ 
```
git clone https://github.com/soyeon207/member-order-api.git
cd member-order-api
```

### โก docker-compose ์คํ
> ๐ก Docker Desktop ์ ์คํํ๊ณ  ์งํํด์ฃผ์ธ์. 
> ์์ผ์  ๊ฒฝ์ฐ  [Docker Desktop](https://www.docker.com/products/docker-desktop/) ์์ ๋ค์ด๋ฐ์์ฃผ์๋ฉด ๋ฉ๋๋ค. 

```
docker-compose -p backpacker up -d
```

### โข ํ๊ฒฝ๋ณ์ ์ค์ ํ๊ธฐ

configurations > environment variables ์ JWT ๊ด๋ จ environment ํค-๊ฐ์ ์ธํํด์ฃผ์ธ์. 

|Name|Value| ์ค๋ช      |
|---|---|---------|
|JWT_TOKEN|bWVtYmVyLW9yZGVyLWtleQ==| JWT ํ ํฐ  |
|JWT_REFRESH_TIME|1800| 30๋ถ     |
|JWT_EXPIRE_TIME|259200| 3์ผ      |

### โฃ ์คํํ๊ธฐ 
MemberOrderApplication ์ ์คํํด์ฃผ์ธ์. 

## Swagger ์ฌ์ฉํ๊ธฐ
ํด๋น ํ๋ก์ ํธ๋ Swagger(springdoc-openapi v1.6.9) ์ ์ฌ์ฉํด์ API ๋ฌธ์ ์๋ํ๋ฅผ ํ๊ณ  ์์ต๋๋ค.  

swagger ์ ์ URL : http://localhost:8080/swagger-ui/index.html

ํ์๊ฐ์, ๋ก๊ทธ์ธ ์ด์ธ API ๋ค์ JWT ํ ํฐ์ด ์์ด์ผ ํฉ๋๋ค.

1. ์ค๋ฅธ์ชฝ ์๋จ์ **๐Authorize** ๋ฅผ ๋๋ฅธ๋ค์  
![https://user-images.githubusercontent.com/39696812/177332423-9616ead5-77ae-4414-aea1-ecbce562c9f7.png](https://user-images.githubusercontent.com/39696812/177332423-9616ead5-77ae-4414-aea1-ecbce562c9f7.png)
2. ์ฐฝ์ด ๋จ๋ฉด ๋ก๊ทธ์ธ ์ ๋ฐ๊ธ๋๋ token ์ ์๋ ฅํด์ฃผ์ธ์. 
![https://user-images.githubusercontent.com/39696812/177332450-8c28852f-278d-4fa3-82a5-2a2a4b92d124.png](https://user-images.githubusercontent.com/39696812/177332450-8c28852f-278d-4fa3-82a5-2a2a4b92d124.png)

๊ทธ๋ฌ๋ฉด API ๋ฅผ ํธ์ถํ  ๋ ํค๋์ `Authorization: Bearer #{์๋ ฅํํ ํฐ๊ฐ}` ์ ๋ฃ์ด์ ํธ์ถํฉ๋๋ค.  





