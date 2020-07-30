# buildah bud -f etc/kie-server-docker/Dockerfile -t quay.io/rhtgptetraining/rhpam-ks-apd:7.8 .
# podman push quay.io/rhtgptetraining/rhpam-ks-apd:7.8 

FROM registry.redhat.io/rhpam-7/rhpam-kieserver-rhel8:7.8.0-3

# web services
COPY ./flight-service/target/flight-service-1.0.war /opt/eap/standalone/deployments/
COPY ./hotel-service/target/hotel-service-1.0.war /opt/eap/standalone/deployments/
COPY ./etc/kie-server-docker/user-info.properties /home/jboss/data/

USER root
RUN chown jboss:jboss -R /home/jboss
RUN chmod -R 777 /home/jboss
RUN /opt/eap/bin/add-user.sh -a -u 'user1' -p 'bpms' -g 'user,kie-server,rest-task,rest-query,agent'
RUN /opt/eap/bin/add-user.sh -a -u 'jboss' -p 'bpms' -g 'admin,analyst,user,kie-server,rest-all'
RUN /opt/eap/bin/add-user.sh -a -u 'busadmin' -p 'bpms' -g 'Administrators,analyst,user,kie-server,rest-all'
RUN /opt/eap/bin/add-user.sh -a -u 'user10' -p 'bpms' -g 'user,group1,kie-server,rest-task,rest-query'
RUN /opt/eap/bin/add-user.sh -a -u 'user11' -p 'bpms' -g 'user,group1,kie-server,rest-task,rest-query'
RUN /opt/eap/bin/add-user.sh -a -u 'user20' -p 'bpms' -g 'user,group2,kie-server,rest-task,rest-query'
RUN /opt/eap/bin/add-user.sh -a -u 'user21' -p 'bpms' -g 'user,group2,kie-server,rest-task,rest-query'
RUN /opt/eap/bin/add-user.sh -a -u 'user30' -p 'bpms' -g 'user,group3,kie-server,rest-task,rest-query'
RUN /opt/eap/bin/add-user.sh -a -u 'user31' -p 'bpms' -g 'user,group3,kie-server,rest-task,rest-query'
