http://www.conductor.com/nightlight/running-selenium-grid-using-docker-compose/

sudo mkdir dockerdemo
sudo mount -t vboxsf c/dockerdemo /c/dockerdemo

# instalacja docker-composer
sudo curl -L https://github.com/docker/compose/releases/download/1.1.0/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose

# budujemy Dockerfile
#common
sudo docker build -t selenium/base .
# hub
sudo docker build -t selenium/hub .
# node
sudo docker build -t selenium/firefox .


# docker-compose
FROM dduportal/docker-compose:latest
MAINTAINER your.mail@here

ADD . /app/ # your docker-compose.yml can be copied inside the image
ENV DOCKER_HOST tcp://192.168.0.1:2375 # Customize the docker socket
############


# na linuksach
sudo docker-compose up -d
docker build -t you/docker-compose ./
docker run -ti you/docker-compose ps

#! na windowsach
alias dco="docker run -d -e VIRTUAL_HOST=nkx.com -v /c/dockerdemo/seleniumgrid/composer:/app -v /var/run/docker.sock:/var/run/docker.sock -ti dduportal/docker-compose:latest"

docker-compose up -d
docker-compose scale firefox=5

docker-compose stop
docker-compose rm

nsenter --target $(docker inspect --format {{.State.Pid}} 2d479773e454) --mount --uts --ipc --net --pid

nsenter --target $(docker inspect --format {{.State.Pid}} 40e72b41f2d2) --mount --uts --ipc --net --pid


java -jar selenium-server-standalone-2.45.0.jar -role webdriver -hub http://nkx.com:4444/grid/register -host nkx.com -port 5555

############
############
# start selenium hub
java -jar selenium-server-standalone-2.45.0.jar -role hub
java -jar selenium-server-standalone-2.45.0.jar -role node  -hub http://localhost:4444/grid/register -browser browserName=firefox,maxInstances=5 -browser "browserName=internet explorer,maxInstances=5" -maxSession 5

java -jar selenium-server-standalone-2.45.0.jar -role webdriver -hub http://localhost:4444/grid/register -port 5555 -browser browserName=firefox

java -Dwebdriver.chrome.driver=C:/Docker-Demo/chromedriver_win32.zip -jar selenium-server-standalone-2.45.0.jar -role webdriver -hub http://localhost:4444/grid/register -port 6666 -browser browserName=chrome