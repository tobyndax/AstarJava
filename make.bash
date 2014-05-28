#!/bin/bash

clear
javac $1 -d ./cls com/edh/utility/*.java
javac $1 -d ./cls com/edh/main/*.java

java -cp ./cls com.edh.main.Main
