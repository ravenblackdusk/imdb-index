package org.example.stats;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.concurrent.atomic.LongAdder;

@Component
class StatsFilter extends OncePerRequestFilter {
    static final LongAdder LONG_ADDER = new LongAdder();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        LONG_ADDER.increment();
        filterChain.doFilter(request, response);
    }
}
