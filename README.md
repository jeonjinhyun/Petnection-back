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
- **Database**: MySQL
- **ORM**: JPA
- **Storage**: MinIO (이미지 저장)
- **AI Integration**: External AI Server
- **Containerization**: Docker & Docker Compose
- **Build Tool**: Gradle

### 아키텍처 구조
```
Presentation Layer (Controllers, Dtos)
         ↓
Application Layer (Event,Facade,Mapper,Service)
         ↓
Domain Layer (Model,Repository)
         ↓
Infrastructure Layer (External(AI),Minio)
         ↓
[Database] [MinIO] [AI Server]
```

## 도메인 구조

### 도메인 목록
각 도메인은 Application-Domain-Infrastructure 3계층 구조로 구성됩니다.

#### 1. **Community** 도메인
- **기능**: 커뮤니티 게시글, 댓글, 반려동물 자랑하기
- **주요 엔티티**: Post, Comment, Like 
- **특징**: 반려동물과의 추억을 다른 사용자들과 공유

#### 2. **Friend** 도메인
- **기능**: 친구 관계, 친구 요청, 친구 목록 관리
- **주요 엔티티**: Friendship, FriendRequest
- **특징**: 반려동물 친구들과의 네트워킹

#### 3. **MyRoom** 도메인
- **기능**: 개인 가상 공간, 룸 꾸미기, 반려동물 활동
- **주요 엔티티**: MyRoom,Gallery
- **특징**: 나만의 메타버스 공간에서 반려동물과 상호작용

#### 4. **Object** 도메인
- **기능**: 가상 아이템, 장식품, 반려동물 용품 관리
- **주요 엔티티**: Object
- **특징**: 메타버스 공간을 꾸미는 다양한 오브젝트

#### 5. **User** 도메인
- **기능**: 사용자 관리, 반려동물 프로필, 인증
- **주요 엔티티**: User, Pet, UserProfile
- **특징**: 사용자와 반려동물 정보 통합 관리

## 레이어 상세 구조

### Presentation Layer
- **Controllers**: REST API 엔드포인트 제공
- **DTOs**: 데이터 전송 객체

- ### Application Layer
- **Facade**: 여러 도메인에서 필요한 기능을 모아서 인터페이스로 제공
- **Mapper**: Entity와 dto간의 자동 매
- **Service**: 서비스 계층

### Domain Layer
- **Entities**: 도메인 핵심 객체
- **Repository**: Infra레이어의 repository 인터페이스

### Infrastructure Layer
- **Repositories**: JPA인터페이스를 상속받는 Repository레이어
- **External APIs**: AI 서버 통신
- **File Storage**: MinIO 연동
- **Configuration**: 외부 시스템 설정

