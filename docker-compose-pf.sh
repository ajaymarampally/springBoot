#!/bin/bash
export PROMETHEUS_CONFIG_PATH=/home/springBoot/prometheus/prometheus.yml
# Run the docker-compose command with the appropriate platform
sudo /usr/local/bin/docker-compose up -d
