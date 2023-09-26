package org.example.stats;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.example.stats.StatsFilter.LONG_ADDER;

@RequestMapping("/api/v1/stats")
@RestController
class StatsResource {
    @GetMapping
    long getRequestsCount() {
        return LONG_ADDER.sum();
    }
}
