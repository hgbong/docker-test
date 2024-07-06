# 베이스 이미지로 Python 3.8 사용
FROM python:3.8-slim

# 작업 디렉토리 설정
WORKDIR /app

# 현재 디렉토리의 모든 파일을 컨테이너의 /app 디렉토리에 복사
COPY . /app

# 종속성 설치
RUN pip install --no-cache-dir -r requirements.txt

EXPOSE 1234

# 애플리케이션 실행
CMD ["python", "app.py"]

