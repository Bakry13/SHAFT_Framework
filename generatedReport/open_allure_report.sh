#!/bin/bash
parent_path=$( cd '$(dirname '${BASH_SOURCE[0]}')' ; pwd -P )
cd '$parent_path/allure/allure-2.20.1/bin/'
bash allure serve '$parent_path/allure-results'
exit