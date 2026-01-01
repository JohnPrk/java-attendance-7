# java-attendance-precourse

## ⚙️ 구현 순서

### 1단계 - 파일 입출력 및 크루원 출석 기록 저장

- [x] 데이터를 저장할 핵심 도메인 객체(`Crew`, `Attendance`) 및 일급 컬렉션(`Crews`, `Attendances`) 정의
- [x] `attendances.csv` 파일을 Files.readAllLines()로 읽어와 파싱
- [x] 읽어온 데이터를 도메인 객체에 매핑하여 저장(`초기 데이터 적재`)

### 2단계 - 메뉴 입력 구현
- [x] 메뉴 도메인 객체(`Menu`-Enum) 정의
- [x] 메뉴 입력 요청 메시지 출력
- [x] [사용자] 메뉴 입력
- [x] 메뉴 입력에 따른 유효성 검사
- [x] 사용자 입력 유효성 검사 실패시 재입력 반복 로직 추가 <=개발과정에서 추가
