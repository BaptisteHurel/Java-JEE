#!/bin/sh
set -a
# bind mount - External
# -v /mnt/d/docker-volumes/tomcat/webapps:/usr/local/tomcat/webapps
# Internal volume - Very fast
# -v tomcat-volume
docker run -it --name tomcat --rm -p 8888:8080 -v tomcat-volume:/usr/local/tomcat/webapps server-tomcat:1.0
