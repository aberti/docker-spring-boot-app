#!/bin/bash
xvfb-run --server-args=":1 -screen 0 1024x768x16 -ac" \
java -jar selenium-server-standalone-${VERSION}.jar \
-role node \
-platform LINUX \
-hub http://$HUB_1_PORT_4444_TCP_ADDR:4444/grid/register \
-browserName firefox