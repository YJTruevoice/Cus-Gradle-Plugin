package com.arthur.plugin

class VersionCheckException extends Exception {
    VersionCheckException() {
        super()
    }

    VersionCheckException(String message) {
        super(message)
    }
}