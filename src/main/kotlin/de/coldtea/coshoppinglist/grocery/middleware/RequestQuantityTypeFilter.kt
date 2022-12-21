package de.coldtea.coshoppinglist.grocery.middleware

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.slf4j.Logger
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse

@Component
class RequestQuantityTypeFilter: Filter {
    val loggerFactory: Logger = LoggerFactory.getLogger("Quantity type filter")

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val type = request?.getParameter("quantity_type")
        loggerFactory.info("Quantity type filter applied for: $type")

        chain?.doFilter(request, response)
    }
}