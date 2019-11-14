# java-spring-util

project for spring boot project , include date util , json util, ObjectCopy util etc.


## javadoc 注释修复插件





~~~shell
# 将 clirr jar安装到本地
mvn install:install-file -Dfile=docs/clirr-maven-plugin-2.8.jar -DgroupId=org.codehaus.mojo -DartifactId=clirr-maven-plugin -Dversion=2.8 -Dpackaging=jar

# 执行修复命令
javadoc:fix -DcomparisonVersion=1.0
~~~