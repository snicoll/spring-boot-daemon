@echo off

java -Dspring.application.admin.enabled=true -Dcom.sun.management.jmxremote.port=@dist.jmx.port@ -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -jar -Dloader.main=net.nicoll.boot.daemon.StartSpringBootService @dist.jar@ @dist.start.class@
