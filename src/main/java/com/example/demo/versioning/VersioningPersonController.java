package com.example.demo.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
    
    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Shreya Gupta");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2(new Name("Shreya", "Gupta"));
    }

    //Request Parameter Versioning
    @GetMapping(path="/person", params="version=1")
    public PersonV1 getFirstVersionOfPersonRequestParameter(){
        return new PersonV1("Shreya Gupta");
    }

    @GetMapping(path="/person", params="version=2")
    public PersonV2 getSecondVersionOfPersonRequestParameter(){
        return new PersonV2(new Name("Shreya", "Gupta"));
    }

    //Custom header Versioning
    @GetMapping(path="/person/header", headers = "X-API-VERSION =1")
    public PersonV1 getFirstVersionOfPersonRequestParameterHeader(){
        return new PersonV1("Shreya Gupta");
    }

    @GetMapping(path="/person/header", headers = "X-API-VERSION =2")
    public PersonV2 getSecondVersionOfPersonRequestParameterHeader(){
        return new PersonV2(new Name("Shreya", "Gupta"));
    }

    //Media Type Versioning Github
    @GetMapping(path="/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonAcceptHeader(){
        return new PersonV1("Shreya Gupta");
    }

    @GetMapping(path="/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonAcceptHeader(){
        return new PersonV2(new Name("Shreya", "Gupta"));
    }
}
