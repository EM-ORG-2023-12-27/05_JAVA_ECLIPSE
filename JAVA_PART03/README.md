# JAVA_PART03
---

---
### 09 Object Class
---
[수업자료]() |
[참고]() |
[참고]() |
[참고]() |
[참고]() |

- 모든 클래스의 부모 클래스 
- toString() : 객체를 문자열로 표현
- equals(Object obj) : 두 객체가 동등한지 여부를 판단
- hashCode() : 객체의 해시 코드를 반환
- getClass() : 객체의 클래스를 나타내는 Class 객체를 반환
- clone() : 객체의 복제본을 생성하여 반환
- finalize() : 객체가 더 이상 참조되지 않을 때 가비지 컬렉터에 의해 호출되는 메소드
- wait(),notify(),notifyAll() : 객체의 동기화와 관련된 메소드로, 멀티스레드 환경에서 스레드 간의 통신을 위해 사용

---
### 10 예외처리
---
[수업자료]() |
[참고]() |
[참고]() |
[참고]() |
[참고]() |

- 예측가능한 경미한 오류 
- 프로그램이 실행 중에 발생(Runtime Error)
- try~catch~finally
- throw / throws

---
### 11 제너릭
---
[수업자료]() |
[참고]() |
[참고]() |
[참고]() |
[참고]() |

- 다양한 데이터 타입을 사용할 수 있도록 클래스나 메소드를 일반화하는 기능
- 클래스나 메소드를 선언할 때 타입 파라미터를 사용하여 특정 타입에 종속되지 않고 일반적으로 사용할 수 있다
- ![20240318082754](https://github.com/MY-ALL-LECTURE/JAVA/assets/84259104/2e4ae4bc-9278-4461-bcee-703debd4242d)
- ![20240318082800](https://github.com/MY-ALL-LECTURE/JAVA/assets/84259104/5a8fcf33-bdff-4567-840e-975210b123c1)
- ![20240318082805](https://github.com/MY-ALL-LECTURE/JAVA/assets/84259104/9b635cf9-6bfa-4299-98d5-214fd3485f7b)


---
### 12 컬렉션
---
[수업자료]() |
[참고-컬렉션](https://gangnam-americano.tistory.com/41) |
[참고-]() |
[참고]() |
[참고]() |

- 자료구조 클래스
  - LIST
    - ARRAYLIST
    - VECTOR
    - LINKEDLIST
  - SET
    - TREESET
    - HASHSET
    - LINKEDHASHSET
  - MAP
    - HASHMAP
    - TREEMAP
    - LINKEDHASHMAP
 
![20240401124057](https://github.com/MY-ALL-LECTURE/JAVA/assets/84259104/97bd4c11-fa5e-4cdb-9c09-ebd0286f9939)
![20240401124102](https://github.com/MY-ALL-LECTURE/JAVA/assets/84259104/0343e44d-383e-45d7-9c89-fd99234d3272)
![20240401124106](https://github.com/MY-ALL-LECTURE/JAVA/assets/84259104/11332d0f-dea4-44cf-9464-fdd53dd55e3e)
![20240401124133](https://github.com/MY-ALL-LECTURE/JAVA/assets/84259104/e6a66b11-5c52-4a60-8946-0db627f1515e)



---
### 13 GUI SWING
---
[수업자료]() |
[참고-SWING 정리](https://beautifulkim.tistory.com/350) |
[참고]() |
[참고]() |
[참고]() |

- JFrame: 
  - Swing 응용 프로그램의 기본 창입니다. 일반적으로 프로그램의 메인 윈도우로 사용됩니다.
- JPanel:
  - 컴포넌트를 그룹화하거나 다른 컴포넌트를 포함하는 데 사용됩니다. 보통 JFrame 안에 JPanel을 배치하여 레이아웃을 관리합니다.
- JButton:
  - 사용자가 클릭할 수 있는 단추를 나타냅니다.
- JLabel: 
  - 텍스트 또는 이미지를 표시하기 위한 컴포넌트입니다. 주로 정보를 표시하기 위해 사용됩니다.
- JTextField:
  - 사용자에게 텍스트를 입력할 수 있는 텍스트 상자를 나타냅니다.
- JTextArea:
  - 여러 줄의 텍스트를 입력하고 표시할 수 있는 텍스트 영역입니다.
- JCheckBox:
  - 사용자가 선택할 수 있는 체크 박스입니다. 하나 이상의 옵션을 선택할 수 있습니다.
-JRadioButton:
  -여러 옵션 중 하나를 선택할 수 있는 원형 버튼입니다.
- JComboBox:
  - 드롭다운 목록을 표시하여 사용자가 항목을 선택할 수 있도록 합니다.
- JList:
  - 여러 항목을 표시하는 리스트 컴포넌트입니다. 단일 선택 또는 다중 선택이 가능합니다.
- JScrollPane
  - 스크롤 가능한 컨테이너를 만들어줍니다. 내부에 다른 컴포넌트를 포함할 수 있으며, 컴포넌트가 화면에 맞지 않을 때 스크롤을 허용합니다.
- JDialog
  - 모달 또는 모달리스 다이얼로그를 나타냅니다. 일반적으로 애플리케이션 내에서 메시지를 표시하거나 사용자로부터 정보를 입력받을 때 사용됩니다.
- JFileChooser
  - 파일 선택을 위한 대화상자를 나타냅니다. 사용자가 파일을 선택하고 파일 시스템을 탐색할 수 있도록 합니다.

---
### 13 FILE IO
---
[수업자료]() |
[참고]() |
[참고]() |
[참고]() |
[참고]() |

- 기본 스트림
  - READER / WRITER
  - CHAR STREAM FILE COPY
  - INPUTSTREAM / OUTPUTSTREAM
  - BYTE STREAM FILE COPY
  - URLSTREAM
- 보조 스트림
  - CHARACTERCONVERTERSTREAM
  - READLINE
  - DATAINPUT/OUTPUTSTREAM
  - PRINTSTREAM
  - OBJECTSTREAM
  - BUFFEREDSTREAM
  - ...
---
### 14 JDBC
---
[수업자료]() |
[참고]() |
[참고]() |
[참고]() |
[참고]() |

- JDBC란
  - JDBC(Java Database Connectivity)는 자바 프로그램에서 데이터베이스에 접근하고 관리하기 위한 자바 API입니다. JDBC를 사용하면 다양한 데이터베이스에 대한 일관된 방식으로 액세스할 수 있으며, 데이터베이스에 대한 쿼리 실행, 데이터의 삽입,     갱신, 삭제 등의 작업을 수행할 수 있습니다.
- 주요 클래스
  - Connection: 데이터베이스 연결을 나타냅니다. DriverManager.getConnection() 메서드를 사용하여 데이터베이스에 연결됩니다.
  - Statement: SQL 쿼리를 실행하기 위한 인터페이스입니다. Connection.createStatement() 메서드를 사용하여 Statement 객체를 생성합니다.
  - PreparedStatement: 미리 컴파일된 SQL 문을 나타내며, 매개 변수화된 쿼리를 실행하는 데 사용됩니다.
  - ResultSet: 쿼리 실행 결과를 저장하는 인터페이스입니다. 데이터베이스로부터 반환된 결과 집합을 나타냅니다.
  - DriverManager: JDBC 드라이버를 등록하고, 데이터베이스에 대한 연결을 생성하는데 사용됩니다.

---
### 15 SOCKET
---
[수업자료]() |
[참고]() |
[참고]() |
[참고]() |
[참고]() |

- SocketServer
- Socket
- In/OutStream


---
### 16 THREAD
---
[수업자료]() |
[참고]() |
[참고]() |
[참고]() |
[참고]() |

- Runnable
- Thread
- Syncronized()
- wait / notify /notifyAll


---
### 17 REFLECT
---
[수업자료]() |
[참고 - 리플렉션](https://jeongkyun-it.tistory.com/225) |
[참고]() |
[참고]() |
[참고]() |

-
-
-

---
### 18 디자인패턴
---
[수업자료]() |
[참고 - 디자인패턴](https://refactoring.guru/ko/design-patterns/java) |
[참고]() |
[참고]() |
[참고]() |

- Class.forName
- getDeclaredField()
- getDeclaredMethod()
- getConstructor()
- ...

---
### 19 LAMDA / STREAM
---
[수업자료]() |
[참고-LAMDA](https://www.tcpschool.com/java/java_lambda_concept) |
[참고-STREAM](https://www.tcpschool.com/java/java_stream_concept) |
[참고]() |
[참고]() |

- 
-
-

---
### 20 함수형 프로그래밍
---
[수업자료]() |
[참고]() |
[참고]() |
[참고]() |
[참고]() |

-
-
-

---
### 21 클래스다이어그램
---
[수업자료]() |
[참고]() |
[참고]() |
[참고]() |
[참고]() |

-
-
-



---
### CF
---
[참고-버블버블게임](https://www.youtube.com/watch?v=5Zh7P-9qFO0) |
[참고-버블버블깃허브](https://github.com/codingspecialist/Java-Swing-BubbleGame) |
[]() |
[]() |


