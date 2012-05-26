#!/bin/sh

clear;clear

mvn clean deploy -DperformRelease=true -Dgpg.keyname=EE82F9AB
