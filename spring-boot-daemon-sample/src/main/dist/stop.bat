@echo off

java -jar -Dloader.main=net.nicoll.boot.daemon.StopSpringBootService @dist.jar@ @dist.jmx.port@
