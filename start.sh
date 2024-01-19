#!/bin/bash

compose_service_name="rabbitmq"

function start_rabbitmq_container() {
    echo
    echo

    echo "### >> Start RabbitMQ Container."

    docker compose --env-file .env up -d $compose_service_name
    
    echo
    echo "### >> Done."
    echo
}

function status_docker_container() {
    echo
    echo

    echo "### >> Status Docker Container."

    docker ps --format "table {{.Names}}\t{{.Image}}\t{{.Status}}\t{{.Ports}}" -f Name=RabbitMQ
    
    echo
    echo "### >> Done."
    echo
}

start_rabbitmq_container
status_docker_container
