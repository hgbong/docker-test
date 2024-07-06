# 실습 환경
- docker는 linux에서 실행됨
- windows에서는 보통 WSL2을 통해 경량 리눅스 환경을 구성 (윈도우에서 리눅스 VM 올리는 것과 유사한 환경)
- 설치된 docker desktop은, 윈도우 내 WSL2 리눅스 환경을 사용해 dockerd 구동

# 개념
- container: 모든 배포환경 (sources, libs, env\_variables, ...)
- volumn: host <-> container 또는 container <-> container 간의 영속성 관련
- network: container간 내부 통신
- hub: public image 저장소 / registry: private image 저장소


# 실습
사전: (windows에서) docker desktop 실행 필요
```
docker run hello-world
흐름: docker client -> dockerd: find&pull hello-world image (from docker hub)
  -> container created. (by dockerd) 
  -> output streamed to docker client (from dockerd)
한줄로: dockerc -> dockerd -> hub -> (conteinr created.) -> dockerc
```


git bash는 docker에서 tty로 인식하지 않아, winpty 명령어 통해 컨테이너 실행
```
winpty docker run -it ubuntu bash
```


image 생성
```
docker build -t my-app-tag .  # -t: tag , .: Dockerfile path
build artifact(image)는 docker hub에 저장됨 (host에 저장 X, docker desktop 사용할 경우 여기에 저장)
```


```
PS C:\Users\hgb\sty> docker images
REPOSITORY      TAG       IMAGE ID       CREATED         SIZE
my-python-app   latest    edbdb77944d3   9 minutes ago   135MB    # docker build -t my-python-app . 결과물
ubuntu          latest    35a88802559d   4 weeks ago     78.1MB
hello-world     latest    d2c94e258dcb   14 months ago   13.3kB
```

container 실행
```
PS C:\Users\hgb\sty> docker run -p 7777:77 my-python-app
 * Serving Flask app 'app'
 * Debug mode: off
WARNING: This is a development server. Do not use it in a production deployment. Use a production WSGI server instead.
 * Running on all addresses (0.0.0.0)
 * Running on http://127.0.0.1:5000  # container에서 찍힌 로그
 * Running on http://172.17.0.2:5000 # container에서 찍힌 로그
Press CTRL+C to quit

문제상황: curl localhost:7777/ => 서버접근X
원인: port mapping 은 잘 됨. 하지만 구동된 WAS가 5000번 포트에서 뜸 (flask default port)
해결
- 1. container port를 5000으로 하여, -p 7777:5000 구동 
- 2. flask 앱을 77 포트로 띄움
```

# Volumne
볼륨(v)
- host에 데이터를 영구 저장하는 storage 메커니즘
- host 파일 시스템의 특정 디렉토리에 해당
v 마운트
- v를 container 내 디렉토리에 연결하는 과정
- container가 해당 디렉토리 접근 -> host의 v에 저장된 데이터 접근가능

- 기본적으로, host의 /var/lib/docker/volumes/{volumeName}/_data 에 저장됨
- - (윈도우에는 /var/lib/.. 경로가 없지만 WSL 통해)
- volumes: 설정을 통해 host의 특정 디렉토리로도 볼륨 지정 가능











