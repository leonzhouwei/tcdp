#!/bin/bash

CONFIG=config
BUILD=build
TARGET=target
base_path=$(cd `dirname $0`; pwd)

cd $base_path

mvn clean
mvn package -Dmaven.test.skip=true

rm -rf $BUILD
mkdir $BUILD
cp -r $CONFIG/ $BUILD/
cp startup.sh $BUILD/
cp $TARGET/tcdp-webapi*.jar $BUILD/

exit 0

