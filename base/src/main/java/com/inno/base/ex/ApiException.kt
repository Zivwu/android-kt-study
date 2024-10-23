package com.inno.base.ex

class ApiException(val code: Int, message: String?) : RuntimeException(message)