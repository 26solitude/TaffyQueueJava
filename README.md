# TaffyQueueJava

태피 상점의 큐 시뮬레이션

해변가에 있는 태피(taffy) 상점에서 일어나는 큐 모델을 생각해 본다.
그 상점은 한 개의 창구만을 가지며 한 명의 점원이 한 번에 한 명의 고객만을 서비스 할 수 있다.
고객을 서비스하는 시간은 1분에서 10분 사이가 소요된다. 그 상점은 하루 8시간, 주 7일 일을 한다.
우리는 그 상점의 하루의 일을 시뮬레이션하기 위해 480분(8시간*60분)을 갖는 큐 모델을 생성한다.

시뮬레이션은 이벤트가 1분 간격으로 시작하고 정지하는 디지털 클록을 사용한다.
즉, 고객들은 분단위로 도착하여 큐에서 분단위로 합산된 시간만큼 대기하고 임의의 시간만큼 서비스된다.
매 분단위의 시뮬레이션은 3개의 이벤트인 고객의 도착시간, 고객의 서비스 시작시간, 고객의 서비스 완료시간을 체크한다.
최종적으로 이 시뮬레이션에서 주어진 시간 동안에 고객의 수, 전체 서비스 시간, 평균 서비스 시간, 평균 대기시간 등의 통계 정보를 출력한다.

![sqfqfqsfq](https://user-images.githubusercontent.com/109591135/208357837-50a4800f-1b0d-4b72-a24f-d132a4f7bef0.jpg)

![QFWFQWQFWQFW](https://user-images.githubusercontent.com/109591135/208357617-8934062c-f1e8-4de9-8731-ee14c154770e.JPG)

