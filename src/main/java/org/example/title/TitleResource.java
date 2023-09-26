package org.example.title;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/titles")
@RestController
class TitleResource {
    private final TitleService titleService;

    TitleResource(TitleService titleService) {
        this.titleService = titleService;
    }

    @GetMapping("/same-director-and-writer-alive")
    List<String> getSameDirectorAndWriterAlive() {
        return titleService.getSameDirectorAndWriterAlive();
    }

    @GetMapping
    List<String> getByTwoActors(@RequestParam String firstActor, @RequestParam String secondActor) {
        return titleService.getByTwoActors(firstActor, secondActor);
    }

    @GetMapping("/best-in-genre")
    String getBestInGenre(@RequestParam String genre, @RequestParam BestType bestType) {
        return titleService.getBestInGenre(genre, bestType.field);
    }
}
