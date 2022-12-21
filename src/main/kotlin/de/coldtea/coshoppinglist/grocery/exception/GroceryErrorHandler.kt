package de.coldtea.coshoppinglist.grocery.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class GroceryErrorHandler {

    @ExceptionHandler(GroceryItemNotFound::class)
    fun handleGroceryNotFoundException(
        servletRequest: HttpServletRequest,
        exception: Exception
    ): ResponseEntity<String> {
        return ResponseEntity("Grocery item not found", HttpStatus.NOT_FOUND) // 3
    }
}