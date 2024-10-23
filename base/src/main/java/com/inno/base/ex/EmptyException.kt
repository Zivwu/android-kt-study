package com.inno.base.ex

class EmptyException private constructor() : RuntimeException("no more data") {
    companion object {
        val EMPTY = EmptyException();
    }
}