#!/bin/bash

OJDBC_JAR_PATH=D:/lib/java/ojdbc14.jar

mvn install:install-file -Dfile=$OJDBC_JAR_PATH -DgroupId=com.oracle -DartifactId=ojdbc14 -Dversion=10.2.0.1.0 -Dpackaging=jar

exit 0
