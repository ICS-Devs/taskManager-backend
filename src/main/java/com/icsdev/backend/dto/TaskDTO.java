package com.icsdev.backend.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {

    private String title;
    private String description;
    private boolean completed;
}
