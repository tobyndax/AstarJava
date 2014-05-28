#!/bin/bash

clear
if [ ! -d "cls" ]; then
  mkdir cls
fi

javac $1 -d ./cls com/edh/utility/*.java
javac $1 -d ./cls com/edh/main/*.java && java -cp ./cls com.edh.main.Main
