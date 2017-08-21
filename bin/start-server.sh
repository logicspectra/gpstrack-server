#!/bin/sh

DS_NAME=gpstrack
DS_USERNAME=developer
DS_PASSWORD=developer
DS_URL=jdbc:postgresql://localhost/gpstrack

JAVA_OPTS="-Xms128M -Xmx512M -Dswarm.ds.name=${DS_NAME} -Dswarm.ds.username=${DS_USERNAME} -Dswarm.ds.password=${DS_PASSWORD} -Dswarm.ds.connection.url=${DS_URL} $JAVA_OPTS"


CONTEXT_ROOT=${CONTEXT_ROOT:-'/'}
HEAPDUMPDIR=${HEAPDUMPDIR:-'/var/log/dump'}
APP_WAR=../target/gpstrack-server.war


java -Dswarm.context.path=$CONTEXT_ROOT -XX:+ExitOnOutOfMemoryError -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$HEAPDUMPDIR $JAVA_OPTS -jar ../target/gpstrack-server-hollow-swarm.jar  "$APP_WAR"


#"gpstrack-server-hollow-swarm.jar", "-c", "/etc/wildfly.xml"
