package com.konivan.domain;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Getter
public class ProjectInfo {
    @Setter
    private String name;
    @Setter
    private String description;
    private LocalDate creationDate;
    private String id;

    public ProjectInfo (LocalDate creationDate, String id) {
        this.creationDate = creationDate;
        this.id = id;
    }


}
