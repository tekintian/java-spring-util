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





## 完整配置示例:



~~~xml

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>cn.tekin.spring</groupId>
    <artifactId>util</artifactId>
    <version>v0.1.1</version>
    <name>util</name>
    <description>project for spring boot project , include date util , json util, ObjectCopy util etc.</description>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
       
    </dependencies>
    <!--maven中心仓库发布配置-->
    <licenses>
        <license>
            <name>The Apache Software License, Version 2.0</name>
            <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
        </license>
    </licenses>
    <developers>
        <developer>
            <name>TekinTian</name>
            <email>tekintian@gmail.com</email>
        </developer>
    </developers>
    <scm>
        <connection>scm:git@github.com:tekintian/java-spring-util.git</connection>
        <developerConnection>scm:git@github.com:tekintian/java-spring-util.git</developerConnection>
        <url>https://github.com:tekintian/java-spring-util</url>
    </scm>

    <profiles>
        <profile>
            <id>release</id>
            <activation>
                <jdk>[1.8,)</jdk>
            </activation>

            <build>

                <plugins>
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-compiler-plugin</artifactId>
                        <version>2.3.1</version>
                        <configuration>
                            <source>1.8</source>
                            <target>1.8</target>
                            <encoding>UTF-8</encoding>
                        </configuration>
                    </plugin>
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-surefire-plugin</artifactId>
                        <version>2.17</version>
                        <configuration>
                            <!--跳过测试-->
<!--                            <skipTests>true</skipTests>-->
                        </configuration>
                    </plugin>
                    <!-- Source -->
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-source-plugin</artifactId>
                        <executions>
                            <execution>
                                <phase>package</phase>
                                <goals>
                                    <goal>jar-no-fork</goal>
                                </goals>
                            </execution>
                        </executions>
                        <!--排除目录/文件配置-->
                        <configuration>
                          <excludes>
                            <exclude>**/spring/</exclude>
                            <exclude>**/cn.tekin.spring.util.UtilApplication/</exclude>
                            <exclude>**/META-INF/*.kotlin_module</exclude>
                          </excludes>
                        </configuration>
                    </plugin>
                    <!-- Javadoc -->
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-javadoc-plugin</artifactId>
                        <version>3.1.1</version>
                        <executions>
                            <execution>
                                <id>attach-javadocs</id> <!-- The actual id should be apparent from maven output -->
                                <goals>
                                    <goal>jar</goal>
                                </goals>
                                <configuration>
                                    <!--遇到错误继续执行-->
                                    <failOnError>false</failOnError>
                                </configuration>
                            </execution>
                        </executions>
                        <configuration>
                            <!--跳过检查doc注释的规范性详见
                            https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html#BEJEFABE
                            -->
                            <!-- <doclint>accessibility,reference,missing</doclint>-->
                            <tags>
                                <!--自定义标签增加-->
                                <tag>
                                    <name>create</name>
                                    <placement>a</placement> <!-- Author tag for all places -->
                                    <head>create tag ignore:</head>
                                </tag>
                            </tags>
                            <!--排除包配置-->
<!--                            <excludePackageNames>cn.tekin.spring.entity</excludePackageNames>-->
                        </configuration>
                    </plugin>
                    <!--javadoc 文档修复插件 mvn javadoc:fix -->
                    <plugin>
                        <groupId>org.codehaus.mojo</groupId>
                        <artifactId>clirr-maven-plugin</artifactId>
                        <version>2.8</version>
                    </plugin>
                    <!-- GPG -->
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-gpg-plugin</artifactId>
                        <version>1.6</version>
                        <executions>
                            <execution>
                                <phase>verify</phase>
                                <goals>
                                    <goal>sign</goal>
                                </goals>
                            </execution>
                        </executions>
                    </plugin>

                    <!--deploy-->
                    <plugin>
                        <!-- explicitly define maven-deploy-plugin after other to force exec
                           order -->
                        <artifactId>maven-deploy-plugin</artifactId>
                        <executions>
                            <execution>
                                <id>deploy</id>
                                <phase>deploy</phase>
                                <goals>
                                    <goal>deploy</goal>
                                </goals>
                            </execution>
                        </executions>
                    </plugin>
                </plugins>
                <!--指定构建的资源-->
                <resources>
                    <resource>
                        <directory>src/main/java</directory>
                        <includes>
                            <include>**/*.dic</include>
                            <include>**/*.xml</include>
                        </includes>
                    </resource>
                    <resource>
                        <directory>src/main/resources</directory>
                    </resource>
                </resources>
            </build>

            <distributionManagement>
                <snapshotRepository>
                    <id>sonatype-nexus-snapshots</id>
                    <url>https://oss.sonatype.org/content/repositories/snapshots/</url>
                </snapshotRepository>
                <repository>
                    <id>sonatype-nexus-staging</id>
                    <url>https://oss.sonatype.org/service/local/staging/deploy/maven2/</url>
                </repository>
            </distributionManagement>
        </profile>
    </profiles>

    <reporting>
        <plugins>
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>clirr-maven-plugin</artifactId>
                <version>2.8</version>
            </plugin>
        </plugins>
    </reporting>
    
    
</project>

~~~







