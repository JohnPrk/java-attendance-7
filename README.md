# java-attendance-precourse

## ⚙️ 구현 순서

### 1단계 - 파일 입출력 및 크루원 출석 기록 저장

- [x] 데이터를 저장할 핵심 도메인 객체(Crew, Attendance) 및 일급 컬렉션(Crews, Attendances) 정의
- [x] `attendances.csv` 파일을 `Files.readAllLines()`로 읽어와 파싱
- [x] 읽어온 데이터를 도메인 객체에 매핑하여 저장 (초기 데이터 적재)

