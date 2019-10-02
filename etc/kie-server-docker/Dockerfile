FROM registry.redhat.io/rhpam-7/rhpam74-kieserver-openshift
COPY ../flight-service/target/flight-service-1.0.war /opt/eap/standalone/deployments/
COPY ../hotel-service/target/hotel-service-1.0.war /opt/eap/standalone/deployments/
USER root
RUN chown jboss:jboss -R /home/jboss
RUN chmod -R 777 /home/jboss
RUN /opt/eap/bin/add-user.sh -a -u 'user1' -p 'bpms' -g 'user,kie-server,rest-task,rest-query,agent'
RUN /opt/eap/bin/add-user.sh -a -u 'jboss' -p 'bpms' -g 'admin,analyst,user,kie-server,rest-all'
RUN /opt/eap/bin/add-user.sh -a -u 'busadmin' -p 'bpms' -g 'Administrators,analyst,user,kie-server,rest-all'

