#!/bin/bash

JSVC_EXECUTABLE="$( which jsvc )"
JSVC_PID_FILE=/tmp/@dist.project.id@.pid

if [ -z "$JSVC_USER" ]; then
	JSVC_USER="$USER"
fi

DIST_DIR="$( cd "$( dirname "@BASH_SOURCE[0]@" )/../" && pwd )"
LIB_DIR="$DIST_DIR/lib"
CONF_DIR="$DIST_DIR/conf"

SPRING_BOOT_APP=@dist.start.class@

JAVA_EXEC="$( which java )"
JAVA_CLASSPATH="$CONF_DIR:$LIB_DIR/*"
JAVA_MAIN_CLASS="net.nicoll.boot.daemon.SpringBootDaemon"
JAVA_ARGUMENTS=$SPRING_BOOT_APP


export JSVC_EXECUTABLE JSVC_PID_FIL JSVC_USER DIST_DIR CONF_DIR SPRING_BOOT_APP JAVA_EXEC \
	JAVA_CLASSPATH JAVA_MAIN_CLASS JAVA_ARGUMENTS