mkdir cls
javac -d ./cls com/edh/utility/*.java
javac -d ./cls com/edh/main/*.java && java -cp ./cls com.edh.main.Main
