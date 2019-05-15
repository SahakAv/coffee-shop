FROM frolvlad/alpine-oraclejdk8:slim
RUN mkdir /logging
ADD ./logback.xml /logging
ENV JAVA_OPTS -Xmx512M -Xms512M

VOLUME /tmp
COPY app.jar /
ENTRYPOINT [ "sh", "-c", "java -Dlogging.config=/logging/logback.xml $JAVA_OPTS  -jar app.jar" ]
