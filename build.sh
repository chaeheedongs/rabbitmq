#!/bin/bash

# RabbitMQ Spring Boot

current_path=$PWD
docker_img_name="study/rabbitmq"
docker_img_version="0.0.1"
docker_img_full_name="${docker_img_name}:${docker_img_version}"

compose_service_name="rabbitmq"

function build_docker_img() {
    echo
    echo
    
    echo "### >> Build Docker Images."
    echo

    docker build -t $docker_img_full_name ${current_path}/.
    
    echo
    echo "### >> Done."
    echo
}

function start_rabbitmq_container() {
    echo
    echo

    echo "### >> Start RabbitMQ Container."

    docker compose --env-file ${current_path}/.env up -d $compose_service_name

    echo
    echo "### >> Done."
    echo
}

function print_img() {
    echo
    echo

    echo "### >> Print RabbitMQ Image."
    echo

    docker images $docker_img_name

    echo
    echo "### >> Done."
    echo
}

build_docker_img
print_img
start_rabbitmq_container
