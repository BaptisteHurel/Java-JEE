::
:: Start Container on port 8888 and expose webapps directory for delivery
::
:: -v D:/docker-volumes/tomcat/webapps:/usr/local/tomcat/webapps

docker run -it --name tomcat --rm -p 8888:8080 -v tomcat-volume:/usr/local/tomcat/webapps server-tomcat:1.0