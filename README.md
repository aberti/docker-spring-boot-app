# docker-spring-boot-app

# build jar
mvn clean package

#build image
docker  build –t aberti/spring-boot-app:0.0.1 .

# push image
docker login –u aberti
docker push aberti/spring-boot-app:0.0.1

# run application from client
docker run --rm -p 8080:8080 -it aberti/spring-boot-app:latest



# all at once
export VERSION=0.0.1 &&/
git reset --hard origin/master &&/
git pull &&/
mvn clean package &&/
docker build –t aberti/spring-boot-app:0.0.1 . &&/
docker login –u aberti &&/
docker push aberti/spring-boot-app:0.0.1