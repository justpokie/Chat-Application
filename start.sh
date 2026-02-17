#!/bin/bash
mvn package -DskipTests
java -jar target/*.jar