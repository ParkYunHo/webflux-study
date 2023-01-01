# language: ko
기능: 곡정보 관리API 호출
  모든 사용자는 곡정보 관리API를 호출한다.

  @song
  시나리오 개요: 곡정보 관리API 호출
    먼저 곡정보 관리API 호출을 위한 "<songId>""<songName>" 가 있다
    만약 곡정보 관리API를 "<method>""<url>" 요청하면
    그러면 곡정보 관리API 호출결과 <code>"<status>" 를 확인한다

    예:
    | songId    | songName    | method    | url                   | code      | status      |
    | 1234      |             | GET       | /api/song/{songId}    | 200       | OK          |
    |           |             | GET       | /api/song             | 200       | OK          |
    | 1111      | TEST        | POST      | /api/song             | 200       | OK          |