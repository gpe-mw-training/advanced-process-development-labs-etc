#!/bin/bash

# Usage: execute-admin-server.sh [configuration file]
#
# The default configuration is standalone-openshift.xml.

echo "=> Executing Customization script"

JBOSS_HOME=/opt/eap
JBOSS_CLI=$JBOSS_HOME/bin/jboss-cli.sh
JBOSS_CONFIG=${1:-"standalone-openshift.xml"}

function wait_for_server() {
  until `$JBOSS_CLI -c ":read-attribute(name=server-state)" 2> /dev/null | grep -q running`; do
    sleep 1
  done
}

echo "=> Starting EAP server"

echo "JBOSS_HOME  : " $JBOSS_HOME
echo "JBOSS_CLI   : " $JBOSS_CLI
echo "JBOSS_CONFIG: " $JBOSS_CONFIG

echo $JBOSS_HOME/bin/standalone.sh --admin-only -c $JBOSS_CONFIG &
$JBOSS_HOME/bin/standalone.sh --admin-only -c $JBOSS_CONFIG &

echo "=> Waiting for the server to boot"
wait_for_server

echo "=> Executing the commands"
$JBOSS_CLI -c --file=/tmp/mail-setup.txt

echo "=> Shutting down WildFly"
$JBOSS_CLI -c ":shutdown"