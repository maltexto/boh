FROM quay.io/wildfly/wildfly

COPY target/boh.war /opt/jboss/wildfly/standalone/deployments/