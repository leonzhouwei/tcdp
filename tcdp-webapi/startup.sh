#!/bin/bash

base_path=$(cd `dirname $0`; pwd)
cd $base_path

java -jar tcdp-webapi*.jar

exit 0

