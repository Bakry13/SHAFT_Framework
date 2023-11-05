#!/usr/bin/env groovy
@Library('vfde-ent-devops-shared-lib')_

git_commit=checkout_scm(
  APP_TYPE: "testing"
)

echo "${git_commit}"

//automation_testing() 
testing_trigger(
  REPO_NAME: 'vfde-ent-wtt-qa-automation',
  APP: 'ET'
)
