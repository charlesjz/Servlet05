You need to start RMI registry first before running the service program.
Please also note to add the spring.jar to the classpath in the environment where the rmiregistry is started.

E:\Program Files\IBM\SDP\jdk\bin>rmiregistry 1099

E:\Program Files\IBM\SDP\jdk\bin>echo %CLASSPATH%
E:\Program Files\IBM\WebSphere MQ\java\lib\com.ibm.mqjms.jar;E:\Program Files\IBM\WebSphere MQ\java\lib\com.ibm.mq.jar

E:\Program Files\IBM\SDP\jdk\bin>set CLASSPATH=e:\workshop\spring-framework-1.2\dist\spring.jar;%CLASSPATH%

E:\Program Files\IBM\SDP\jdk\bin>rmiregistry 1099
