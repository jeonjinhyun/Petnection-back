<p align="middle" >
  <img width="200px;" src="https://firebasestorage.googleapis.com/v0/b/fir-readme-storage.appspot.com/o/logo.jpg?alt=media&token=46aada62-533c-4ee0-8b0a-c454d033733f"/>
</p>
<h1 align="middle">Petnection</h1>
<h3 align="middle">반려동물과 함께하는 메타버스 공간</h3>

<br/>

## 📝 작품소개

**Petnection**은 반려동물과 함께 메타버스 공간에서 놀고, 추억을 저장하며, 다른 사용자들과 공유할 수 있는 플랫폼입니다. 실제 반려동물 또는 가상의 반려동물과 함께 가상 공간에서 소통하고 커뮤니티를 형성할 수 있습니다.
<br/>

## 🎞 Demo
[시연영상](https://drive.google.com/file/d/1Nfws3nvCTwPNvBiqw7p1wuqK_kPV_0J4/view?usp=drive_link)<br/>
[PDF다운로드](https://drive.google.com/drive/folders/1OaxGK4_IwRO0C4N7InPWIAcKHZZWCOUc?usp=drive_link)

<br/>

## ⭐ 주요 기능
- **커스터마이징** : 반려동물 사진을 기반으로 가상의 반려동물 만들기

<img width="1666" alt="스크린샷 2022-10-11 오후 8 10 43" src="https://github.com/user-attachments/assets/a26e54c7-7c38-4628-b490-75ef09ebfb3f">

- **마이룸** : 나와 반려동물만의 교감공간

<img width="1609" alt="스크린샷 2022-10-11 오후 8 13 01" src="https://github.com/user-attachments/assets/66d4391d-911e-430c-939a-1ef371ce2c67">

- **커뮤니티 룸** : 다른 유저와 소통하고 맵을 커스텀하고, 나만의 포토앨범을 만들어봐요

<img width="1438" alt="5" src="https://github.com/user-attachments/assets/9147040a-6652-477a-add9-8a5ed08cdb56">

- **커뮤니티룸 컨텐츠** : 추억앨범,커뮤니티,굿즈 생성기기능

<img width="300" alt="5" src="https://github.com/user-attachments/assets/5620f662-a386-42c0-beb5-8023475eb01d">
<img width="300" alt="5" src="https://github.com/user-attachments/assets/ebe2fb51-2f37-4faf-bfb3-0ad99d21cd22">
<img width="300" alt="5" src="https://github.com/user-attachments/assets/1acb7496-f14d-410e-a39b-234cfc361791">

- **PC/모바일** : 기기제한,다운로드없이 PC와 모바일로 접근가능한 소셜 네트워크 서비스

<img width="500" alt="스크린샷 2022-10-11 오후 8 14 25" src="https://github.com/user-attachments/assets/f4a33d8b-cb94-47e9-999a-ba5d808610f1">
<img width="300" alt="스크린샷 2022-10-11 오후 8 14 25" src="https://github.com/user-attachments/assets/8a3f588f-b728-4b60-83fe-391e41b4a5e0">





<br/>

## 시스템 아키텍처

### 기술 스택
- **Framework**: Spring Boot
- **Architecture**: Monolithic Layered Architecture
- **Database**: PostgreSQL/MySQL
- **Storage**: MinIO (이미지 저장)
- **AI Integration**: External AI Server (REST API)
- **Containerization**: Docker & Docker Compose
- **Build Tool**: Gradle/Maven

### 아키텍처 구조
```
Application Layer (Controllers, REST APIs)
         ↓
Domain Layer (Business Logic, Services)
         ↓
Infrastructure Layer (Repository, External APIs)
         ↓
[Database] [MinIO] [AI Server]
```

## 도메인 구조

### 도메인 목록
각 도메인은 Application-Domain-Infrastructure 3계층 구조로 구성됩니다.

#### 1. **Community** 도메인
- **기능**: 커뮤니티 게시글, 댓글, 반려동물 자랑하기
- **주요 엔티티**: Post, Comment, Like, Share
- **특징**: 반려동물과의 추억을 다른 사용자들과 공유

#### 2. **Friend** 도메인
- **기능**: 친구 관계, 친구 요청, 친구 목록 관리
- **주요 엔티티**: Friendship, FriendRequest
- **특징**: 반려동물 친구들과의 네트워킹

#### 3. **MyRoom** 도메인
- **기능**: 개인 가상 공간, 룸 꾸미기, 반려동물 활동
- **주요 엔티티**: Room, RoomItem, PetActivity
- **특징**: 나만의 메타버스 공간에서 반려동물과 상호작용

#### 4. **Object** 도메인
- **기능**: 가상 아이템, 장식품, 반려동물 용품 관리
- **주요 엔티티**: Item, ItemCategory, UserItem
- **특징**: 메타버스 공간을 꾸미는 다양한 오브젝트

#### 5. **User** 도메인
- **기능**: 사용자 관리, 반려동물 프로필, 인증
- **주요 엔티티**: User, Pet, UserProfile
- **특징**: 사용자와 반려동물 정보 통합 관리

## 레이어 상세 구조

### Application Layer
- **Controllers**: REST API 엔드포인트 제공
- **DTOs**: 데이터 전송 객체
- **Request/Response**: API 입출력 모델

### Domain Layer
- **Entities**: 도메인 핵심 객체
- **Services**: 비즈니스 로직 처리
- **Domain Events**: 도메인 이벤트 처리

### Infrastructure Layer
- **Repositories**: 데이터 액세스 레이어
- **External APIs**: AI 서버 통신
- **File Storage**: MinIO 연동
- **Configuration**: 외부 시스템 설정

## 외부 시스템 연동

### AI 서버 통신
Infrastructure 레이어에서 AI 서버와 REST API 통신을 수행합니다.

**주요 AI 기능:**
- 반려동물 행동 분석
- 추천 시스템 (친구, 아이템)
- 자연어 처리 (커뮤니티 게시글)
- 이미지 분석 (반려동물 사진)

### MinIO 스토리지
- **사용처**: 반려동물 사진, 사용자 프로필 이미지, 룸 스크린샷
- **구조**: 도메인별 버킷 분리
- **보안**: 접근 권한 관리 및 이미지 압축

## 프로젝트 구조

```
src/main/java/com/petnection/
├── application/           # Application Layer
│   ├── community/
│   │   ├── controller/   # REST Controllers
│   │   └── dto/          # Data Transfer Objects
│   ├── friend/
│   ├── myroom/
│   ├── object/
│   └── user/
├── domain/               # Domain Layer
│   ├── community/
│   │   ├── entity/       # Domain Entities
│   │   ├── service/      # Domain Services
│   │   └── event/        # Domain Events
│   ├── friend/
│   ├── myroom/
│   ├── object/
│   └── user/
└── infrastructure/       # Infrastructure Layer
    ├── community/
    │   └── repository/   # Data Repositories
    ├── friend/
    ├── myroom/
    ├── object/
    ├── user/
    ├── ai/              # AI Server Integration
    ├── storage/         # MinIO Integration
    └── config/          # Configuration
```

## Docker 환경 구성

### docker-compose.yml
```yaml
version: '3.8'
services:
  petnection-backend:
    build: .
    ports:
      - "8080:8080"
    depends_on:
      - database
      - minio
    environment:
      - SPRING_PROFILES_ACTIVE=docker
      
  database:
    image: postgres:14
    environment:
      POSTGRES_DB: petnection
      POSTGRES_USER: petnection
      POSTGRES_PASSWORD: password
    volumes:
      - postgres_data:/var/lib/postgresql/data
      
  minio:
    image: minio/minio
    ports:
      - "9000:9000"
      - "9090:9090"
    environment:
      MINIO_ROOT_USER: minioadmin
      MINIO_ROOT_PASSWORD: minioadmin
    command: server /data --console-address ":9090"
    volumes:
      - minio_data:/data

volumes:
  postgres_data:
  minio_data:
```

## 개발 환경 설정

### 1. 프로젝트 클론
```bash
git clone https://github.com/your-org/petnection-backend.git
cd petnection-backend
```

### 2. Docker 환경 실행
```bash
docker-compose up -d
```

### 3. 애플리케이션 실행
```bash
./gradlew bootRun
```

### 4. API 테스트
- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **MinIO Console**: http://localhost:9090

## API 문서

### 주요 엔드포인트

#### Community API
- `GET /api/community/posts` - 커뮤니티 게시글 목록
- `POST /api/community/posts` - 게시글 작성
- `POST /api/community/posts/{id}/like` - 좋아요

#### Friend API
- `GET /api/friends` - 친구 목록
- `POST /api/friends/request` - 친구 요청
- `PUT /api/friends/accept/{id}` - 친구 요청 수락

#### MyRoom API
- `GET /api/myroom` - 내 룸 정보
- `PUT /api/myroom/decorate` - 룸 꾸미기
- `POST /api/myroom/pet/activity` - 반려동물 활동 기록

#### Object API
- `GET /api/objects` - 아이템 목록
- `POST /api/objects/purchase` - 아이템 구매
- `GET /api/objects/inventory` - 보유 아이템

#### User API
- `GET /api/users/profile` - 사용자 프로필
- `PUT /api/users/profile` - 프로필 수정
- `POST /api/users/pets` - 반려동물 등록

## 배포

### 프로덕션 환경
```bash
# 이미지 빌드
docker build -t petnection-backend:latest .

# 프로덕션 실행
docker-compose -f docker-compose.prod.yml up -d
```

### 환경 변수
- `SPRING_PROFILES_ACTIVE`: 실행 환경 (dev, prod)
- `DATABASE_URL`: 데이터베이스 연결 URL
- `MINIO_ENDPOINT`: MinIO 서버 엔드포인트
- `AI_SERVER_URL`: AI 서버 API URL

## 개발 가이드라인

### 코딩 컨벤션
1. **패키지 구조**: 도메인별로 application/domain/infrastructure 분리
2. **네이밍**: 도메인 용어 사용, 명확한 의미 전달
3. **레이어 간 의존성**: 상위 레이어에서 하위 레이어로만 의존
4. **외부 통신**: Infrastructure 레이어에서만 처리

### 테스트 전략
- **단위 테스트**: Domain Layer 중심
- **통합 테스트**: API 엔드포인트
- **외부 연동 테스트**: AI 서버, MinIO 연동

## 기여하기

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 라이선스
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

🐾 **Happy coding with your virtual pets!** 🐾
