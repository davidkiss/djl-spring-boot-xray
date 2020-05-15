package com.kaviddiss.djldemo.web;

import com.kaviddiss.djldemo.service.Covid19Service;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class Covid19Controller {
    private final Covid19Service covid19Service;

    public Covid19Controller(Covid19Service covid19Service) {
        this.covid19Service = covid19Service;
    }

    @GetMapping("/covid19/diagnose")
    public ResponseEntity diagnose(@RequestParam String imageUrl) {
        String answer = covid19Service.diagnose(imageUrl);
        return ResponseEntity.ok(Collections.singletonMap("result", answer));
    }
}
