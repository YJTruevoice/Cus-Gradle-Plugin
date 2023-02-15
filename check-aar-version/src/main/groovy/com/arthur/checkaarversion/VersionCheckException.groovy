package com.arthur.checkaarversion

class VersionCheckException extends Exception {
    VersionCheckException() {
        super()
    }

    VersionCheckException(String message) {
        super(message)
    }
}