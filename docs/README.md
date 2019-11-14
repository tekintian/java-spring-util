# java spring util 文档

## [API文档](apidocs/index.html)



## 相关插件安装到本地仓库

-- [idea中无法加载时执行,否则直接在IDEA里面引入即可] --

```shell
# gpg加密签名插件
mvn install:install-file -Dfile=docs/maven-gpg-plugin-1.6.jar -DgroupId=org.apache.maven.plugins -DartifactId=maven-gpg-plugin -Dversion=1.6 -Dpackaging=jar

#javadoc 文档注释修复插件  http://www.mojohaus.org/clirr-maven-plugin/usage.html
mvn install:install-file -Dfile=docs/clirr-maven-plugin-2.8.jar -DgroupId=org.codehaus.mojo -DartifactId=clirr-maven-plugin -Dversion=2.8 -Dpackaging=jar

mvn install:install-file -Dfile=docs/maven-javadoc-plugin-3.1.1.jar -DgroupId=org.apache.maven.plugins -DartifactId=maven-javadoc-plugin -Dversion=3.1.1 -Dpackaging=jar


mvn install:install-file -Dfile=docs/maven-deploy-plugin-3.0.0-M1.jar -DgroupId=org.apache.maven.plugins -DartifactId=maven-deploy-plugin -Dversion=3.0.0-M1 -Dpackaging=jar

mvn install:install-file -Dfile=docs/maven-source-plugin-3.2.0.jar -DgroupId=org.apache.maven.plugins -DartifactId=maven-source-plugin -Dversion=3.2.0 -Dpackaging=jar

```

