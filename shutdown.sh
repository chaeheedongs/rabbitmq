#!/bin/bash

compose_service_name="rabbitmq"

function shutdown_rabbitmq_container() {
    echo
    echo

    echo "### >> shutdown RabbitMQ Container."

    docker compose down $compose_service_name

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

shutdown_rabbitmq_container
status_docker_container
