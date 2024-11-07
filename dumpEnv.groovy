#!/usr/bin/env groovy

void call() {
    def shellEnvironment = readProperties text: sh(script: 'printenv', returnStdout: true)
    shellEnvironment.remove('_')
    shellEnvironment.remove('P4_TICKET') // Let's not log secrets
    def envVars = "Environment variables:\n"
    shellEnvironment.sort().each{ k, v -> envVars += "\t${k}: ${v}\n" }
    print envVars
}
