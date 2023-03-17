#!/usr/bin/env bash
# Environment Variables
# MODULE

echo "Checking if hub is ready - $HUB_HOST"


	sleep 10

# start the java command
java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* org.testng.TestNG $MODULE